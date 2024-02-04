package org.azd.graph.memberships;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.GraphTraversalDirection;
import org.azd.exceptions.AzDException;
import org.azd.graph.types.GraphMembership;
import org.azd.graph.types.GraphMemberships;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class MembershipsRequestBuilder extends BaseRequestBuilder {
    public MembershipsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "graph", "3fd2e6ca-fb30-443a-b579-95b19ed0934c",
                ApiVersion.GRAPH);
    }

    /**
     * Create a new membership between a container and subject.
     *
     * @param subjectDescriptor   A descriptor to a group or user that can be the child subject in the relationship.
     * @param containerDescriptor A descriptor to a group that can be the container in the relationship.
     * @return Graph membership object {@link GraphMembership}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphMembership> addAsync(String subjectDescriptor, String containerDescriptor) throws AzDException {
        return builder()
                .PUT(null)
                .serviceEndpoint("subjectDescriptor", subjectDescriptor)
                .serviceEndpoint("containerDescriptor", containerDescriptor)
                .build()
                .executeAsync(GraphMembership.class);
    }

    /**
     * Check to see if a membership relationship between a container and subject exists.
     *
     * @param subjectDescriptor   A descriptor to a group or user that can be the child subject in the relationship.
     * @param containerDescriptor A descriptor to a group that can be the container in the relationship.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<Void> checkExistenceAsync(String subjectDescriptor, String containerDescriptor) throws AzDException {
        return builder()
                .HEAD()
                .serviceEndpoint("subjectDescriptor", subjectDescriptor)
                .serviceEndpoint("containerDescriptor", containerDescriptor)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get a membership relationship between a container and subject.
     *
     * @param subjectDescriptor   A descriptor to a group or user that can be the child subject in the relationship.
     * @param containerDescriptor A descriptor to a group that can be the container in the relationship.
     * @return Graph membership object {@link GraphMembership}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphMembership> getAsync(String subjectDescriptor, String containerDescriptor) throws AzDException {
        return builder()
                .serviceEndpoint("subjectDescriptor", subjectDescriptor)
                .serviceEndpoint("containerDescriptor", containerDescriptor)
                .build()
                .executeAsync(GraphMembership.class);
    }

    /**
     * Get all the memberships where this descriptor is a member in the relationship.
     *
     * <p>
     * <b>NOTE:</b>
     * The default value for direction is 'up' meaning return all memberships where the subject is a member
     * (e.g. all groups the subject is a member of). Alternatively, passing the direction as 'down' will return all
     * memberships where the subject is a container (e.g. all members of the subject group).
     * </P>
     *
     * @param subjectDescriptor A descriptor to a group or user that can be the child subject in the relationship.
     * @return Collection of Graph membership object {@link GraphMemberships}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphMemberships> listAsync(String subjectDescriptor) throws AzDException {
        return builder()
                .serviceEndpoint("subjectDescriptor", subjectDescriptor)
                .build()
                .executeAsync(GraphMemberships.class);
    }

    /**
     * Get all the memberships where this descriptor is a member in the relationship.
     *
     * <p>
     * <b>NOTE:</b>
     * The default value for direction is 'up' meaning return all memberships where the subject is a member
     * (e.g. all groups the subject is a member of). Alternatively, passing the direction as 'down' will return all
     * memberships where the subject is a container (e.g. all members of the subject group).
     * </P>
     *
     * @param subjectDescriptor    A descriptor to a group or user that can be the child subject in the relationship.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Collection of Graph membership object {@link GraphMemberships}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphMemberships> listAsync(String subjectDescriptor,
                                                         Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("subjectDescriptor", subjectDescriptor)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(GraphMemberships.class);
    }

    /**
     * Deletes a membership between a container and subject.
     *
     * @param subjectDescriptor   A descriptor to a group or user that can be the child subject in the relationship.
     * @param containerDescriptor A descriptor to a group that can be the container in the relationship.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String subjectDescriptor, String containerDescriptor) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("subjectDescriptor", subjectDescriptor)
                .serviceEndpoint("containerDescriptor", containerDescriptor)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Create a new membership between a container and subject.
     *
     * @param subjectDescriptor   A descriptor to a group or user that can be the child subject in the relationship.
     * @param containerDescriptor A descriptor to a group that can be the container in the relationship.
     * @return Graph membership object {@link GraphMembership}
     * @throws AzDException Default Api exception handler.
     */
    public GraphMembership add(String subjectDescriptor, String containerDescriptor) throws AzDException {
        return builder()
                .PUT(null)
                .serviceEndpoint("subjectDescriptor", subjectDescriptor)
                .serviceEndpoint("containerDescriptor", containerDescriptor)
                .build()
                .execute(GraphMembership.class);
    }

    /**
     * Check to see if a membership relationship between a container and subject exists.
     *
     * @param subjectDescriptor   A descriptor to a group or user that can be the child subject in the relationship.
     * @param containerDescriptor A descriptor to a group that can be the container in the relationship.
     * @throws AzDException Default Api exception handler.
     */
    public Void checkExistence(String subjectDescriptor, String containerDescriptor) throws AzDException {
        return builder()
                .HEAD()
                .serviceEndpoint("subjectDescriptor", subjectDescriptor)
                .serviceEndpoint("containerDescriptor", containerDescriptor)
                .build()
                .executePrimitive();
    }

    /**
     * Get a membership relationship between a container and subject.
     *
     * @param subjectDescriptor   A descriptor to a group or user that can be the child subject in the relationship.
     * @param containerDescriptor A descriptor to a group that can be the container in the relationship.
     * @return Graph membership object {@link GraphMembership}
     * @throws AzDException Default Api exception handler.
     */
    public GraphMembership get(String subjectDescriptor, String containerDescriptor) throws AzDException {
        return builder()
                .serviceEndpoint("subjectDescriptor", subjectDescriptor)
                .serviceEndpoint("containerDescriptor", containerDescriptor)
                .build()
                .execute(GraphMembership.class);
    }

    /**
     * Get all the memberships where this descriptor is a member in the relationship.
     *
     * <p>
     * <b>NOTE:</b>
     * The default value for direction is 'up' meaning return all memberships where the subject is a member
     * (e.g. all groups the subject is a member of). Alternatively, passing the direction as 'down' will return all
     * memberships where the subject is a container (e.g. all members of the subject group).
     * </P>
     *
     * @param subjectDescriptor A descriptor to a group or user that can be the child subject in the relationship.
     * @return Collection of Graph membership object {@link GraphMemberships}
     * @throws AzDException Default Api exception handler.
     */
    public GraphMemberships list(String subjectDescriptor) throws AzDException {
        return builder()
                .serviceEndpoint("subjectDescriptor", subjectDescriptor)
                .build()
                .execute(GraphMemberships.class);
    }

    /**
     * Get all the memberships where this descriptor is a member in the relationship.
     *
     * <p>
     * <b>NOTE:</b>
     * The default value for direction is 'up' meaning return all memberships where the subject is a member
     * (e.g. all groups the subject is a member of). Alternatively, passing the direction as 'down' will return all
     * memberships where the subject is a container (e.g. all members of the subject group).
     * </P>
     *
     * @param subjectDescriptor    A descriptor to a group or user that can be the child subject in the relationship.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Collection of Graph membership object {@link GraphMemberships}
     * @throws AzDException Default Api exception handler.
     */
    public GraphMemberships list(String subjectDescriptor,
                                 Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("subjectDescriptor", subjectDescriptor)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(GraphMemberships.class);
    }

    /**
     * Deletes a membership between a container and subject.
     *
     * @param subjectDescriptor   A descriptor to a group or user that can be the child subject in the relationship.
     * @param containerDescriptor A descriptor to a group that can be the container in the relationship.
     * @throws AzDException Default Api exception handler.
     */
    public Void delete(String subjectDescriptor, String containerDescriptor) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("subjectDescriptor", subjectDescriptor)
                .serviceEndpoint("containerDescriptor", containerDescriptor)
                .build()
                .executePrimitive();
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * The maximum number of edges to traverse up or down the membership tree. Currently the only supported value is '1'.
         */
        @QueryParameter(name = "depth")
        public Number depth;
        /**
         * Defaults to Up.
         */
        @QueryParameter(name = "direction")
        public GraphTraversalDirection direction;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
