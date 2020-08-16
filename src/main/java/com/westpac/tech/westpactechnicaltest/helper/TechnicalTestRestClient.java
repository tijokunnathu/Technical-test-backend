package com.westpac.tech.westpactechnicaltest.helper;

import com.westpac.tech.westpactechnicaltest.config.AppProperties;
import com.westpac.tech.westpactechnicaltest.dto.CommentsDto;
import com.westpac.tech.westpactechnicaltest.dto.PostDto;
import com.westpac.tech.westpactechnicaltest.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class TechnicalTestRestClient {
    private final AppProperties properties;
    private final RestTemplate restTemplate;

    @Autowired
    public TechnicalTestRestClient(AppProperties properties, RestTemplate restTemplate) {
        this.properties = properties;
        this.restTemplate = restTemplate;
    }

    public List<PostDto> populatePosts() {
        String url = properties.getDataUrl() + "/posts";
        return restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<PostDto>>() {
                }).getBody();
    }

    public List<CommentsDto> populateComments() {
        String url = properties.getDataUrl() + "/comments";
        return restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<CommentsDto>>() {
                }).getBody();
    }
    public List<UsersDto> populateUserDetails() {
        String url = properties.getDataUrl() + "/users";
        return restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<UsersDto>>() {
                }).getBody();
    }
}
