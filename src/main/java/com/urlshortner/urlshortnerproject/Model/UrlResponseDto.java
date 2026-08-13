package com.urlshortner.urlshortnerproject.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrlResponseDto {
    private String originalUrl;
    private String shortUrl;
    private LocalDateTime expirationTime;
}
