#!/bin/bash
set -euo pipefail

# Usage: ADO_PAT=<your-pat> ADO_ORG=<your-org> bash tools/setup-ado-full.sh
PAT="${ADO_PAT:?Set ADO_PAT environment variable with your Personal Access Token}"
ORG="${ADO_ORG:?Set ADO_ORG environment variable with your Azure DevOps organization name}"
PROJECT="my-awesome-project"
BASE="https://dev.azure.com/$ORG"

api() { curl -sk -u ":$PAT" -H "Content-Type: application/json" "$@"; }
parse() { python3 -c "import sys,json; d=json.loads(sys.stdin.buffer.read().decode('utf-8-sig')); $1"; }

echo "=== Step 1: Create Agile project ==="
OP_ID=$(api -X POST "$BASE/_apis/projects?api-version=7.1" -d '{
  "name":"my-awesome-project",
  "description":"Test project for azure-devops-java-sdk",
  "visibility":"private",
  "capabilities":{
    "versioncontrol":{"sourceControlType":"Git"},
    "processTemplate":{"templateTypeId":"adcc42ab-9882-485e-a3ed-7678f01f66bc"}
  }
}' | parse "print(d.get('id','FAILED'))")
echo "  Operation: $OP_ID"
echo "  Waiting 15s..."
sleep 15
STATUS=$(api "$BASE/_apis/operations/$OP_ID?api-version=7.1" | parse "print(d.get('status',''))")
echo "  Status: $STATUS"
if [ "$STATUS" != "succeeded" ]; then
  echo "  Waiting 10 more seconds..."
  sleep 10
  STATUS=$(api "$BASE/_apis/operations/$OP_ID?api-version=7.1" | parse "print(d.get('status',''))")
  echo "  Status: $STATUS"
fi

echo ""
echo "=== Step 2: Create testRepository ==="
REPO_ID=$(api -X POST "$BASE/$PROJECT/_apis/git/repositories?api-version=7.1" \
  -d '{"name":"testRepository"}' | parse "print(d.get('id','FAILED'))")
echo "  testRepository ID: $REPO_ID"

echo ""
echo "=== Step 3: Initialize repo with commits ==="
PUSH=$(api -X POST "$BASE/$PROJECT/_apis/git/repositories/$REPO_ID/pushes?api-version=7.1" -d '{
  "refUpdates":[{"name":"refs/heads/main","oldObjectId":"0000000000000000000000000000000000000000"}],
  "commits":[{"comment":"Initial commit","changes":[
    {"changeType":"add","item":{"path":"/README.md"},"newContent":{"content":"# Test Repository","contentType":"rawtext"}},
    {"changeType":"add","item":{"path":"/Test.txt"},"newContent":{"content":"Test file content","contentType":"rawtext"}},
    {"changeType":"add","item":{"path":"/docs/guide.md"},"newContent":{"content":"# Guide","contentType":"rawtext"}}
  ]}]
}')
COMMIT_ID=$(echo "$PUSH" | parse "print(d.get('commits',[{}])[0].get('commitId','FAILED'))")
echo "  Initial commit: $COMMIT_ID"

MAIN_OID=$(api "$BASE/$PROJECT/_apis/git/repositories/$REPO_ID/refs?filter=heads/main&api-version=7.1" | parse "print(d['value'][0]['objectId'])")
echo "  main OID: $MAIN_OID"

echo "  Creating develop branch..."
api -X POST "$BASE/$PROJECT/_apis/git/repositories/$REPO_ID/refs?api-version=7.1" \
  -d "[{\"name\":\"refs/heads/develop\",\"oldObjectId\":\"0000000000000000000000000000000000000000\",\"newObjectId\":\"$MAIN_OID\"}]" > /dev/null

echo "  Creating test branch..."
api -X POST "$BASE/$PROJECT/_apis/git/repositories/$REPO_ID/refs?api-version=7.1" \
  -d "[{\"name\":\"refs/heads/test\",\"oldObjectId\":\"0000000000000000000000000000000000000000\",\"newObjectId\":\"$MAIN_OID\"}]" > /dev/null

echo "  Creating newRepo..."
api -X POST "$BASE/$PROJECT/_apis/git/repositories?api-version=7.1" -d '{"name":"newRepo"}' > /dev/null

echo "  Pushing azure-pipelines.yaml..."
MAIN_OID2=$(api "$BASE/$PROJECT/_apis/git/repositories/$REPO_ID/refs?filter=heads/main&api-version=7.1" | parse "print(d['value'][0]['objectId'])")
api -X POST "$BASE/$PROJECT/_apis/git/repositories/$REPO_ID/pushes?api-version=7.1" -d "{
  \"refUpdates\":[{\"name\":\"refs/heads/main\",\"oldObjectId\":\"$MAIN_OID2\"}],
  \"commits\":[{\"comment\":\"Add pipeline YAML\",\"changes\":[{
    \"changeType\":\"add\",\"item\":{\"path\":\"/azure-pipelines.yaml\"},
    \"newContent\":{\"content\":\"trigger:\\n  - main\\n\\npool:\\n  vmImage: ubuntu-latest\\n\\nsteps:\\n  - script: echo Hello World\\n    displayName: Hello World\",\"contentType\":\"rawtext\"}
  }]}]
}" > /dev/null
echo "  Done with git setup"

