package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/**
 * Represents an array of GitPush
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitPushes extends BaseAbstractMethod {
    @JsonProperty("value")
    private List<GitPush> pushes;

    public List<GitPush> getPushes() {
        return pushes;
    }

    public void setPushes(List<GitPush> pushes) {
        this.pushes = pushes;
    }
}
