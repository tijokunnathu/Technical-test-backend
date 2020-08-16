package com.westpac.tech.westpactechnicaltest.helper;

import com.westpac.tech.westpactechnicaltest.dto.PostDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TechnicalTestRestClientTest {
    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    TechnicalTestRestClient technicalTestRestClient;
    @Test
    void testGetPost_whenSuccessScenario_thenReturnNonEmptyList() {
        PostDto postDto = new PostDto();
        postDto.setId(1);
        Mockito.when(restTemplate.exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<PostDto>>() {
                }).getBody());
        List<PostDto> postDtos = technicalTestRestClient.populatePosts();

        Assert.assertEquals(postDtos.get(0).getId(), postDto.getId());

    }

    @Test
    void populateComments() {
    }
}