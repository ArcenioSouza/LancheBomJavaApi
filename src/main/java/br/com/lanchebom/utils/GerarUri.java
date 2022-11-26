package br.com.lanchebom.utils;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class GerarUri {
    private final UriComponentsBuilder uriBuilder;

    public GerarUri() {
        this.uriBuilder = UriComponentsBuilder.newInstance();
    }

    public URI build(String path, Long id){
        return uriBuilder.path(path).buildAndExpand(id).toUri();
    }
}
