package org.azd.accounts;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.accounts.types.Accounts;
import org.azd.authentication.AccessTokenCredential;
import org.azd.exceptions.AzDException;
import org.azd.http.ClientRequest;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to manage Accounts Api.
 */
public class AccountsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public AccountsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "account", "229a6a53-b428-4ffb-a835-e8f36b5b4b1e");
    }

    /**
     * Get a list of accounts for a specific member. MemberId parameter is required.
     *
     * @param memberId ID for a member of the accounts.
     * @return Accounts future object {@link Accounts}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Accounts> listAsync(String memberId) throws AzDException {
        Objects.requireNonNull(memberId, "Member Id cannot be null or empty.");
        return getRequestBuilder(memberId).executeAsync(Accounts.class);
    }

    /**
     * Get a list of accounts for a specific member. MemberId parameter is required.
     *
     * @param memberId ID for a member of the accounts.
     * @return Accounts future object {@link Accounts}
     * @throws AzDException Default Api Exception handler.
     */
    public Accounts list(String memberId) throws AzDException {
        Objects.requireNonNull(memberId, "Member Id cannot be null or empty.");
        return getRequestBuilder(memberId).execute(Accounts.class);
    }

    /**
     * Constructs the request information for Accounts Api.
     *
     * @param memberId ID of the member.
     * @return ClientRequest {@link ClientRequest}.
     */
    private ClientRequest getRequestBuilder(String memberId) {
        return builder()
                .baseInstance(organizationUrl)
                .query("memberId", memberId)
                .build();
    }
}
