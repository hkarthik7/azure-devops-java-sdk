package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.azd.enums.VersionControlChangeType;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Custom serializer for multi value Git change type
 */
public class VersionControlChangeTypeSerializer extends JsonSerializer<List<VersionControlChangeType>> {
    @Override
    public void serialize(List<VersionControlChangeType> value,
                          JsonGenerator gen,
                          SerializerProvider serializers) throws IOException {

        if (value == null || value.isEmpty()) {
            gen.writeString("");
            return;
        }

        var res = value.stream()
                .map(VersionControlChangeTypeSerializer::getJsonName)
                .collect(Collectors.joining(", "));

        gen.writeString(res);
    }

    private static String getJsonName(VersionControlChangeType type) {
        try {
            var field = VersionControlChangeType.class.getField(type.name());
            var annotation = field.getAnnotation(JsonProperty.class);
            if (annotation != null) {
                return annotation.value();
            }
        } catch (Exception ignored) {}

        return type.name().toLowerCase();
    }
}

