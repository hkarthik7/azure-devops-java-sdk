package org.azd.accounts.profile;

import org.azd.accounts.types.Profile;
import org.azd.common.ApiVersion;
import org.azd.enums.Instance;
import org.azd.exceptions.AzDException;
import org.azd.http.RequestInformation;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to manage Profile Api.
 */
public class ProfileRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates the profile request builder with default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public ProfileRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "profile/profiles", ApiVersion.PROFILE);
    }

    /**
     * Get the current user profile.
     * @return Returns a future object of {@link Profile}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Profile> get() throws AzDException {
        return requestAdapter.sendAsync(toGetRequestInfo("me"), Profile.class);
    }

    /**
     * Get the user profile for given id.
     * @param id ID of the user.
     * @return Returns a future object of {@link Profile}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Profile> get(String id) throws AzDException {
        Objects.requireNonNull(id, "Id cannot be null or empty.");
        return requestAdapter.sendAsync(toGetRequestInfo(id), Profile.class);
    }

    /**
     * Constructs the request information for Profile Api.
     * @param id ID of the user.
     * @return RequestInformation Object {@link RequestInformation}
     */
    private RequestInformation toGetRequestInfo(String id) {
        var requestInfo = toGetRequestInformation();
        requestInfo.setRequestUrl(MessageFormat.format("{0}/_apis/{1}/{2}?api-version={3}",
                Instance.ACCOUNT_INSTANCE.getInstance(), service, id, apiVersion));
        return requestInfo;
    }
}
