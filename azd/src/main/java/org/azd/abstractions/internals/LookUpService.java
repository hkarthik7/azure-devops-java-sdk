package org.azd.abstractions.internals;

import org.azd.authentication.AccessTokenCredential;
import org.azd.common.types.ResourceAreas;
import org.azd.exceptions.AzDException;
import org.azd.http.ClientRequest;
import org.azd.utils.StringUtils;

import java.util.Locale;
import java.util.Objects;

/**
 * Determines the resource area.
 */
public class LookUpService {
    /**
     * Location GUID to determine the URL of resource area.
     */
    private final static String id = "e81700f7-3be2-46de-8624-2eb35882fcaa";
    private final static String area = "location";
    private final AccessTokenCredential accessTokenCredential;

    private LookUpService(AccessTokenCredential accessTokenCredential) {
        this.accessTokenCredential = accessTokenCredential;
    }

    /**
     * Get the instance of lookup service.
     *
     * @param accessTokenCredential Access token credential object.
     * @return Lookup service object {@link LookUpService}.
     */
    public static LookUpService getInstance(AccessTokenCredential accessTokenCredential) {
        Objects.requireNonNull(accessTokenCredential);
        return new LookUpService(accessTokenCredential);
    }

    /**
     * Get the resource areas for given url.
     *
     * @param organizationUrl Organisation url. E.g., https://dev.azure.com/{organisation}
     * @return Resource areas object {@link ResourceAreas}.
     */
    public ResourceAreas resourceAreas(String organizationUrl) {
        return ClientRequest.builder(accessTokenCredential)
                .baseInstance(organizationUrl)
                .area(area)
                .location(id)
                .build()
                .executeAsync(ResourceAreas.class)
                .join();
    }

    /**
     * Get the location url for given base url and resource id.
     *
     * @param organizationUrl Organisation url. E.g., https://dev.azure.com/{organisation}
     * @param resourceId      GUID of the resource such as release, git etc.
     * @return Location url.
     */
    public String locationUrl(String organizationUrl, String resourceId) throws AzDException {
        if (resourceId == null) return organizationUrl;
        var resAreas = resourceAreas(organizationUrl);

        if (resAreas == null ||
                resAreas.getResourceAreas().size() == 0 ||
                StringUtils.isEmpty((String) resAreas.getResponse().getResponseBody()))
            return organizationUrl;

        for (var resArea : resAreas.getResourceAreas())
            if (resArea.getId().toLowerCase(Locale.ROOT)
                    .equals(resourceId.toLowerCase(Locale.ROOT)))
                return resArea.getLocationUrl();

        throw new AzDException("Couldn't find information for resource " + resourceId + "from " + organizationUrl);
    }
}
