package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Visibility status of the view.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum FeedVisibility {
    /***
     * Feed is accessible by all the valid users present in the Azure Active Directory tenant.
     */
    @JsonProperty("aadTenant")
    AADTENANT,
    /***
     * Feed is accessible by all the valid users present in the organization where the feed resides
     * (for example across organization 'myorg' at 'dev.azure.com/myorg')
     */
    @JsonProperty("collection")
    COLLECTION,
    /***
     * Feed is accessible by all the valid users present in the enterprise where the feed resides.
     * Note that legacy naming and back compat leaves the name of this value out of sync with its new meaning.
     */
    @JsonProperty("organization")
    ORGANIZATION,
    /***
     * Only accessible by the permissions explicitly set by the feed administrator.
     */
    @JsonProperty("private")
    PRIVATE
}
