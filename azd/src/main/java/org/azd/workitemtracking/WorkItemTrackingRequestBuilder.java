package org.azd.workitemtracking;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.workitemtracking.attachments.WorkItemTrackingAttachmentsRequestBuilder;
import org.azd.workitemtracking.classificationnodes.ClassificationNodesRequestBuilder;
import org.azd.workitemtracking.fields.FieldsRequestBuilder;
import org.azd.workitemtracking.projectprocessmigration.ProjectProcessMigrationBuilder;
import org.azd.workitemtracking.queries.QueriesRequestBuilder;
import org.azd.workitemtracking.recyclebin.RecycleBinRequestBuilder;
import org.azd.workitemtracking.revisions.WorkItemRevisionsRequestBuilder;
import org.azd.workitemtracking.tags.WorkItemTagsRequestBuilder;
import org.azd.workitemtracking.workitems.WorkItemsRequestBuilder;

/**
 * Provides functionality to work with Work item tracking Api.
 */
public class WorkItemTrackingRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public WorkItemTrackingRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Work item tracking Api.
     *
     * @return WorkItemsRequestBuilder {@link WorkItemsRequestBuilder}
     */
    public WorkItemsRequestBuilder workItems() {
        return new WorkItemsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Work item attachments Api.
     *
     * @return WorkItemTrackingAttachmentsRequestBuilder {@link WorkItemTrackingAttachmentsRequestBuilder}
     */
    public WorkItemTrackingAttachmentsRequestBuilder attachments() {
        return new WorkItemTrackingAttachmentsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Work item classification nodes Api.
     *
     * @return ClassificationNodesRequestBuilder {@link ClassificationNodesRequestBuilder}
     */
    public ClassificationNodesRequestBuilder classificationNodes() {
        return new ClassificationNodesRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Work item fields Api.
     *
     * @return FieldsRequestBuilder {@link FieldsRequestBuilder}
     */
    public FieldsRequestBuilder fields() {
        return new FieldsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Project process migration Api.
     *
     * @return ProjectProcessMigrationBuilder {@link ProjectProcessMigrationBuilder}
     */
    public ProjectProcessMigrationBuilder projectProcessMigration() {
        return new ProjectProcessMigrationBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Work item queries Api.
     *
     * @return QueriesRequestBuilder {@link QueriesRequestBuilder}
     */
    public QueriesRequestBuilder queries() {
        return new QueriesRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Work item recycle bin Api.
     *
     * @return RecycleBinRequestBuilder {@link RecycleBinRequestBuilder}
     */
    public RecycleBinRequestBuilder recycleBin() {
        return new RecycleBinRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Work item revisions Api.
     *
     * @return WorkItemRevisionsRequestBuilder {@link WorkItemRevisionsRequestBuilder}
     */
    public WorkItemRevisionsRequestBuilder revisions() {
        return new WorkItemRevisionsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Work item tags Api.
     *
     * @return WorkItemTagsRequestBuilder {@link WorkItemTagsRequestBuilder}
     */
    public WorkItemTagsRequestBuilder tags() {
        return new WorkItemTagsRequestBuilder(organizationUrl, accessTokenCredential);
    }


}
