package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * List of Repository webhooks
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryWebhooks extends SerializableCollectionEntity {
    @JsonProperty("value")
    private List<RepositoryWebhook> repositoryWebhooks;

    public List<RepositoryWebhook> getRepositoryWebhooks() {
        return repositoryWebhooks;
    }

    public void setRepositoryWebhooks(List<RepositoryWebhook> repositoryWebhooks) {
        this.repositoryWebhooks = repositoryWebhooks;
    }

}
