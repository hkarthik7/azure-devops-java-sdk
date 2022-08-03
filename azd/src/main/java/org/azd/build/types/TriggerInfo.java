package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Sourceprovider-specific information about what triggered the build
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TriggerInfo extends BaseAbstractMethod {
    /***
     * Represents the commit id
     */
    @JsonProperty("ci.sourceSha")
    private String sourceSha;
    /***
     * Represents the message or description
     */
    @JsonProperty("ci.message")
    private String message;
    /***
     * Detail of the triggered repository
     */
    @JsonProperty("ci.triggerRepository")
    private String triggerRepository;

    public String getSourceSha() {
        return sourceSha;
    }

    public void setSourceSha(String sourceSha) {
        this.sourceSha = sourceSha;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTriggerRepository() {
        return triggerRepository;
    }

    public void setTriggerRepository(String triggerRepository) {
        this.triggerRepository = triggerRepository;
    }

}
