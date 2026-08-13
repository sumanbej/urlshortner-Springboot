package com.urlshortner.urlshortnerproject.Service;

import com.urlshortner.urlshortnerproject.Model.Url;
import com.urlshortner.urlshortnerproject.Model.UrlDto;
import com.google.common.hash.Hashing;
import com.urlshortner.urlshortnerproject.Repository.UrlRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService{
    private final UrlRepo urlRepository;
    @Override
    public Url generateShortLink(UrlDto urlDto) {
        if(StringUtils.isEmpty(urlDto.getOriginalUrl())){
            throw new IllegalArgumentException("URL cannot be empty");
        }
        String shortUrl=encodeUrl(urlDto.getOriginalUrl());
        Url urlToPersist=new Url();
        urlToPersist= Url.builder()
                .originalUrl(urlDto.getOriginalUrl())
                .shortLink(shortUrl)
                .creationDate(LocalDateTime.now())
                .expirationDate(LocalDateTime.now().plusDays(7))
                .build();
        return urlToPersist;

    }

    @Override
    public Url persistShortLink(Url url) {
        Url urlToRet = urlRepository.save(url);
        return urlToRet;
    }

    @Override
    public Url getEncodedUrl(String url) {
        Url urlToRet = urlRepository.findByShortLink(url);
        return urlToRet;
    }

    @Override
    public void deleteShortLink(Url url) {
    urlRepository.delete(url);
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
