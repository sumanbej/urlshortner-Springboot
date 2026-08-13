package com.urlshortner.urlshortnerproject.Controller;

import com.urlshortner.urlshortnerproject.Model.Url;
import com.urlshortner.urlshortnerproject.Model.UrlDto;
import com.urlshortner.urlshortnerproject.Model.UrlResponseDto;
import com.urlshortner.urlshortnerproject.Service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UrlController {
    private final UrlService urlService;

    @PostMapping("/api/v1/generate")
    public ResponseEntity<UrlResponseDto>generateShortUrl(@RequestBody UrlDto urlDto){
        UrlResponseDto url=urlService.generateShortLink(urlDto);
        return ResponseEntity.ok(url);
    }
    @GetMapping("/{shortUrl}")
    public void getOriginalUrl(
            @PathVariable String shortUrl,
            HttpServletResponse response) throws IOException {

        Url url = urlService.getEncodedUrl(shortUrl);

        response.sendRedirect(url.getOriginalUrl());
    }
}
