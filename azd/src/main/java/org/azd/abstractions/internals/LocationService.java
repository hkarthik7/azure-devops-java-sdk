package org.azd.abstractions.internals;

import org.azd.authentication.AccessTokenCredential;
import org.azd.common.Constants;
import org.azd.common.types.ApiLocation;
import org.azd.common.types.ApiLocations;
import org.azd.http.ClientRequest;
import org.azd.utils.UrlBuilder;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Determines the Api location based on location url, area and resource id.
 */
public final class LocationService {

    private static final ConcurrentMap<String, LocationService> instances = new ConcurrentHashMap<>();
    private static volatile boolean cacheEnabled = true;

    private final ConcurrentMap<String, Map<String, ApiLocation>> locations = new ConcurrentHashMap<>();
    private final AccessTokenCredential accessTokenCredential;

    /**
     * Default
     *
     * @param accessTokenCredential Access token credential object.
     */
    private LocationService(AccessTokenCredential accessTokenCredential) {
        this.accessTokenCredential = accessTokenCredential;
    }

    /**
     * Get the instance of location service.
     *
     * @param accessTokenCredential Access token credential object.
     * @return LocationService object {@link LocationService}.
     */
    public static LocationService getInstance(
            AccessTokenCredential accessTokenCredential
    ) {
        Objects.requireNonNull(
                accessTokenCredential,
                "Access token cannot be null."
        );
        if (!cacheEnabled) {
            return new LocationService(accessTokenCredential);
        }

        var key = cacheKey(accessTokenCredential);
        return instances.computeIfAbsent(
                key,
                k -> new LocationService(accessTokenCredential)
        );
    }

    public static void setCacheEnabled(boolean enabled) {
        cacheEnabled = enabled;
    }

    public static boolean isCacheEnabled() {
        return cacheEnabled;
    }

    public static void clearCache() {
        instances.clear();
    }

    public static void clearCache(AccessTokenCredential credential) {
        if (credential == null) {
            return;
        }
        instances.remove(cacheKey(credential));
    }

    private static String cacheKey(AccessTokenCredential credential) {
        Objects.requireNonNull(
                credential.getOrganizationUrl(),
                "Organization URL cannot be null."
        );
        return credential.getOrganizationUrl() + "|" + credential.getAccessToken();
    }

    /**
     * Get the location details for given url, area and location id.
     *
     * @param locationUrl Base url of the location. For e.g, https://dev.azure.com/{organisation}
     * @param area        Specify the area i.e., release, git etc.
     * @param locationId  GUID of the location.
     * @return Api location object {@link ApiLocation}.
     */
    public ApiLocation getLocation(String locationUrl, String area, String locationId) {
        if (locations.get(area) == null) getLocations(locationUrl, area);
        return locations.get(area).get(locationId);
    }

    /**
     * Retrieves the location details for given area and base url. This is then cached for later use.
     *
     * @param locationUrl Base url of the location. For e.g, https://dev.azure.com/{organisation}
     * @param area        Specify the area i.e., release, git etc.
     */
    private void getLocations(String locationUrl, String area) {
        Objects.requireNonNull(locationUrl);
        Objects.requireNonNull(area);
        if (locations.get(area) == null) {
            var reqUrl = UrlBuilder
                    .fromBaseUrl(locationUrl)
                    .appendPath(Constants.APIS_RELATIVE_PATH)
                    .appendPath(area)
                    .build();

            ClientRequest.builder(accessTokenCredential)
                    .URI(reqUrl)
                    .OPTIONS()
                    .build()
                    .executeAsync(ApiLocations.class)
                    .thenAcceptAsync(results -> {
                        var resourceAreas = new ConcurrentHashMap<String, ApiLocation>();
                        results.locations.forEach(result ->
                                resourceAreas.put(result.id.toLowerCase(), result)
                        );
                        locations.put(area, resourceAreas);
                    })
                    .join();
        }
        locations.get(area);
    }
}
