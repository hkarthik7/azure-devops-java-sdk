package org.azd.tasks;

import org.azd.exceptions.AzDException;
import org.azd.http.AzDResponse;
import org.azd.http.AzDResponseHandler;
import org.azd.interfaces.PageIterator;
import org.azd.interfaces.RequestAdapter;
import org.azd.interfaces.SerializerContext;
import org.azd.serializer.SerializableEntity;
import org.azd.utils.InstanceFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PagedListIterator<T extends SerializableEntity> implements PageIterator<T> {
    private final Class<T> model;
    private final ListIterator listIterator;
    private final SerializerContext serializer;
    private final List<T> results = new ArrayList<>();

    public PagedListIterator(Class<T> model) {
        this(model, null);
    }

    public PagedListIterator(Class<T> model, SerializerContext serializer) {
        this.model = model;
        this.serializer = serializer == null ? InstanceFactory.createSerializerContext() : serializer;
        this.listIterator = new ListIterator();
    }

    public T getNextPage() throws AzDException {
        var response = listIterator.next();
        assert response != null;
        return serializer.deserialize(response.getResponseBody().toString(), model);
    }

    public List<T> getResults() throws AzDException {
        while (listIterator.hasNext()) {
            var response = listIterator.next();
            assert response != null;
            var result = serializer.deserialize(response.getResponseBody().toString(), model);
            results.add(result);
        }
        return results;
    }

    private static class ListIterator implements Iterator<AzDResponse> {
        public ListIterator() {
            this(null);
        }

        public ListIterator(RequestAdapter requestAdapter) {
            this.response = AzDResponseHandler.getResponse();
            this.continuationToken = this.response.getContinuationToken();
            this.requestAdapter = requestAdapter == null ? InstanceFactory.createDefaultRequestAdapter() : requestAdapter;
        }

        @Override
        public boolean hasNext() {
            return continuationToken != null;
        }

        @Override
        public AzDResponse next() {
            if (hasNext()) {
                try {
                    var reqInfo = response.getRequestInformation();
                    reqInfo.setQueryParameter("continuationToken", continuationToken);

                    requestAdapter.sendString(reqInfo);
                    response = AzDResponseHandler.getResponse();
                    continuationToken = response.getContinuationToken();

                    return response;
                } catch (AzDException e) {
                    throw new RuntimeException(e);
                }
            }
            return null;
        }

        private AzDResponse response;
        private String continuationToken;
        private final RequestAdapter requestAdapter;
    }
}
