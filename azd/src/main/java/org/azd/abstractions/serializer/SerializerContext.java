package org.azd.abstractions.serializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.exceptions.AzDException;

import java.io.File;
import java.io.InputStream;

/**
 * Serializes and Deserializes the JSON.
 */
public interface SerializerContext {
    /**
     * Serialize an object to JSON string.
     * @param value Object to serialize.
     * @return JSON string.
     * @throws AzDException Default exception handler.
     */
    String serialize(Object value) throws AzDException;

    /**
     * Serializes JSON string to JSON node.
     * @param jsonString JSON string to serialize.
     * @return JSON node object.
     * @throws AzDException Default exception handler.
     */
    JsonNode serialize(String jsonString) throws AzDException;

    /**
     * Deserialize JSON string to a specified type.
     * @param content JSON string.
     * @param valueType Type to convert to.
     * @return Java object of specified type.
     * @param <T> Type parameter
     * @throws AzDException Default exception handler.
     */
    <T> T deserialize(final String content, Class<T> valueType) throws AzDException;

    /**
     * Deserialize JSON string to a specified type.
     * @param content JSON string.
     * @param valueType Type to convert to.
     * @return Java object of specified type.
     * @param <T> Type parameter
     * @throws AzDException Default exception handler.
     */
    <T> T deserialize(final String content, TypeReference<T> valueType) throws AzDException;

    /**
     * Deserialize an input stream to a specified type.
     * @param content JSON string.
     * @param valueType Type to convert to.
     * @return Java object of specified type.
     * @param <T> Type parameter
     * @throws AzDException Default exception handler.
     */
    <T> T deserialize(InputStream content, Class<T> valueType) throws AzDException;

    /**
     * Deserialize JSON string to a specified type.
     * @param src File that contains JSON string.
     * @param valueType Type to convert to.
     * @return Java object of specified type.
     * @param <T> Type parameter
     * @throws AzDException Default exception handler.
     */
    <T> T deserialize(File src, Class<T> valueType) throws AzDException;
}
