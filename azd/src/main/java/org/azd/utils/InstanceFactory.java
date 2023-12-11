package org.azd.utils;

import org.azd.http.DefaultResponseHandler;
import org.azd.http.DefaultRequestAdapter;
import org.azd.http.DefaultRetryHandler;
import org.azd.http.RequestOption;
import org.azd.interfaces.*;
import org.azd.oauth.OAuthAccessTokenBuilder;
import org.azd.serializer.JsonSerializer;
import org.azd.serializer.SerializableEntity;
import org.azd.tasks.PagedListIterator;

import java.util.Objects;

public final class InstanceFactory {
    public static String getBaseInstance() {
        return baseInstance;
    }

    public static SerializerContext createSerializerContext() {
        return new JsonSerializer();
    }

    public static ResponseHandler createResponseHandler() {
        return new DefaultResponseHandler();
    }

    public static RetryHandler createRetryHandler() { return new DefaultRetryHandler(); }

    public static DefaultRetryHandler createDefaultRetryHandler() { return new DefaultRetryHandler(); }

    public static RequestOption createRequestOption() {
        return new RequestOption();
    }

    public static RequestAdapter createDefaultRequestAdapter() {
        return new DefaultRequestAdapter(null);
    }

    public static RequestAdapter createDefaultRequestAdapter(AccessTokenCredential accessTokenCredential) {
        return new DefaultRequestAdapter(accessTokenCredential);
    }

    public static <T extends SerializableEntity> PageIterator<T> createPageIterator(Class<T> model) {
        return new PagedListIterator<>(model);
    }

    public static OAuthAccessTokenBuilder createOAuthAccessTokenBuilder() {
        return new OAuthAccessTokenBuilder(createDefaultRequestAdapter());
    }

    public static void registerDefaultBaseInstance(final String baseInstance) {
        Objects.requireNonNull(baseInstance);
        InstanceFactory.baseInstance = baseInstance;
    }
    private InstanceFactory() {}
    private static String baseInstance;
}
