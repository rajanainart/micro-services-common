package com.rajanainart.common.rest.exception;

import com.rajanainart.common.rest.RestQueryConfig;

public class RestConfigException extends Exception {
    private RestQueryConfig config;
    private String message;

    public RestConfigException(RestQueryConfig config) {
        this.config = config;
    }

    public RestConfigException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
