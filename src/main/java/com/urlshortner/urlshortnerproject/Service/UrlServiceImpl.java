package com.urlshortner.urlshortnerproject.Service;

import com.urlshortner.urlshortnerproject.Model.Url;
import com.urlshortner.urlshortnerproject.Model.UrlDto;
import com.google.common.hash.Hashing;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class UrlServiceImpl implements UrlService{
    @Override
    public Url generateShortLink(UrlDto urlDto) {
        if(StringUtils.isEmpty(urlDto.getOriginalUrl())){
            throw new IllegalArgumentException("URL cannot be empty");
        }
        String shortUrl=encodeUrl(urlDto.getOriginalUrl());
        return null;

    }

    @Override
    public Url persistShortLink(Url url) {
        return null;
    }

    @Override
    public Url getEncodedUrl(String url) {
        return null;
    }

    @Override
    public void deleteShortLink(Url url) {

    }
    private String encodeUrl(String url)
    {
        String encodedUrl = "";
        LocalDateTime time = LocalDateTime.now();
        encodedUrl = Hashing.murmur3_32()
                .hashString(url.concat(time.toString()), StandardCharsets.UTF_8)
                .toString();
        return  encodedUrl;
    }
}
