package org.azd.workitemtracking.projectprocessmigration;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.workitemtracking.types.ProcessIdModel;
import org.azd.workitemtracking.types.ProcessMigrationResultModel;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Project process migration  Api.
 */
public class ProjectProcessMigrationBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ProjectProcessMigrationBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "wit", "19801631-d4e5-47e9-8166-0330de0ff1e6", ApiVersion.WORK_ITEM_MIGRATE);
    }

    /**
     * Migrates a project to a different process within the same OOB type.
     * For example, you can only migrate a project from agile/custom-agile to agile/custom-agile.
     *
     * @param processIdModel Stores process ID.
     * @return Project ID and its migrated process ID. {@link ProcessMigrationResultModel}
     * @throws AzDException
     */
    public CompletableFuture<ProcessMigrationResultModel> migrateAsync(ProcessIdModel processIdModel) throws AzDException {
        return builder()
                .POST(processIdModel)
                .build()
                .executeAsync(ProcessMigrationResultModel.class);
    }

    /**
     * Migrates a project to a different process within the same OOB type.
     * For example, you can only migrate a project from agile/custom-agile to agile/custom-agile.
     *
     * @param processIdModel Stores process ID.
     * @return Project ID and its migrated process ID. {@link ProcessMigrationResultModel}
     * @throws AzDException
     */
    public ProcessMigrationResultModel migrate(ProcessIdModel processIdModel) throws AzDException {
        return builder()
                .POST(processIdModel)
                .build()
                .execute(ProcessMigrationResultModel.class);
    }
}
