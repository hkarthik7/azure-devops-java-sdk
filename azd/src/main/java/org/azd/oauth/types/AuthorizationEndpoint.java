package org.azd.oauth.types;

import org.azd.enums.VsoScope;

import java.util.List;

/**
 * Represents the required parameters for building authorization endpoint.
 */
public class AuthorizationEndpoint{
    /**
     * The ID assigned to your app when it was registered.
     */
    public String clientId;
    /**
     * Can be any value. Typically a generated string value that correlates the callback with its associated authorization request.
     */
    public String state;
    /**
     * List of scopes to add. Scopes registered with the app, space separated.
     * See https://learn.microsoft.com/en-us/azure/devops/integrate/get-started/authentication/oauth?view=azure-devops#scopes
     */
    public List<VsoScope> scope;
    /**
     * Callback URL for your app. Must exactly match the URL registered with the app.
     */
    public String redirectUrl;
}
