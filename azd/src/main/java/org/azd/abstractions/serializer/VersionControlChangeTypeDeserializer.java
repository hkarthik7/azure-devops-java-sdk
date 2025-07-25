package org.azd.abstractions.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.azd.enums.VersionControlChangeType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VersionControlChangeTypeDeserializer extends JsonDeserializer<List<VersionControlChangeType>> {

    @Override
    public List<VersionControlChangeType> deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        String text = p.getText();
        String[] parts = text.split(",");
        List<VersionControlChangeType> types = new ArrayList<>();
        for (String part : parts) {
            try {
                types.add(VersionControlChangeType.valueOf(part.trim().toUpperCase().replace(" ", "_")));
            } catch (IllegalArgumentException e) {
                // Unknown type, skip or log
            }
        }
        return types;
    }
}
