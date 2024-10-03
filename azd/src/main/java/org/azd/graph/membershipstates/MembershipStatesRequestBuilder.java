package org.azd.graph.membershipstates;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.graph.types.GraphMembershipState;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Graph Membership States Api.
 */
public class MembershipStatesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public MembershipStatesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "graph", "1ffe5c94-1144-4191-907b-d0211cad36a8",
                ApiVersion.GRAPH);
    }

    /**
     * Check whether a subject is active or inactive.
     *
     * @param subjectDescriptor Descriptor of the subject (user, group, scope, etc.) to check state of
     * @return Graph membership state object {@link GraphMembershipState}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphMembershipState> getAsync(String subjectDescriptor) throws AzDException {
        return builder()
                .serviceEndpoint("subjectDescriptor", subjectDescriptor)
                .build()
                .executeAsync(GraphMembershipState.class);
    }

    /**
     * Check whether a subject is active or inactive.
     *
     * @param subjectDescriptor Descriptor of the subject (user, group, scope, etc.) to check state of
     * @return Graph membership state object {@link GraphMembershipState}
     * @throws AzDException Default Api exception handler.
     */
    public GraphMembershipState get(String subjectDescriptor) throws AzDException {
        return builder()
                .serviceEndpoint("subjectDescriptor", subjectDescriptor)
                .build()
                .execute(GraphMembershipState.class);
    }
}
