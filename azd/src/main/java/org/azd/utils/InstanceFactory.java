package org.azd.utils;

import org.azd.http.DefaultRequestAdapter;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.PageIterator;
import org.azd.interfaces.RequestAdapter;
import org.azd.interfaces.SerializerContext;
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
