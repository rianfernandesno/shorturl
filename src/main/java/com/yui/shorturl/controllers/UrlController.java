package com.yui.shorturl.controllers;

import com.yui.shorturl.models.dto.UrlDTO;
import com.yui.shorturl.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<Void> redirectionToUrl(@PathVariable String id){
        UrlDTO dto = service.returnLink(id);
        String url = dto.getFullUrl();

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .header("Location", url)
                .build();
    }
}
