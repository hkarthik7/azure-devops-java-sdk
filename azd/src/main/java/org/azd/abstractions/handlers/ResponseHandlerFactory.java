package org.azd.abstractions.handlers;

import org.azd.abstractions.ResponseHandler;

@FunctionalInterface
public interface ResponseHandlerFactory {
    ResponseHandler create();
}
