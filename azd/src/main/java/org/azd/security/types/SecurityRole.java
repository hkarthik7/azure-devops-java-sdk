package org.azd.security.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.azd.abstractions.serializer.SerializableEntity;

/***
 * encapsulate security role returned by devops
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SecurityRole extends SerializableEntity {
}
