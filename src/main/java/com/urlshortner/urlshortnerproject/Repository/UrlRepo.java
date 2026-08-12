package com.urlshortner.urlshortnerproject.Repository;

import com.urlshortner.urlshortnerproject.Model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepo extends JpaRepository<Url, Long> {

    public Url findByShortLink(String shortLink);
}

