package br.com.lanchebom.utils;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class GerarUri {
    private final UriComponentsBuilder uriBuilder;
    private final String path;
    private final Long id;

    public GerarUri(String path, Long id) {
        this.uriBuilder = UriComponentsBuilder.newInstance();
        this.path = path;
        this.id = id;
    }

    public URI build(){
        return uriBuilder.path(this.path).buildAndExpand(this.id).toUri();
    }
}
