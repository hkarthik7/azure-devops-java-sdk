package org.azd.graph.subjectquery;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.graph.types.GraphEntities;
import org.azd.graph.types.GraphSubjectQuery;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Graph Subject Query Api.
 */
public class SubjectQueryRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public SubjectQueryRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "graph", "05942c89-006a-48ce-bb79-baeb8abf99c6", ApiVersion.GRAPH);
    }

    /**
     * Search for Azure Devops users, or/and groups. Results will be returned in a batch with no more than 100 graph subjects.
     *
     * @param query Graph subject query object to query for.
     * @return Collection of graph entity Object {@link GraphEntities}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<GraphEntities> queryAsync(GraphSubjectQuery query) throws AzDException {
        return builder()
                .POST(query)
                .build()
                .executeAsync(GraphEntities.class);
    }

    /**
     * Search for Azure Devops users, or/and groups. Results will be returned in a batch with no more than 100 graph subjects.
     *
     * @param query Graph subject query object to query for.
     * @return Collection of graph entity Object {@link GraphEntities}
     * @throws AzDException Default Api Exception handler.
     **/
    public GraphEntities query(GraphSubjectQuery query) throws AzDException {
        return builder()
                .POST(query)
                .build()
                .execute(GraphEntities.class);
    }
}
