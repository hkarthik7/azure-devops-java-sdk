package org.azd.distributedtask;

import org.azd.distributedtask.agents.AgentsRequestBuilder;
import org.azd.distributedtask.deploymentgroups.DeploymentGroupsRequestBuilder;
import org.azd.distributedtask.environments.EnvironmentsRequestBuilder;
import org.azd.distributedtask.variablegroups.VariableGroupsRequestBuilder;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

/**
 * Provides functionalities to work with Distributed Task Api.
 * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/distributedtask/?view=azure-devops-rest-7.1">Azure DevOps Services Pipelines API</a>
 */
public class DistributedTaskRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public DistributedTaskRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage Agents Api.
     * @return AgentsRequestBuilder {@link AgentsRequestBuilder}
     */
    public AgentsRequestBuilder agents() {
        return new AgentsRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage Deployment groups Api.
     * @return DeploymentGroupsRequestBuilder {@link DeploymentGroupsRequestBuilder}
     */
    public DeploymentGroupsRequestBuilder deploymentGroups() {
        return new DeploymentGroupsRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage Environments Api.
     * @return EnvironmentsRequestBuilder {@link EnvironmentsRequestBuilder}
     */
    public EnvironmentsRequestBuilder environments() {
        return new EnvironmentsRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage Variable Groups Api.
     * @return VariableGroupsRequestBuilder {@link VariableGroupsRequestBuilder}
     */
    public VariableGroupsRequestBuilder variableGroups() {
        return new VariableGroupsRequestBuilder(accessTokenCredential, requestAdapter);
    }
}
