package com.urlshortner.urlshortnerproject.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrlErrorResponseDto {
    private String status;
    private String error;
}
