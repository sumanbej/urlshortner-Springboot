package com.urlshortner.urlshortnerproject.Exception;

import com.urlshortner.urlshortnerproject.Model.UrlErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BlankUrlException.class)
    public ResponseEntity<UrlErrorResponseDto> handleBlankUrlException(BlankUrlException ex) {
        UrlErrorResponseDto response = UrlErrorResponseDto.builder()
                .status("400")
                .error(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<UrlErrorResponseDto> handleUrlNotFoundException(UrlNotFoundException ex) {
        UrlErrorResponseDto response = UrlErrorResponseDto.builder()
                .status("404")
                .error(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InvalidUrlFormatException.class)
    public ResponseEntity<UrlErrorResponseDto> handleInvalidUrlFormatException(InvalidUrlFormatException ex) {
        UrlErrorResponseDto response = UrlErrorResponseDto.builder()
                .status("108")
                .error(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
