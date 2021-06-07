package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.unboundid.scim2.common.messages.PatchOperation;
import com.unboundid.scim2.common.utils.JsonDiff;
import org.azd.core.CoreVersion;
import org.azd.exceptions.AzDException;
import org.azd.utils.AzDDefaultParameters;
import org.azd.utils.Request;
import org.azd.utils.RequestMethod;
import org.azd.utils.ResourceId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {

    private final ObjectMapper MAPPER = new ObjectMapper();

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
    @JsonProperty("capabilities")
    private Capabilities capabilities;
    @JsonProperty("revision")
    private int revision;
    @JsonProperty("visibility")
    private String visibility;
    @JsonProperty("defaultTeam")
    private DefaultTeam defaultTeam;
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

    public Capabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
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

    public DefaultTeam getDefaultTeam() {
        return defaultTeam;
    }

    public void setDefaultTeam(DefaultTeam defaultTeam) {
        this.defaultTeam = defaultTeam;
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
                ", capabilities=" + capabilities +
                ", revision=" + revision +
                ", visibility='" + visibility + '\'' +
                ", defaultTeam=" + defaultTeam +
                ", lastUpdateTime='" + lastUpdateTime + '\'' +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Capabilities {
        @JsonProperty("processTemplate")
        private ProcessTemplate processTemplate;
        @JsonProperty("versioncontrol")
        private VersionControl versioncontrol;

        public ProcessTemplate getProcessTemplate() {
            return processTemplate;
        }

        public void setProcessTemplate(ProcessTemplate processTemplate) {
            this.processTemplate = processTemplate;
        }

        public VersionControl getVersionControl() {
            return versioncontrol;
        }

        public void setVersionControl(VersionControl versioncontrol) {
            this.versioncontrol = versioncontrol;
        }

        @Override
        public String toString() {
            return "Capabilities{" +
                    "processTemplate=" + processTemplate +
                    ", versioncontrol=" + versioncontrol +
                    '}';
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        private static class VersionControl {
            @JsonProperty("sourceControlType")
            private String sourceControlType;
            @JsonProperty("gitEnabled")
            private boolean gitEnabled;
            @JsonProperty("tfvcEnabled")
            private boolean tfvcEnabled;

            public String getSourceControlType() {
                return sourceControlType;
            }

            public void setSourceControlType(String sourceControlType) {
                this.sourceControlType = sourceControlType;
            }

            public boolean isGitEnabled() {
                return gitEnabled;
            }

            public void setGitEnabled(boolean gitEnabled) {
                this.gitEnabled = gitEnabled;
            }

            public boolean isTfvcEnabled() {
                return tfvcEnabled;
            }

            public void setTfvcEnabled(boolean tfvcEnabled) {
                this.tfvcEnabled = tfvcEnabled;
            }

            @Override
            public String toString() {
                return "VersionControl{" +
                        "sourceControlType='" + sourceControlType + '\'' +
                        ", gitEnabled=" + gitEnabled +
                        ", tfvcEnabled=" + tfvcEnabled +
                        '}';
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        private static class ProcessTemplate {
            @JsonProperty("templateName")
            private String templateName;
            @JsonProperty("templateTypeId")
            private String templateTypeId;

            public String getTemplateName() {
                return templateName;
            }

            public void setTemplateName(String templateName) {
                this.templateName = templateName;
            }

            public String getTemplateTypeId() {
                return templateTypeId;
            }

            public void setTemplateTypeId(String templateTypeId) {
                this.templateTypeId = templateTypeId;
            }

            @Override
            public String toString() {
                return "ProcessTemplate{" +
                        "templateName='" + templateName + '\'' +
                        ", templateTypeId='" + templateTypeId + '\'' +
                        '}';
            }
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class DefaultTeam {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("url")
        private String url;

        @Override
        public String toString() {
            return "DefaultTeam{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", url='" + url + '\'' +
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
    }



    /***
     * Get all workItems in the project with ids in workItemIds (that the authenticated user has access to).
     * @return array of projects {@link Projects}
     */
    public FullWorkitems getWorkitems(Set<Integer> workItemIds, AzDDefaultParameters defaultParameters) {
        if(workItemIds == null || workItemIds.isEmpty()){
            throw new RuntimeException("getWorkitems: list of ids is mandatory");
        }
        String idList = workItemIds.stream().map(f -> f.toString()).collect(Collectors.joining(","));
        //Arrays.stream(ops).map(f -> f.toString()).collect(Collectors.joining(","))
        HashMap<String,Object> queryParam = new HashMap();
        queryParam.put("ids",idList);
        try {
            String r = Request.request(RequestMethod.GET, defaultParameters, ResourceId.CORE, id,
                    "wit/workitems", null, null, CoreVersion.PROJECT_WORK_ITEMS, queryParam, null);

            return MAPPER.readValue(r, FullWorkitems.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

}
