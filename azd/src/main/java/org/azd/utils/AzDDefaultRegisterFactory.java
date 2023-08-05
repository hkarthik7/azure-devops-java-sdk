package org.azd.utils;

import org.azd.http.AzDResponseHandler;
import org.azd.http.DefaultRequestAdapter;
import org.azd.http.RequestOption;
import org.azd.interfaces.RequestAdapter;
import org.azd.interfaces.ResponseHandler;
import org.azd.interfaces.SerializerContext;
import org.azd.oauth.OAuthAccessTokenBuilder;
import org.azd.serializer.JsonSerializer;

import java.util.Objects;

public final class AzDDefaultRegisterFactory {
    public static String getBaseInstance() {
        return baseInstance;
    }

    public static SerializerContext createSerializerContext() {
        return new JsonSerializer();
    }

    public static ResponseHandler createResponseHandler() {
        return new AzDResponseHandler();
    }

    public static RequestOption createRequestOption() {
        return new RequestOption();
    }
    public static RequestAdapter createDefaultRequestAdapter() {
        return new DefaultRequestAdapter(null);
    }

    public static OAuthAccessTokenBuilder createOAuthAccessTokenBuilder() {
        return new OAuthAccessTokenBuilder(createDefaultRequestAdapter());
    }

    public static void registerDefaultBaseInstance(final String baseInstance) {
        Objects.requireNonNull(baseInstance);
        AzDDefaultRegisterFactory.baseInstance = baseInstance;
    }
    private AzDDefaultRegisterFactory() {}
    private static String baseInstance;
}
