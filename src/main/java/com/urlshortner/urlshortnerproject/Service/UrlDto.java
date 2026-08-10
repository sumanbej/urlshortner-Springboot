package com.urlshortner.urlshortnerproject.Service;

public class UrlDto {
    private String originalUrl;

    public UrlDto() {
    }

    public UrlDto(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
