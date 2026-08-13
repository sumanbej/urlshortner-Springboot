package com.urlshortner.urlshortnerproject.Service;

import com.urlshortner.urlshortnerproject.Model.Url;
import com.urlshortner.urlshortnerproject.Model.UrlDto;
import com.urlshortner.urlshortnerproject.Model.UrlResponseDto;

public interface UrlService {
    UrlResponseDto generateShortLink(UrlDto urlDto);
    Url persistShortLink(Url url);
    Url getEncodedUrl(String url);
    void deleteShortLink(Url url);
}
