package org.azd.interfaces;

import org.azd.exceptions.AzDException;
import org.azd.serializer.SerializableEntity;

import java.util.List;

public interface PageIterator<T extends SerializableEntity> {
    T getNextPage() throws AzDException;
    List<T> getResults() throws AzDException;
}
