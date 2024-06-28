package org.azd.security;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.locations.LocationsBaseRequestBuilder;
import org.azd.security.accesscontrolentries.AccessControlEntriesRequestBuilder;
import org.azd.security.accesscontrollists.AccessControlListsRequestBuilder;
import org.azd.security.identities.IdentitiesRequestBuilder;
import org.azd.security.securitynamespaces.SecurityNamespacesRequestBuilder;

/**
 * Provides functionality to work with Security Api.
 */
public class SecurityRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public SecurityRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Security Access control entries Api.
     *
     * @return AccessControlEntriesRequestBuilder {@link AccessControlEntriesRequestBuilder}
     */
    public AccessControlEntriesRequestBuilder accessControlEntries() {
        return new AccessControlEntriesRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Security Access control lists Api.
     *
     * @return AccessControlListsRequestBuilder {@link AccessControlListsRequestBuilder}
     */
    public AccessControlListsRequestBuilder accessControlLists() {
        return new AccessControlListsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Security Access control lists Api.
     *
     * @return SecurityNameSpacesRequestBuilder {@link SecurityNamespacesRequestBuilder}
     */
    public SecurityNamespacesRequestBuilder securityNamespaces() {
        return new SecurityNamespacesRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with legacy Identities lists Api.
     *
     * @return IdentitiesRequestBuilder {@link IdentitiesRequestBuilder}
     */
    public IdentitiesRequestBuilder identities() {
        var location = new LocationsBaseRequestBuilder(organizationUrl, accessTokenCredential);
        var url = location.getUrl("fc3682be-3d6c-427a-87c8-e527b16a1d05");
        return new IdentitiesRequestBuilder(url, accessTokenCredential);
    }
}
