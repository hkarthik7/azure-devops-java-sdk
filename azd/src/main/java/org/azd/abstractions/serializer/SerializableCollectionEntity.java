package org.azd.abstractions.serializer;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Collection entity that provides additional functionalities such as next page, continuation token.
 */
public abstract class SerializableCollectionEntity extends SerializableEntity {
    private static String replaceContinuationToken(String url, String continuationToken) {
        try {
            var uri = new URI(url);
            var query = uri.getQuery();
            var isTokenExists = query != null && query.contains("continuationToken=");

            String newQuery;
            if (isTokenExists) {
                newQuery = query.replaceAll("(&|^)continuationToken=[^&]+", "$1continuationToken=" + continuationToken);
            } else {
                newQuery = (query == null || query.isEmpty()) ?
                        "continuationToken=" + continuationToken : query + "&continuationToken=" + continuationToken;
            }
            return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), newQuery, uri.getFragment()).toString();
        } catch (URISyntaxException e) {
            return url;
        }
    }

    /**
     * Retrieves the continuation token from response header. This can then be used for getting the paginated response.
     * Note that not all the Apis return continuation token in the headers. If the header value "x-ms-continuationtoken"
     * is present then it will be returned or an empty string will be returned.
     *
     * @return String value.
     */
    @JsonIgnore
    public String getContinuationToken() {
        String continuationToken = null;
        if (getResponse() != null) continuationToken = getResponse().getContinuationToken();
        return continuationToken;
    }

    @JsonIgnore
    public String getNextPageLink() {
        var continuationToken = getContinuationToken();
        if (continuationToken == null) return null;
        var requestUrl = getResponse().getRequestUrl();
        requestUrl = replaceContinuationToken(requestUrl, continuationToken);
        return requestUrl;
    }
}
