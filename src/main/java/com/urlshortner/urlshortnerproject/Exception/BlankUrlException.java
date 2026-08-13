package com.urlshortner.urlshortnerproject.Exception;

public class BlankUrlException extends RuntimeException {
    private static final int ERROR_CODE = 400;

    public BlankUrlException(String message) {
        super(message);
    }

    public int getErrorCode() {
        return ERROR_CODE;
    }
}
