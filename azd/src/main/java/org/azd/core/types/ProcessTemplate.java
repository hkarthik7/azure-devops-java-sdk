package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessTemplate {
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
