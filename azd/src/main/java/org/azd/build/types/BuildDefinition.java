package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildDefinition {
    @JsonProperty("options")
    private List<Options> options;
    @JsonProperty("triggers")
    private List<Triggers> triggers;
    @JsonProperty("jobAuthorizationScope")
    private String jobAuthorizationScope;
    @JsonProperty("jobTimeoutInMinutes")
    private int jobTimeoutInMinutes;
    @JsonProperty("jobCancelTimeoutInMinutes")
    private int jobCancelTimeoutInMinutes;
    @JsonProperty("badgeEnabled")
    private boolean badgeEnabled;
    @JsonProperty("process")
    private Process process;
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("path")
    private String path;
    @JsonProperty("type")
    private String type;
    @JsonProperty("queueStatus")
    private String queueStatus;
    @JsonProperty("revision")
    private int revision;
    @JsonProperty("createdDate")
    private String createdDate;

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }

    public List<Triggers> getTriggers() {
        return triggers;
    }

    public void setTriggers(List<Triggers> triggers) {
        this.triggers = triggers;
    }

    public String getJobAuthorizationScope() {
        return jobAuthorizationScope;
    }

    public void setJobAuthorizationScope(String jobAuthorizationScope) {
        this.jobAuthorizationScope = jobAuthorizationScope;
    }

    public int getJobTimeoutInMinutes() {
        return jobTimeoutInMinutes;
    }

    public void setJobTimeoutInMinutes(int jobTimeoutInMinutes) {
        this.jobTimeoutInMinutes = jobTimeoutInMinutes;
    }

    public int getJobCancelTimeoutInMinutes() {
        return jobCancelTimeoutInMinutes;
    }

    public void setJobCancelTimeoutInMinutes(int jobCancelTimeoutInMinutes) {
        this.jobCancelTimeoutInMinutes = jobCancelTimeoutInMinutes;
    }

    public boolean isBadgeEnabled() {
        return badgeEnabled;
    }

    public void setBadgeEnabled(boolean badgeEnabled) {
        this.badgeEnabled = badgeEnabled;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQueueStatus() {
        return queueStatus;
    }

    public void setQueueStatus(String queueStatus) {
        this.queueStatus = queueStatus;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "BuildDefinition{" +
                "options=" + options +
                ", triggers=" + triggers +
                ", jobAuthorizationScope='" + jobAuthorizationScope + '\'' +
                ", jobTimeoutInMinutes=" + jobTimeoutInMinutes +
                ", jobCancelTimeoutInMinutes=" + jobCancelTimeoutInMinutes +
                ", badgeEnabled=" + badgeEnabled +
                ", process=" + process +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", uri='" + uri + '\'' +
                ", path='" + path + '\'' +
                ", type='" + type + '\'' +
                ", queueStatus='" + queueStatus + '\'' +
                ", revision=" + revision +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Process {
        @JsonProperty("phases")
        private List<Phases> phases;

        @JsonIgnoreProperties(ignoreUnknown = true)
        private static class Phases {
            @JsonProperty("steps")
            private List<Steps> steps;

            public List<Steps> getSteps() {
                return steps;
            }

            public void setSteps(List<Steps> steps) {
                this.steps = steps;
            }

            @Override
            public String toString() {
                return "Phases{" +
                        "steps=" + steps +
                        '}';
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            private static class Steps {
                @JsonProperty("enabled")
                private boolean enabled;
                @JsonProperty("continueOnError")
                private boolean continueOnError;
                @JsonProperty("alwaysRun")
                private boolean alwaysRun;
                @JsonProperty("displayName")
                private String displayName;
                @JsonProperty("timeoutInMinutes")
                private int timeoutInMinutes;
                @JsonProperty("condition")
                private String condition;
                @JsonProperty("task")
                private Task task;
                @JsonProperty("name")
                private String name;
                @JsonProperty("refName")
                private String refName;
                @JsonProperty("jobAuthorizationScope")
                private String jobAuthorizationScope;


                public boolean isEnabled() {
                    return enabled;
                }

                public void setEnabled(boolean enabled) {
                    this.enabled = enabled;
                }

                public boolean isContinueOnError() {
                    return continueOnError;
                }

                public void setContinueOnError(boolean continueOnError) {
                    this.continueOnError = continueOnError;
                }

                public boolean isAlwaysRun() {
                    return alwaysRun;
                }

                public void setAlwaysRun(boolean alwaysRun) {
                    this.alwaysRun = alwaysRun;
                }

                public String getDisplayName() {
                    return displayName;
                }

                public void setDisplayName(String displayName) {
                    this.displayName = displayName;
                }

                public int getTimeoutInMinutes() {
                    return timeoutInMinutes;
                }

                public void setTimeoutInMinutes(int timeoutInMinutes) {
                    this.timeoutInMinutes = timeoutInMinutes;
                }

                public String getCondition() {
                    return condition;
                }

                public void setCondition(String condition) {
                    this.condition = condition;
                }

                public Task getTask() {
                    return task;
                }

                public void setTask(Task task) {
                    this.task = task;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getRefName() {
                    return refName;
                }

                public void setRefName(String refName) {
                    this.refName = refName;
                }

                public String getJobAuthorizationScope() {
                    return jobAuthorizationScope;
                }

                public void setJobAuthorizationScope(String jobAuthorizationScope) {
                    this.jobAuthorizationScope = jobAuthorizationScope;
                }

                @Override
                public String toString() {
                    return "Steps{" +
                            ", enabled=" + enabled +
                            ", continueOnError=" + continueOnError +
                            ", alwaysRun=" + alwaysRun +
                            ", displayName='" + displayName + '\'' +
                            ", timeoutInMinutes=" + timeoutInMinutes +
                            ", condition='" + condition + '\'' +
                            ", task=" + task +
                            ", name='" + name + '\'' +
                            ", refName='" + refName + '\'' +
                            ", jobAuthorizationScope='" + jobAuthorizationScope + '\'' +
                            '}';
                }

                @JsonIgnoreProperties(ignoreUnknown = true)
                private static class Task {
                    @JsonProperty("id")
                    private String id;
                    @JsonProperty("versionSpec")
                    private String versionSpec;
                    @JsonProperty("definitionType")
                    private String definitionType;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getVersionSpec() {
                        return versionSpec;
                    }

                    public void setVersionSpec(String versionSpec) {
                        this.versionSpec = versionSpec;
                    }

                    public String getDefinitionType() {
                        return definitionType;
                    }

                    public void setDefinitionType(String definitionType) {
                        this.definitionType = definitionType;
                    }

                    @Override
                    public String toString() {
                        return "Task{" +
                                "id='" + id + '\'' +
                                ", versionSpec='" + versionSpec + '\'' +
                                ", definitionType='" + definitionType + '\'' +
                                '}';
                    }
                }
            }
        }
    }



    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Triggers {
        @JsonProperty("branchFilters")
        private List<String> branchFilters;
        @JsonProperty("batchChanges")
        private boolean batchChanges;
        @JsonProperty("maxConcurrentBuildsPerBranch")
        private int maxConcurrentBuildsPerBranch;
        @JsonProperty("pollingInterval")
        private int pollingInterval;
        @JsonProperty("triggerType")
        private String triggerType;

        public List<String> getBranchFilters() {
            return branchFilters;
        }

        public void setBranchFilters(List<String> branchFilters) {
            this.branchFilters = branchFilters;
        }

        public boolean isBatchChanges() {
            return batchChanges;
        }

        public void setBatchChanges(boolean batchChanges) {
            this.batchChanges = batchChanges;
        }

        public int getMaxConcurrentBuildsPerBranch() {
            return maxConcurrentBuildsPerBranch;
        }

        public void setMaxConcurrentBuildsPerBranch(int maxConcurrentBuildsPerBranch) {
            this.maxConcurrentBuildsPerBranch = maxConcurrentBuildsPerBranch;
        }

        public int getPollingInterval() {
            return pollingInterval;
        }

        public void setPollingInterval(int pollingInterval) {
            this.pollingInterval = pollingInterval;
        }

        public String getTriggerType() {
            return triggerType;
        }

        public void setTriggerType(String triggerType) {
            this.triggerType = triggerType;
        }

        @Override
        public String toString() {
            return "Triggers{" +
                    "branchFilters=" + branchFilters +
                    ", batchChanges=" + batchChanges +
                    ", maxConcurrentBuildsPerBranch=" + maxConcurrentBuildsPerBranch +
                    ", pollingInterval=" + pollingInterval +
                    ", triggerType='" + triggerType + '\'' +
                    '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Options {
        private boolean enabled;
        private Definition definition;
        private Inputs inputs;

        @JsonIgnoreProperties(ignoreUnknown = true)
        private static class Definition {
            @JsonProperty("id")
            private String id;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            @Override
            public String toString() {
                return "Definition{" +
                        "id='" + id + '\'' +
                        '}';
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        private static class Inputs {
            @JsonProperty("branchFilters")
            private String branchFilters;
            @JsonProperty("workItemType")
            private String workItemType;
            @JsonProperty("assignToRequestor")
            private String assignToRequestor;

            public String getBranchFilters() {
                return branchFilters;
            }

            public void setBranchFilters(String branchFilters) {
                this.branchFilters = branchFilters;
            }

            public String getWorkItemType() {
                return workItemType;
            }

            public void setWorkItemType(String workItemType) {
                this.workItemType = workItemType;
            }

            public String getAssignToRequestor() {
                return assignToRequestor;
            }

            public void setAssignToRequestor(String assignToRequestor) {
                this.assignToRequestor = assignToRequestor;
            }

            @Override
            public String toString() {
                return "Inputs{" +
                        "branchFilters='" + branchFilters + '\'' +
                        ", workItemType='" + workItemType + '\'' +
                        ", assignToRequestor='" + assignToRequestor + '\'' +
                        '}';
            }
        }
    }
}
