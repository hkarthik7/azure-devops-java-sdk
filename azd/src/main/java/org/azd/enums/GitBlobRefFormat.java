package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the blob format for Git blobs Api.
 *
 * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/git/blobs/get-blob?view=azure-devops-rest-7.1&tabs=HTTP">Git Blobs</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum GitBlobRefFormat {
    @JsonProperty("json")
    JSON,
    @JsonProperty("zip")
    ZIP,
    @JsonProperty("text")
    TEXT,
    @JsonProperty("octetstream")
    OCTET_STREAM;
}
