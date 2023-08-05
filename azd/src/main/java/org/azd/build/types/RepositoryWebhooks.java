package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

import java.util.List;

/**
 * List of Repository webhooks
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryWebhooks extends SerializableEntity {
    @JsonProperty("value")
    private List<RepositoryWebhook> repositoryWebhooks;

    public List<RepositoryWebhook> getRepositoryWebhooks() {
        return repositoryWebhooks;
    }

    public void setRepositoryWebhooks(List<RepositoryWebhook> repositoryWebhooks) {
        this.repositoryWebhooks = repositoryWebhooks;
    }

}
