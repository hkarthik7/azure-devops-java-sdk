package org.azd.enums;

/**
 * Custom header type to set headers for request/response
 */
public enum CustomHeader {
    /**
     * Json content type applicable for most of the post request.
     * "Content-Type", "application/json"
     */
    JSON_CONTENT_TYPE("Content-Type", "application/json"),
    /**
     * Json content to accept
     * "Accept", "application/json"
     */
    JSON("Accept", CustomHeader.JSON_CONTENT_TYPE.value),
    /**
     * Should be used for post or patch operations
     * "Content-Type", "application/json-patch+json"
     */
    JSON_PATCH(CustomHeader.JSON_CONTENT_TYPE.name, "application/json-patch+json"),
    /**
     * To accept the plain text response
     * "Accept", "text/plain"
     */
    TEXT_CONTENT(CustomHeader.JSON.name, "text/plain"),
    /**
     * For url encoded request/response
     * "Content-Type", "application/x-www-form-urlencoded"
     */
    URL_ENCODED(CustomHeader.JSON_CONTENT_TYPE.name, "application/x-www-form-urlencoded"),
    /**
     * Should be set for stream upload
     * "Content-Type", "application/octet-stream"
     */
    STREAM(CustomHeader.JSON_CONTENT_TYPE.name, "application/octet-stream"),
    /**
     * Should be set for stream upload/download as zip content
     * "Content-Type", "application/zip"
     */
    STREAM_ZIP(CustomHeader.JSON_CONTENT_TYPE.name, "application/zip"),
    /**
     * Should be set to accept the stream content from Api as zip
     */
    STREAM_ZIP_ACCEPT(CustomHeader.JSON.name, CustomHeader.STREAM_ZIP.getValue()),
    /**
     * Empty custom header to set the desired values
     * Call setCustomHeaders() method and set the values.
     */
    CUSTOM_HEADER("", ""),
    /**
     * Should be set to accept the stream content from Api
     */
    STREAM_ACCEPT(CustomHeader.JSON.name, CustomHeader.STREAM.getValue());

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

    public void setCustomHeaders(String name, String value) {
        CUSTOM_HEADER.name = name;
        CUSTOM_HEADER.value = value;
    }
}
