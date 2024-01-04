package org.azd.accounts.profile;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.accounts.types.Profile;
import org.azd.authentication.AccessTokenCredential;
import org.azd.exceptions.AzDException;
import org.azd.http.ClientRequest;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to manage Profile Api.
 */
public class ProfileRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ProfileRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "profile", "f83735dc-483f-4238-a291-d45f6080a9af");
    }

    /**
     * Get the current user profile.
     *
     * @return Returns a future object of {@link Profile}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Profile> getAsync() throws AzDException {
        return getRequestBuilder("me").executeAsync(Profile.class);
    }

    /**
     * Get the user profile for given id.
     *
     * @param id ID of the user.
     * @return Returns a future object of {@link Profile}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Profile> getAsync(String id) throws AzDException {
        Objects.requireNonNull(id, "Id cannot be null or empty.");
        return getRequestBuilder(id).executeAsync(Profile.class);
    }

    /**
     * Get the current user profile.
     *
     * @return Returns a future object of {@link Profile}
     * @throws AzDException Default Api Exception handler.
     */
    public Profile get() throws AzDException {
        return getRequestBuilder("me").execute(Profile.class);
    }

    /**
     * Get the user profile for given id.
     *
     * @param id ID of the user.
     * @return Returns a future object of {@link Profile}
     * @throws AzDException Default Api Exception handler.
     */
    public Profile get(String id) throws AzDException {
        Objects.requireNonNull(id, "Id cannot be null or empty.");
        return getRequestBuilder(id).execute(Profile.class);
    }

    /**
     * Constructs the request information for Profile Api.
     *
     * @param id ID of the user.
     * @return ClientRequest {@link ClientRequest}
     */
    private ClientRequest getRequestBuilder(String id) {
        return builder()
                .baseInstance(organizationUrl)
                .serviceEndpoint("id", id)
                .build();
    }
}
