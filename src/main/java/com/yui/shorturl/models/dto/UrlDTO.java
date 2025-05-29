package com.yui.shorturl.models.dto;

public class UrlDTO {

    private String id;
    private String fullUrl;

    public UrlDTO(){}

    public UrlDTO(String id, String fullUrl) {
        this.id = id;
        this.fullUrl = fullUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }
}
