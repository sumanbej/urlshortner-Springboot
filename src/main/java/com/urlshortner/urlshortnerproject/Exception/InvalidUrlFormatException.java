package com.urlshortner.urlshortnerproject.Exception;

public class InvalidUrlFormatException extends RuntimeException {
    private static final int ERROR_CODE = 108;

    public InvalidUrlFormatException(String message) {
        super(message);
    }

    public int getErrorCode() {
        return ERROR_CODE;
    }
}
