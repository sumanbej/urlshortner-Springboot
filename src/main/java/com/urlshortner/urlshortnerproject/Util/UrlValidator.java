package com.urlshortner.urlshortnerproject.Util;

import com.urlshortner.urlshortnerproject.Exception.BlankUrlException;
import com.urlshortner.urlshortnerproject.Exception.InvalidUrlFormatException;

import java.util.regex.Pattern;

public class UrlValidator {
    private static final Pattern VALID_URL_PATTERN = Pattern.compile(
        "^(https?://)?([a-zA-Z0-9-]+\\.)*[a-zA-Z0-9-]+\\.(com|in|co\\.in|org|net|gov|edu|info|biz)$",
        Pattern.CASE_INSENSITIVE
    );

    public static void validateUrl(String url) {
        if (url == null || url.trim().isEmpty()) {
            throw new BlankUrlException("URL cannot be blank or empty");
        }

        if (!VALID_URL_PATTERN.matcher(url.trim()).matches()) {
            throw new InvalidUrlFormatException("Invalid URL format. URL must contain a valid domain extension like .com, .in, .co.in, .org, .net, .gov");
        }
    }
}
