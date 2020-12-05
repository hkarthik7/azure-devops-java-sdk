package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequest {
    @JsonProperty("repository")
    private Repository repository;
    @JsonProperty("pullRequestId")
    private int pullRequestId;
    @JsonProperty("codeReviewId")
    private int codeReviewId;
    @JsonProperty("status")
    private String status;
    @JsonProperty("createdBy")
    private CreatedBy createdBy;
    @JsonProperty("creationDate")
    private String creationDate;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("sourceRefName")
    private String sourceRefName;
    @JsonProperty("targetRefName")
    private String targetRefName;
    @JsonProperty("mergeStatus")
    private String mergeStatus;
    @JsonProperty("isDraft")
    private boolean isDraft;
    @JsonProperty("mergeId")
    private String mergeId;
    @JsonProperty("lastMergeSourceCommit")
    private LastMergeSourceCommit lastMergeSourceCommit;
    @JsonProperty("lastMergeTargetCommit")
    private LastMergeTargetCommit lastMergeTargetCommit;
    @JsonProperty("lastMergeCommit")
    private LastMergeCommit lastMergeCommit;
    @JsonProperty("reviewers")
    private List<Reviewers> reviewers;
    @JsonProperty("url")
    private String url;
    @JsonProperty("supportsIterations")
    private boolean supportsIterations;
    @JsonProperty("artifactId")
    private String artifactId;

    @Override
    public String toString() {
        return "PullRequest{" +
                "repository=" + repository +
                ", pullRequestId=" + pullRequestId +
                ", codeReviewId=" + codeReviewId +
                ", status='" + status + '\'' +
                ", createdBy=" + createdBy +
                ", creationDate='" + creationDate + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", sourceRefName='" + sourceRefName + '\'' +
                ", targetRefName='" + targetRefName + '\'' +
                ", mergeStatus='" + mergeStatus + '\'' +
                ", isDraft=" + isDraft +
                ", mergeId='" + mergeId + '\'' +
                ", lastMergeSourceCommit=" + lastMergeSourceCommit +
                ", lastMergeTargetCommit=" + lastMergeTargetCommit +
                ", lastMergeCommit=" + lastMergeCommit +
                ", reviewers=" + reviewers +
                ", url='" + url + '\'' +
                ", supportsIterations=" + supportsIterations +
                ", artifactId='" + artifactId + '\'' +
                '}';
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public int getPullRequestId() {
        return pullRequestId;
    }

    public void setPullRequestId(int pullRequestId) {
        this.pullRequestId = pullRequestId;
    }

    public int getCodeReviewId() {
        return codeReviewId;
    }

    public void setCodeReviewId(int codeReviewId) {
        this.codeReviewId = codeReviewId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSourceRefName() {
        return sourceRefName;
    }

    public void setSourceRefName(String sourceRefName) {
        this.sourceRefName = sourceRefName;
    }

    public String getTargetRefName() {
        return targetRefName;
    }

    public void setTargetRefName(String targetRefName) {
        this.targetRefName = targetRefName;
    }

    public String getMergeStatus() {
        return mergeStatus;
    }

    public void setMergeStatus(String mergeStatus) {
        this.mergeStatus = mergeStatus;
    }

    public boolean isDraft() {
        return isDraft;
    }

    public void setDraft(boolean draft) {
        isDraft = draft;
    }

    public String getMergeId() {
        return mergeId;
    }

    public void setMergeId(String mergeId) {
        this.mergeId = mergeId;
    }

    public LastMergeSourceCommit getLastMergeSourceCommit() {
        return lastMergeSourceCommit;
    }

    public void setLastMergeSourceCommit(LastMergeSourceCommit lastMergeSourceCommit) {
        this.lastMergeSourceCommit = lastMergeSourceCommit;
    }

    public LastMergeTargetCommit getLastMergeTargetCommit() {
        return lastMergeTargetCommit;
    }

    public void setLastMergeTargetCommit(LastMergeTargetCommit lastMergeTargetCommit) {
        this.lastMergeTargetCommit = lastMergeTargetCommit;
    }

    public LastMergeCommit getLastMergeCommit() {
        return lastMergeCommit;
    }

    public void setLastMergeCommit(LastMergeCommit lastMergeCommit) {
        this.lastMergeCommit = lastMergeCommit;
    }

    public List<Reviewers> getReviewers() {
        return reviewers;
    }

    public void setReviewers(List<Reviewers> reviewers) {
        this.reviewers = reviewers;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isSupportsIterations() {
        return supportsIterations;
    }

    public void setSupportsIterations(boolean supportsIterations) {
        this.supportsIterations = supportsIterations;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Repository {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("url")
        private String url;
        @JsonProperty("project")
        private Project project;
        @JsonProperty("size")
        private int size;
        @JsonProperty("remoteUrl")
        private String remoteUrl;
        @JsonProperty("sshUrl")
        private String sshUrl;
        @JsonProperty("webUrl")
        private String webUrl;

        @Override
        public String toString() {
            return "Repository{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", url='" + url + '\'' +
                    ", project=" + project +
                    ", size=" + size +
                    ", remoteUrl='" + remoteUrl + '\'' +
                    ", sshUrl='" + sshUrl + '\'' +
                    ", webUrl='" + webUrl + '\'' +
                    '}';
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Project getProject() {
            return project;
        }

        public void setProject(Project project) {
            this.project = project;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getRemoteUrl() {
            return remoteUrl;
        }

        public void setRemoteUrl(String remoteUrl) {
            this.remoteUrl = remoteUrl;
        }

        public String getSshUrl() {
            return sshUrl;
        }

        public void setSshUrl(String sshUrl) {
            this.sshUrl = sshUrl;
        }

        public String getWebUrl() {
            return webUrl;
        }

        public void setWebUrl(String webUrl) {
            this.webUrl = webUrl;
        }
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Reviewers {
        @JsonProperty("reviewerUrl")
        private String reviewerUrl;
        @JsonProperty("vote")
        private int vote;
        @JsonProperty("hasDeclined")
        private boolean hasDeclined;
        @JsonProperty("isFlagged")
        private boolean isFlagged;
        @JsonProperty("displayName")
        private String displayName;
        @JsonProperty("url")
        private String url;
        @JsonProperty("id")
        private String id;
        @JsonProperty("uniqueName")
        private String uniqueName;

        @Override
        public String toString() {
            return "Reviewers{" +
                    "reviewerUrl='" + reviewerUrl + '\'' +
                    ", vote=" + vote +
                    ", hasDeclined=" + hasDeclined +
                    ", isFlagged=" + isFlagged +
                    ", displayName='" + displayName + '\'' +
                    ", url='" + url + '\'' +
                    ", id='" + id + '\'' +
                    ", uniqueName='" + uniqueName + '\'' +
                    '}';
        }

        public String getReviewerUrl() {
            return reviewerUrl;
        }

        public void setReviewerUrl(String reviewerUrl) {
            this.reviewerUrl = reviewerUrl;
        }

        public int getVote() {
            return vote;
        }

        public void setVote(int vote) {
            this.vote = vote;
        }

        public boolean isHasDeclined() {
            return hasDeclined;
        }

        public void setHasDeclined(boolean hasDeclined) {
            this.hasDeclined = hasDeclined;
        }

        public boolean isFlagged() {
            return isFlagged;
        }

        public void setFlagged(boolean flagged) {
            isFlagged = flagged;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUniqueName() {
            return uniqueName;
        }

        public void setUniqueName(String uniqueName) {
            this.uniqueName = uniqueName;
        }
    }




    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class LastMergeSourceCommit {
        @JsonProperty("commitId")
        private String commitId;
        @JsonProperty("url")
        private String url;

        public String getCommitId() {
            return commitId;
        }

        public void setCommitId(String commitId) {
            this.commitId = commitId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "LastMergeSourceCommit{" +
                    "commitId='" + commitId + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class LastMergeTargetCommit {
        @JsonProperty("commitId")
        private String commitId;
        @JsonProperty("url")
        private String url;

        public String getCommitId() {
            return commitId;
        }

        public void setCommitId(String commitId) {
            this.commitId = commitId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "LastMergeSourceCommit{" +
                    "commitId='" + commitId + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class LastMergeCommit {
        @JsonProperty("commitId")
        private String commitId;
        @JsonProperty("author")
        private Author author;
        @JsonProperty("committer")
        private Committer committer;
        @JsonProperty("comment")
        private String comment;
        @JsonProperty("url")
        private String url;

        @JsonIgnoreProperties(ignoreUnknown = true)
        private static class Author {
            @JsonProperty("name")
            private String name;
            @JsonProperty("email")
            private String email;
            @JsonProperty("date")
            private String date;

            @Override
            public String toString() {
                return "Author{" +
                        "name='" + name + '\'' +
                        ", email='" + email + '\'' +
                        ", date='" + date + '\'' +
                        '}';
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        private static class Committer {
            @JsonProperty("name")
            private String name;
            @JsonProperty("email")
            private String email;
            @JsonProperty("date")
            private String date;

            @Override
            public String toString() {
                return "Author{" +
                        "name='" + name + '\'' +
                        ", email='" + email + '\'' +
                        ", date='" + date + '\'' +
                        '}';
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class CreatedBy {
        @JsonProperty("displayName")
        private String displayName;
        @JsonProperty("url")
        private String url;
        @JsonProperty("id")
        private String id;
        @JsonProperty("uniqueName")
        private String uniqueName;

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUniqueName() {
            return uniqueName;
        }

        public void setUniqueName(String uniqueName) {
            this.uniqueName = uniqueName;
        }

        @Override
        public String toString() {
            return "CreatedBy{" +
                    "displayName='" + displayName + '\'' +
                    ", url='" + url + '\'' +
                    ", id='" + id + '\'' +
                    ", uniqueName='" + uniqueName + '\'' +
                    '}';
        }
    }






    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Project {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("description")
        private String description;
        @JsonProperty("url")
        private String url;
        @JsonProperty("state")
        private String state;
        @JsonProperty("revision")
        private int revision;
        @JsonProperty("visibility")
        private String visibility;
        @JsonProperty("lastUpdateTime")
        private String lastUpdateTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getRevision() {
            return revision;
        }

        public void setRevision(int revision) {
            this.revision = revision;
        }

        public String getVisibility() {
            return visibility;
        }

        public void setVisibility(String visibility) {
            this.visibility = visibility;
        }

        public String getLastUpdateTime() {
            return lastUpdateTime;
        }

        public void setLastUpdateTime(String lastUpdateTime) {
            this.lastUpdateTime = lastUpdateTime;
        }

        @Override
        public String toString() {
            return "Project{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", url='" + url + '\'' +
                    ", state='" + state + '\'' +
                    ", revision=" + revision +
                    ", visibility='" + visibility + '\'' +
                    ", lastUpdateTime='" + lastUpdateTime + '\'' +
                    '}';
        }

    }
}
