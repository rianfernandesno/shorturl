package com.yui.shorturl.service;

import com.yui.shorturl.models.dto.UrlDTO;
import com.yui.shorturl.models.entities.Url;
import com.yui.shorturl.repositories.UrlRepository;
import com.yui.shorturl.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Optional;

@Service
public class UrlService {

    @Autowired
    private UrlRepository repository;

    public String save(UrlDTO dto){
        Url url = new Url();

        copy(dto, url);

        repository.insert(url);

        return "http://localhost:8080/urls/" + url.getId();
    }

    public UrlDTO returnLink(String id){
        Optional<Url> getRef = repository.findById(id);
        Url getUrl = getRef.orElseThrow(()-> new ResourceNotFoundException("Link não encontrado"));

        return  new UrlDTO(getUrl);
    }

    private Url copy(UrlDTO dto, Url url){
        do{
            url.setId(RandomStringUtils.randomAlphabetic(5, 12));
        }while (repository.existsById(url.getId()));

        url.setFullUrl(dto.getFullUrl());

        return url;
    }


}
