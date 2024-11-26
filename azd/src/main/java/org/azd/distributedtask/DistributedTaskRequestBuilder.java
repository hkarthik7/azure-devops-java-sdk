package org.azd.distributedtask;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.distributedtask.agents.AgentsRequestBuilder;
import org.azd.distributedtask.deploymentgroups.DeploymentGroupsRequestBuilder;
import org.azd.distributedtask.environments.EnvironmentsRequestBuilder;
import org.azd.distributedtask.variablegroups.VariableGroupsRequestBuilder;

/**
 * Provides functionalities to work with Distributed Task Api.
 *
 * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/distributedtask/?view=azure-devops-rest-7.1">Azure DevOps Services Pipelines API</a>
 */
public class DistributedTaskRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new DistributedTaskRequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public DistributedTaskRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);

    }

    /**
     * Provides functionality to manage Agents Api.
     *
     * @return AgentsRequestBuilder {@link AgentsRequestBuilder}
     */
    public AgentsRequestBuilder agents() {
        return new AgentsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Deployment groups Api.
     *
     * @return DeploymentGroupsRequestBuilder {@link DeploymentGroupsRequestBuilder}
     */
    public DeploymentGroupsRequestBuilder deploymentGroups() {
        return new DeploymentGroupsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Environments Api.
     *
     * @return EnvironmentsRequestBuilder {@link EnvironmentsRequestBuilder}
     */
    public EnvironmentsRequestBuilder environments() {
        return new EnvironmentsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Variable Groups Api.
     *
     * @return VariableGroupsRequestBuilder {@link VariableGroupsRequestBuilder}
     */
    public VariableGroupsRequestBuilder variableGroups() {
        return new VariableGroupsRequestBuilder(organizationUrl, accessTokenCredential);
    }
}

