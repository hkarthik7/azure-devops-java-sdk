package org.azd.graph;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.graph.descriptors.DescriptorsRequestBuilder;
import org.azd.graph.groups.GroupsRequestBuilder;
import org.azd.graph.memberships.MembershipsRequestBuilder;
import org.azd.graph.membershipstates.MembershipStatesRequestBuilder;
import org.azd.graph.providerinfo.ProviderInfoRequestBuilder;
import org.azd.graph.serviceprincipals.ServicePrincipalsRequestBuilder;
import org.azd.graph.storagekeys.StorageKeysRequestBuilder;
import org.azd.graph.subjectlookup.SubjectLookupRequestBuilder;
import org.azd.graph.subjectquery.SubjectQueryRequestBuilder;
import org.azd.graph.users.UsersRequestBuilder;

/**
 * Provides functionality to work with Azure DevOps Graph Api.
 */
public class GraphRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public GraphRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "graph", "801eaf9c-0585-4be8-9cdb-b0efa074de91");
    }

    /**
     * Provides functionality to manage Graph Descriptors Api.
     *
     * @return DescriptorsRequestBuilder {@link DescriptorsRequestBuilder}
     */
    public DescriptorsRequestBuilder descriptors() {
        return new DescriptorsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Graph Groups Api.
     *
     * @return GroupsRequestBuilder {@link GroupsRequestBuilder}
     */
    public GroupsRequestBuilder groups() {
        return new GroupsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Graph Membership states Api.
     *
     * @return MembershipStatesRequestBuilder {@link MembershipStatesRequestBuilder}
     */
    public MembershipStatesRequestBuilder membershipStates() {
        return new MembershipStatesRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Graph Memberships Api.
     *
     * @return MembershipsRequestBuilder {@link MembershipsRequestBuilder}
     */
    public MembershipsRequestBuilder memberships() {
        return new MembershipsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Graph Provider info Api.
     *
     * @return ProviderInfoRequestBuilder {@link ProviderInfoRequestBuilder}
     */
    public ProviderInfoRequestBuilder providerInfo() {
        return new ProviderInfoRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Graph Service Principals Api.
     *
     * @return ServicePrincipalsRequestBuilder {@link ServicePrincipalsRequestBuilder}
     */
    public ServicePrincipalsRequestBuilder servicePrincipals() {
        return new ServicePrincipalsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Graph Storage Keys Api.
     *
     * @return StorageKeysRequestBuilder {@link StorageKeysRequestBuilder}
     */
    public StorageKeysRequestBuilder storageKeys() {
        return new StorageKeysRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Graph Subject Lookup Api.
     *
     * @return SubjectLookupRequestBuilder {@link SubjectLookupRequestBuilder}
     */
    public SubjectLookupRequestBuilder subjectLookup() {
        return new SubjectLookupRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Graph Subject Query Api.
     *
     * @return SubjectQueryRequestBuilder {@link SubjectQueryRequestBuilder}
     */
    public SubjectQueryRequestBuilder subjectQuery() {
        return new SubjectQueryRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Graph Users Api.
     *
     * @return UsersRequestBuilder {@link UsersRequestBuilder}
     */
    public UsersRequestBuilder users() {
        return new UsersRequestBuilder(organizationUrl, accessTokenCredential);
    }
}
