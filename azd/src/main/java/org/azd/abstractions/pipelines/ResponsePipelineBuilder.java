package org.azd.abstractions.pipelines;

import org.azd.abstractions.ResponseHandler;
import org.azd.abstractions.handlers.ResponseHandlerFactory;

import java.util.ArrayList;
import java.util.List;

public final class ResponsePipelineBuilder {
    private final List<ResponseHandlerFactory> handlerFactories = new ArrayList<>();

    private ResponsePipelineBuilder() { }

    public static ResponsePipelineBuilder create() {
        return new ResponsePipelineBuilder();
    }
    public ResponsePipelineBuilder add(ResponseHandlerFactory factory) {
        handlerFactories.add(factory);
        return this;
    }

    public ResponsePipeline build() {
        ResponseHandler next = null;

        for (int i = handlerFactories.size() - 1; i >= 0; i--) {
            ResponseHandler current = handlerFactories.get(i).create();
            current.setNext(next);
            next = current;
        }

        return new ResponsePipeline(next);
    }
}
