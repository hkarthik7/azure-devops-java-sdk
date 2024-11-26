package org.azd.serviceclient;

import org.azd.authentication.AccessTokenCredential;

import java.util.Objects;

/**
 * Client object instance creation factory class.
 */
public class AzDService {
    /**
     * Access token credential. Can be personal access or bearer token.
     */
    private AccessTokenCredential accessTokenCredential;

    /**
     * Default private constructor.
     */
    private AzDService() {
    }

    /**
     * Creates a new service object.
     *
     * @return AzDService object. {@link AzDService}
     */
    public static AzDService builder() {
        return new AzDService();
    }

    /**
     * Sets the authentication provider. Can be personal access token or OAuth token credential.
     *
     * @param accessTokenCredential Access token credential object. {@link AccessTokenCredential}
     * @return AzDService object.
     */
    public AzDService authentication(AccessTokenCredential accessTokenCredential) {
        Objects.requireNonNull(accessTokenCredential, "Access token credential cannot be null.");
        this.accessTokenCredential = accessTokenCredential;
        return this;
    }

    /**
     * Builds the AzDService client object to work with Apis and configuration.
     *
     * @return AzDServiceClient object. {@link AzDServiceClient}
     */
    public AzDServiceClient buildClient() {
        return new BaseServiceClient(accessTokenCredential);
    }
}
