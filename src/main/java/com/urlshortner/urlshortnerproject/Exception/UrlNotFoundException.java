package com.urlshortner.urlshortnerproject.Exception;

public class UrlNotFoundException extends RuntimeException {
    private static final int ERROR_CODE = 404;

    public UrlNotFoundException(String message) {
        super(message);
    }

    public int getErrorCode() {
        return ERROR_CODE;
    }
}
