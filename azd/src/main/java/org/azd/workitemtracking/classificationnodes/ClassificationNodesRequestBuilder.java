package org.azd.workitemtracking.classificationnodes;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.enums.ClassificationNodesErrorPolicy;
import org.azd.enums.TreeStructureGroup;
import org.azd.exceptions.AzDException;
import org.azd.workitemtracking.types.WorkItemClassificationNode;
import org.azd.workitemtracking.types.WorkItemClassificationNodes;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Work item tracking classification nodes Api.
 */
public class ClassificationNodesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ClassificationNodesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "wit", "5a172953-1b41-49d3-840a-33f79c3ce89f");
    }

    /**
     * Create new or update an existing classification node.
     *
     * @param structureGroup             Structure group of the classification node, area or iteration.
     * @param workItemClassificationNode Defines a classification node for work item tracking.
     * @return Defines a classification node for work item tracking. {@link WorkItemClassificationNode}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemClassificationNode> createOrUpdateAsync(TreeStructureGroup structureGroup,
                                                                             WorkItemClassificationNode workItemClassificationNode)
            throws AzDException {
        return builder()
                .POST(workItemClassificationNode)
                .serviceEndpoint("structureGroup", structureGroup.toString().toLowerCase())
                .build()
                .executeAsync(WorkItemClassificationNode.class);
    }

    /**
     * Create new or update an existing classification node.
     *
     * @param structureGroup             Structure group of the classification node, area or iteration.
     * @param path                       Path of the classification node.
     * @param workItemClassificationNode Defines a classification node for work item tracking.
     * @return Defines a classification node for work item tracking. {@link WorkItemClassificationNode}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemClassificationNode> createOrUpdateAsync(TreeStructureGroup structureGroup, String path,
                                                                             WorkItemClassificationNode workItemClassificationNode)
            throws AzDException {
        return builder()
                .POST(workItemClassificationNode)
                .serviceEndpoint("structureGroup", structureGroup.toString().toLowerCase())
                .serviceEndpoint("path", path)
                .build()
                .executeAsync(WorkItemClassificationNode.class);
    }

    /**
     * Delete an existing classification node.
     *
     * @param structureGroup Structure group of the classification node, area or iteration.
     * @param path           Path of the classification node.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<Void> deleteAsync(TreeStructureGroup structureGroup, String path)
            throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("structureGroup", structureGroup.toString().toLowerCase())
                .serviceEndpoint("path", path)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Delete an existing classification node.
     *
     * @param structureGroup Structure group of the classification node, area or iteration.
     * @param path           Path of the classification node.
     * @param reclassifyId   Id of the target classification node for reclassification.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<Void> deleteAsync(TreeStructureGroup structureGroup, String path, int reclassifyId)
            throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("structureGroup", structureGroup.toString().toLowerCase())
                .serviceEndpoint("path", path)
                .query("$reclassifyId", reclassifyId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Gets the classification node for a given node path.
     *
     * @param structureGroup Structure group of the classification node, area or iteration.
     * @param path           Path of the classification node.
     * @return Defines a classification node for work item tracking. {@link WorkItemClassificationNode}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemClassificationNode> getAsync(TreeStructureGroup structureGroup, String path)
            throws AzDException {
        return builder()
                .serviceEndpoint("structureGroup", structureGroup.toString().toLowerCase())
                .serviceEndpoint("path", path)
                .build()
                .executeAsync(WorkItemClassificationNode.class);
    }

    /**
     * Gets the classification node for a given node path.
     *
     * @param structureGroup Structure group of the classification node, area or iteration.
     * @param path           Path of the classification node.
     * @param depth          Depth of children to fetch.
     * @return Defines a classification node for work item tracking. {@link WorkItemClassificationNode}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemClassificationNode> getAsync(TreeStructureGroup structureGroup, String path, int depth)
            throws AzDException {
        return builder()
                .serviceEndpoint("structureGroup", structureGroup.toString().toLowerCase())
                .serviceEndpoint("path", path)
                .query("$depth", depth)
                .build()
                .executeAsync(WorkItemClassificationNode.class);
    }

    /**
     * Gets root classification nodes or list of classification nodes for a given list of nodes ids, for a given project.
     * In case ids parameter is supplied you will get list of classification nodes for those ids.
     * Otherwise you will get root classification nodes for this project.
     *
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of WorkItemClassificationNode object {@link WorkItemClassificationNodes}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemClassificationNodes> listAsync(Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .location("a70579d1-f53a-48ee-a5be-7be8659023b9")
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(WorkItemClassificationNodes.class);
    }

    /**
     * Gets root classification nodes under the project.
     *
     * @return Collection of WorkItemClassificationNode object {@link WorkItemClassificationNodes}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemClassificationNodes> listRootAsync()
            throws AzDException {
        return builder()
                .location("a70579d1-f53a-48ee-a5be-7be8659023b9")
                .build()
                .executeAsync(WorkItemClassificationNodes.class);
    }

    /**
     * Gets root classification nodes under the project.
     *
     * @param depth Depth of children to fetch.
     * @return Collection of WorkItemClassificationNode object {@link WorkItemClassificationNodes}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemClassificationNodes> listRootAsync(int depth)
            throws AzDException {
        return builder()
                .location("a70579d1-f53a-48ee-a5be-7be8659023b9")
                .query("$depth", depth)
                .build()
                .executeAsync(WorkItemClassificationNodes.class);
    }

    /**
     * Update an existing classification node.
     *
     * @param structureGroup             Structure group of the classification node, area or iteration.
     * @param path                       Path of the classification node.
     * @param workItemClassificationNode Defines a classification node for work item tracking.
     * @return Defines a classification node for work item tracking. {@link WorkItemClassificationNode}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemClassificationNode> updateAsync(TreeStructureGroup structureGroup, String path,
                                                                     WorkItemClassificationNode workItemClassificationNode)
            throws AzDException {
        return builder()
                .PATCH(workItemClassificationNode)
                .serviceEndpoint("structureGroup", structureGroup.toString().toLowerCase())
                .serviceEndpoint("path", path)
                .build()
                .executeAsync(WorkItemClassificationNode.class);
    }

    /**
     * Create new or update an existing classification node.
     *
     * @param structureGroup             Structure group of the classification node, area or iteration.
     * @param workItemClassificationNode Defines a classification node for work item tracking.
     * @return Defines a classification node for work item tracking. {@link WorkItemClassificationNode}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemClassificationNode createOrUpdate(TreeStructureGroup structureGroup,
                                                     WorkItemClassificationNode workItemClassificationNode)
            throws AzDException {
        return builder()
                .POST(workItemClassificationNode)
                .serviceEndpoint("structureGroup", structureGroup.toString().toLowerCase())
                .build()
                .execute(WorkItemClassificationNode.class);
    }

    /**
     * Create new or update an existing classification node.
     *
     * @param structureGroup             Structure group of the classification node, area or iteration.
     * @param path                       Path of the classification node.
     * @param workItemClassificationNode Defines a classification node for work item tracking.
     * @return Defines a classification node for work item tracking. {@link WorkItemClassificationNode}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemClassificationNode createOrUpdate(TreeStructureGroup structureGroup, String path,
                                                     WorkItemClassificationNode workItemClassificationNode)
            throws AzDException {
        return builder()
                .POST(workItemClassificationNode)
                .serviceEndpoint("structureGroup", structureGroup.toString().toLowerCase())
                .serviceEndpoint("path", path)
                .build()
                .execute(WorkItemClassificationNode.class);
    }

    /**
     * Delete an existing classification node.
     *
     * @param structureGroup Structure group of the classification node, area or iteration.
     * @param path           Path of the classification node.
     * @throws AzDException Default Api exception handler.
     */
    public Void delete(TreeStructureGroup structureGroup, String path)
            throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("structureGroup", structureGroup.toString().toLowerCase())
                .serviceEndpoint("path", path)
                .build()
                .executePrimitive();
    }

    /**
     * Delete an existing classification node.
     *
     * @param structureGroup Structure group of the classification node, area or iteration.
     * @param path           Path of the classification node.
     * @param reclassifyId   Id of the target classification node for reclassification.
     * @throws AzDException Default Api exception handler.
     */
    public Void delete(TreeStructureGroup structureGroup, String path, int reclassifyId)
            throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("structureGroup", structureGroup.toString().toLowerCase())
                .serviceEndpoint("path", path)
                .query("$reclassifyId", reclassifyId)
                .build()
                .executePrimitive();
    }

    /**
     * Gets the classification node for a given node path.
     *
     * @param structureGroup Structure group of the classification node, area or iteration.
     * @param path           Path of the classification node.
     * @return Defines a classification node for work item tracking. {@link WorkItemClassificationNode}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemClassificationNode get(TreeStructureGroup structureGroup, String path)
            throws AzDException {
        return builder()
                .serviceEndpoint("structureGroup", structureGroup.toString().toLowerCase())
                .serviceEndpoint("path", path)
                .build()
                .execute(WorkItemClassificationNode.class);
    }

    /**
     * Gets the classification node for a given node path.
     *
     * @param structureGroup Structure group of the classification node, area or iteration.
     * @param path           Path of the classification node.
     * @param depth          Depth of children to fetch.
     * @return Defines a classification node for work item tracking. {@link WorkItemClassificationNode}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemClassificationNode get(TreeStructureGroup structureGroup, String path, int depth)
            throws AzDException {
        return builder()
                .serviceEndpoint("structureGroup", structureGroup.toString().toLowerCase())
                .serviceEndpoint("path", path)
                .query("$depth", depth)
                .build()
                .execute(WorkItemClassificationNode.class);
    }

    /**
     * Gets root classification nodes or list of classification nodes for a given list of nodes ids, for a given project.
     * In case ids parameter is supplied you will get list of classification nodes for those ids.
     * Otherwise you will get root classification nodes for this project.
     *
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of WorkItemClassificationNode object {@link WorkItemClassificationNodes}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemClassificationNodes list(Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .location("a70579d1-f53a-48ee-a5be-7be8659023b9")
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(WorkItemClassificationNodes.class);
    }

    /**
     * Gets root classification nodes under the project.
     *
     * @return Collection of WorkItemClassificationNode object {@link WorkItemClassificationNodes}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemClassificationNodes listRoot()
            throws AzDException {
        return builder()
                .location("a70579d1-f53a-48ee-a5be-7be8659023b9")
                .build()
                .execute(WorkItemClassificationNodes.class);
    }

    /**
     * Gets root classification nodes under the project.
     *
     * @param depth Depth of children to fetch.
     * @return Collection of WorkItemClassificationNode object {@link WorkItemClassificationNodes}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemClassificationNodes listRoot(int depth)
            throws AzDException {
        return builder()
                .location("a70579d1-f53a-48ee-a5be-7be8659023b9")
                .query("$depth", depth)
                .build()
                .execute(WorkItemClassificationNodes.class);
    }

    /**
     * Update an existing classification node.
     *
     * @param structureGroup             Structure group of the classification node, area or iteration.
     * @param path                       Path of the classification node.
     * @param workItemClassificationNode Defines a classification node for work item tracking.
     * @return Defines a classification node for work item tracking. {@link WorkItemClassificationNode}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemClassificationNode update(TreeStructureGroup structureGroup, String path,
                                             WorkItemClassificationNode workItemClassificationNode)
            throws AzDException {
        return builder()
                .PATCH(workItemClassificationNode)
                .serviceEndpoint("structureGroup", structureGroup.toString().toLowerCase())
                .serviceEndpoint("path", path)
                .build()
                .execute(WorkItemClassificationNode.class);
    }


    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Comma separated integer classification nodes ids. It's not required, if you want root nodes.
         */
        @QueryParameter(name = "ids")
        public Integer[] ids;
        /**
         * Depth of children to fetch.
         */
        @QueryParameter(name = "$depth")
        public Integer depth;
        /**
         * Flag to handle errors in getting some nodes. Possible options are Fail and Omit.
         */
        @QueryParameter(name = "errorPolicy")
        public ClassificationNodesErrorPolicy errorPolicy;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

}
