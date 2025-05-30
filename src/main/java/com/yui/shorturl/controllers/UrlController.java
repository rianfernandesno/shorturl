package com.yui.shorturl.controllers;

import com.yui.shorturl.models.dto.UrlDTO;
import com.yui.shorturl.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/urls")
public class UrlController {

    @Autowired
    private UrlService service;

    @PostMapping
    public ResponseEntity<String> postLongUrl(@RequestBody UrlDTO dto){
        String url = service.save(dto);

        return ResponseEntity.ok().body(url);
    }
}
