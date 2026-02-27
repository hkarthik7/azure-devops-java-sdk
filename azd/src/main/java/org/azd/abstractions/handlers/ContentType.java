package org.azd.abstractions.handlers;

import org.azd.enums.CustomHeader;
import org.azd.utils.StringUtils;

import java.net.http.HttpResponse;
import java.util.Locale;
import java.util.Objects;

public final class ContentType {
    private final String value;

    private ContentType(String value) {
        this.value = value.toLowerCase(Locale.ROOT);
    }

    public static ContentType from(HttpResponse<?> response) {
        Objects.requireNonNull(response, "Response cannot be null.");

        return response.headers()
                .firstValue(CustomHeader.JSON_CONTENT_TYPE.getName())
                .map(x -> new ContentType(x.split(";")[0].trim()))
                .orElse(new ContentType(StringUtils.EMPTY));

    }

    boolean isJson()  { return value.equals(CustomHeader.JSON_CONTENT_TYPE.getValue()); }
    boolean isText()  { return value.equals(CustomHeader.TEXT_CONTENT.getValue()); }
    boolean isHtml()  { return value.equals(CustomHeader.HTML_CONTENT.getValue()); }
    boolean isXml()  { return value.equals(CustomHeader.XML_CONTENT_TYPE.getValue()); }

    @Override
    public String toString() {
        return value;
    }
}
