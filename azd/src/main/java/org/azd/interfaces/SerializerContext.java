package org.azd.interfaces;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.exceptions.AzDException;

import java.io.File;
import java.io.InputStream;

public interface SerializerContext {
    String serialize(Object value) throws AzDException;
    JsonNode serialize(String jsonString) throws AzDException;
    <T> T deserialize(final String content, Class<T> valueType) throws AzDException;
    <T> T deserialize(final String content, TypeReference<T> valueType) throws AzDException;
    <T> T deserialize(InputStream content, Class<T> valueType) throws AzDException;
    <T> T deserialize(File src, Class<T> valueType) throws AzDException;
}
