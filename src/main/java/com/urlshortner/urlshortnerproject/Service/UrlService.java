package com.urlshortner.urlshortnerproject.Service;

import com.urlshortner.urlshortnerproject.Model.Url;

public interface UrlService {
    Url generateShortLink(UrlDto urlDto);
    Url persistShortLink(Url url);
    Url getEncodedUrl(String url);
    void deleteShortLink(Url url);
}
