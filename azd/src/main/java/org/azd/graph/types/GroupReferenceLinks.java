package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.azd.abstractions.InstanceFactory;
import org.azd.exceptions.AzDException;

/**
 * This field contains zero or more interesting links about the graph subject.
 * These links may be invoked to obtain additional relationships or more detailed information about this graph subject.
 *
 * @deprecated This is identical to {@link GraphReferenceLinks} and all references should be updated accordingly
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupReferenceLinks extends GraphReferenceLinks {

    @Override
    public String toString() {
        String res = null;
        var serializer = InstanceFactory.createSerializerContext();

        try {
            res = serializer.serialize(this);
        } catch (AzDException ignored) {
        }

        return res;
    }
}