echo ""
echo "=== Step 4: Create teams ==="
api -X POST "$BASE/_apis/projects/$PROJECT/teams?api-version=7.1" \
  -d '{"name":"azure-devops-java-sdk Team","description":"Test team"}' | parse "print('  Team:', d.get('name','FAILED'))"
api -X POST "$BASE/_apis/projects/$PROJECT/teams?api-version=7.1" \
  -d '{"name":"myNewTeam","description":"Test team for core"}' | parse "print('  Team:', d.get('name','FAILED'))"

echo ""
echo "=== Step 5: Create work items ==="
wi() {
  api -X POST "$BASE/$PROJECT/_apis/wit/workitems/\$$1?api-version=7.1" \
    -H "Content-Type: application/json-patch+json" \
    -d "[{\"op\":\"add\",\"path\":\"/fields/System.Title\",\"value\":\"$2\"}]" | parse "print(d.get('id','FAILED'))"
}
WI1=$(wi "User Story" "Test User Story 1"); echo "  WI#1 (User Story): $WI1"
WI2=$(wi "Bug" "Test Bug 1"); echo "  WI#2 (Bug): $WI2"
WI3=$(wi "Task" "Test Task 1"); echo "  WI#3 (Task): $WI3"
WI4=$(wi "User Story" "Test User Story 2"); echo "  WI#4 (User Story): $WI4"
WI5=$(wi "Bug" "Test Bug for delete"); echo "  WI#5 (Bug-delete): $WI5"
WI6=$(wi "Bug" "Test Bug for comments"); echo "  WI#6 (Bug-comments): $WI6"
WI7=$(wi "User Story" "Test User Story for update"); echo "  WI#7 (Story-update): $WI7"
WI8=$(wi "User Story" "Test User Story for attachment"); echo "  WI#8 (Story-attach): $WI8"

echo ""
echo "=== Step 6: Create Maven feed ==="
api -X POST "$BASE/$PROJECT/_apis/packaging/feeds?api-version=7.1" \
  -d '{"name":"maven-feed","description":"Maven feed for tests","hideDeletedPackageVersions":true,"upstreamEnabled":true}' | parse "print('  Feed:', d.get('name','FAILED'))"

echo ""
echo "=== Step 7: Create build pipelines ==="
BUILD_DEF_ID=$(api -X POST "$BASE/$PROJECT/_apis/build/definitions?api-version=7.1" -d "{
  \"name\":\"Test-Demo-CI\",\"type\":\"build\",\"quality\":\"definition\",
  \"process\":{\"yamlFilename\":\"azure-pipelines.yaml\",\"type\":2},
  \"repository\":{\"id\":\"$REPO_ID\",\"type\":\"TfsGit\",\"name\":\"testRepository\",\"defaultBranch\":\"refs/heads/main\"},
  \"queue\":{\"name\":\"Azure Pipelines\"}
}" | parse "print(d.get('id','FAILED'))")
echo "  Build Def 'Test-Demo-CI': ID=$BUILD_DEF_ID"

PREVIEW_DEF_ID=$(api -X POST "$BASE/$PROJECT/_apis/build/definitions?api-version=7.1" -d "{
  \"name\":\"Demo-Pipeline-CI\",\"type\":\"build\",\"quality\":\"definition\",
  \"process\":{\"yamlFilename\":\"azure-pipelines.yaml\",\"type\":2},
  \"repository\":{\"id\":\"$REPO_ID\",\"type\":\"TfsGit\",\"name\":\"testRepository\",\"defaultBranch\":\"refs/heads/main\"},
  \"queue\":{\"name\":\"Azure Pipelines\"}
}" | parse "print(d.get('id','FAILED'))")
echo "  Preview pipeline 'Demo-Pipeline-CI': ID=$PREVIEW_DEF_ID"

echo ""
echo "=== Step 8: Queue a build ==="
BUILD_ID=$(api -X POST "$BASE/$PROJECT/_apis/build/builds?api-version=7.1" \
  -d "{\"definition\":{\"id\":$BUILD_DEF_ID}}" | parse "print(d.get('id','FAILED'))")
echo "  Build queued: ID=$BUILD_ID"

sleep 3
PIPELINE_RUN_ID=$(api "$BASE/$PROJECT/_apis/pipelines/$BUILD_DEF_ID/runs?api-version=7.1" | parse "v=d.get('value',[]); print(v[0]['id'] if v else 'NONE')")
echo "  Pipeline run: ID=$PIPELINE_RUN_ID"

echo ""
echo "========================================="
echo "=== SETUP COMPLETE ==="
echo "========================================="
echo ""
echo "config.json values:"
echo "  builds.definitionId: $BUILD_DEF_ID"
echo "  pipelines.id: $BUILD_DEF_ID"
echo "  pipelines.runId: $PIPELINE_RUN_ID"
echo "  pipelines.previewPipelineId: $PREVIEW_DEF_ID"
echo ""
echo "Work Items: #$WI1, #$WI2, #$WI3, #$WI4, #$WI5, #$WI6, #$WI7, #$WI8"
