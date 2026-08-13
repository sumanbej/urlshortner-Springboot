package com.urlshortner.urlshortnerproject.Controller;

import com.urlshortner.urlshortnerproject.Model.Url;
import com.urlshortner.urlshortnerproject.Model.UrlDto;
import com.urlshortner.urlshortnerproject.Service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/url")
@RequiredArgsConstructor
public class UrlController {
    private final UrlService urlService;

    @PostMapping("/generate")
    public ResponseEntity<Url>generateShortUrl(@RequestBody UrlDto urlDto){
        Url url=urlService.generateShortLink(urlDto);
        Url persistedUrl=urlService.persistShortLink(url);
        return ResponseEntity.ok(persistedUrl);
    }
}
