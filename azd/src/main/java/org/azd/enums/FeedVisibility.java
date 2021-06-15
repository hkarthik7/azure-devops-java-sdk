package org.azd.enums;

/***
 * aadTenant - Feed is accessible by all the valid users present in the Azure Active Directory tenant.
 * * collection - Feed is accessible by all the valid users present in the organization where the
 * feed resides (for example across organization 'myorg' at 'dev.azure.com/myorg')
 * * organization	- Feed is accessible by all the valid users present in the enterprise where the feed resides.
 * Note that legacy naming and back compat leaves the name of this value out of sync with its new meaning.
 * * private - Only accessible by the permissions explicitly set by the feed administrator.
 */
public enum FeedVisibility {
    AADTENANT, COLLECTION, ORGANIZATION, PRIVATE
}
