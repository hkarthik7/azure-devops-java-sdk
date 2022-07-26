package org.azd.enums;

public enum CustomHeader {
    JSON_CONTENT_TYPE("Content-Type", "application/json"),
    JSON("Accept", CustomHeader.JSON_CONTENT_TYPE.value),
    JSON_PATCH(CustomHeader.JSON_CONTENT_TYPE.name, "application/json-patch+json"),
    TEXT_CONTENT(CustomHeader.JSON.name, "text/plain"),
    URL_ENCODED(JSON_CONTENT_TYPE.name, "application/x-www-form-urlencoded"),
    STREAM(JSON_CONTENT_TYPE.name, "application/octet-stream");

    private String name;
    private String value;

    CustomHeader(String name) {
        this.name = name;
        this.value = "";
    }

    CustomHeader(String name, String value) {
        this.name = name;
        this.value = value;
    }


    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
