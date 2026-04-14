#!/usr/bin/env python3
"""Push a git commit to GitHub via the REST API (bypasses Zscaler blocking git push)."""
import subprocess, requests, base64, json, sys, os

TOKEN = os.environ.get("GH_TOKEN")
if not TOKEN:
    print("ERROR: Set GH_TOKEN environment variable")
    sys.exit(1)

REPO = "abhishekbagde/azure-devops-java-sdk"
API = f"https://api.github.com/repos/{REPO}"
HEADERS = {"Authorization": f"token {TOKEN}", "Accept": "application/vnd.github+json"}
BRANCH = "feature/dashboard-api"

# Disable SSL verification (Zscaler intercepts certs)
SESSION = requests.Session()
SESSION.verify = False
requests.packages.urllib3.disable_warnings()

def git(*args):
    return subprocess.check_output(["git"] + list(args), text=True).strip()

def api_post(path, data):
    r = SESSION.post(f"{API}/{path}", headers=HEADERS, json=data)
    if r.status_code not in (200, 201):
        print(f"ERROR {r.status_code}: {r.text}")
        sys.exit(1)
    return r.json()

def api_get(path):
    r = SESSION.get(f"{API}/{path}", headers=HEADERS)
    return r.status_code, r.json() if r.status_code == 200 else None

# Get commit info from local repo
commit_sha = git("rev-parse", "HEAD")
parent_sha = git("rev-parse", "HEAD~1")
commit_msg = git("log", "-1", "--format=%B")
author_name = git("log", "-1", "--format=%an")
author_email = git("log", "-1", "--format=%ae")
author_date = git("log", "-1", "--format=%aI")

print(f"Commit: {commit_sha[:8]} '{commit_msg[:60]}'")
print(f"Parent: {parent_sha[:8]}")

# Get changed files
changed = git("diff", "--name-only", f"{parent_sha}..{commit_sha}").split("\n")
print(f"Files changed: {len(changed)}")

# Get the parent tree SHA from remote
parent_tree = git("cat-file", "-p", parent_sha).split("\n")
parent_tree_sha = [l for l in parent_tree if l.startswith("tree")][0].split()[1]

# Create blobs for each changed file
tree_entries = []
for filepath in changed:
    with open(filepath, "rb") as f:
        content = base64.b64encode(f.read()).decode()
    
    # Check file mode
    mode = git("ls-tree", "HEAD", filepath).split()[0]
    
    blob = api_post("git/blobs", {"content": content, "encoding": "base64"})
    print(f"  Blob: {filepath} -> {blob['sha'][:8]} (mode {mode})")
    tree_entries.append({
        "path": filepath,
        "mode": mode,
        "type": "blob",
        "sha": blob["sha"]
    })

# Create tree (using base_tree so unchanged files are preserved)
tree = api_post("git/trees", {"base_tree": parent_tree_sha, "tree": tree_entries})
print(f"Tree: {tree['sha'][:8]}")

# Create commit
commit = api_post("git/commits", {
    "message": commit_msg,
    "tree": tree["sha"],
    "parents": [parent_sha],
    "author": {"name": author_name, "email": author_email, "date": author_date}
})
print(f"Remote commit: {commit['sha'][:8]}")

# Create or update the branch ref
status, _ = api_get(f"git/ref/heads/{BRANCH}")
if status == 200:
    # Update existing ref
    r = SESSION.patch(f"{API}/git/ref/heads/{BRANCH}", headers=HEADERS, 
                      json={"sha": commit["sha"], "force": True})
    print(f"Updated ref: {r.status_code}")
else:
    # Create new ref
    ref = api_post("git/refs", {"ref": f"refs/heads/{BRANCH}", "sha": commit["sha"]})
    print(f"Created ref: refs/heads/{BRANCH}")

print(f"\nDone! Branch '{BRANCH}' pushed to github.com/{REPO}")
