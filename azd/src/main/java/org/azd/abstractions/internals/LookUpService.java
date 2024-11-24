package org.azd.abstractions.internals;

import org.azd.authentication.AccessTokenCredential;
import org.azd.common.types.LocationUrl;
import org.azd.common.types.ResourceAreas;
import org.azd.exceptions.AzDException;
import org.azd.http.ClientRequest;

import java.util.HashMap;
import java.util.Map;
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
    private static final Map<String, LocationUrl> resourceAreasCache = new HashMap<>();
    private static volatile LookUpService instance;
    private final AccessTokenCredential accessTokenCredential;

    private LookUpService(AccessTokenCredential accessTokenCredential) {
        this.accessTokenCredential = accessTokenCredential;
    }

    /**
     * Get the instance of lookup service.
     * @param accessTokenCredential Access token credential object.
     * @return Lookup service object {@link LookUpService}.
     */
    public static LookUpService getInstance(AccessTokenCredential accessTokenCredential) {
        Objects.requireNonNull(accessTokenCredential);
        if (instance == null) {
            synchronized (LookUpService.class) {
                if (instance == null) {
                    instance = new LookUpService(accessTokenCredential);
                }
            }
        }
        return instance;
    }

    /**
     * Get the resource areas for given url.
     * @param organizationUrl Organisation url. E.g., https://dev.azure.com/{organisation}
     * @return Resource areas object {@link ResourceAreas}.
     */
    public ResourceAreas resourceAreas(String organizationUrl) {
        try {
            return ClientRequest.builder(accessTokenCredential)
                    .baseInstance(organizationUrl)
                    .area(area)
                    .location(id)
                    .build()
                    .executeAsync(ResourceAreas.class)
                    .thenApplyAsync(results -> {
                        results.getResourceAreas().forEach(result ->
                                resourceAreasCache.put(result.getId().toLowerCase(), result));
                        return results;
                    })
                    .join();
        } catch (AzDException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get the location url for given base url and resource id.
     * @param organizationUrl Organisation url. E.g., https://dev.azure.com/{organisation}
     * @param resourceId GUID of the resource such as release, git etc.
     * @return Location url.
     */
    public String locationUrl(String organizationUrl, String resourceId) {
        if (resourceId == null) return organizationUrl;
        if (!resourceAreasCache.containsKey(resourceId)) resourceAreas(organizationUrl);
        return resourceAreasCache.get(resourceId).getLocationUrl();
    }
}
