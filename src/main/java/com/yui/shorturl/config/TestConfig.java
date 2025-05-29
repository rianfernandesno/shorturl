package com.yui.shorturl.config;

import com.yui.shorturl.models.entities.Url;
import com.yui.shorturl.repositories.UrlRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private UrlRepository repository;

    @PostConstruct
    public void init(){
        repository.deleteAll();

        Url url = new Url("12345", "http://localhost:8080");

        repository.save(url);
    }

}
