package com.westpac.tech.westpactechnicaltest.helper;

import com.westpac.tech.westpactechnicaltest.config.AppProperties;
import com.westpac.tech.westpactechnicaltest.dto.PostDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
class TechnicalTestRestClientTest {

    private RestTemplate restTemplate;

    private TechnicalTestRestClient technicalTestRestClient;
    private AppProperties appProperties;

    public TechnicalTestRestClientTest() {
        this.restTemplate = Mockito.mock(RestTemplate.class);
        this.appProperties = new AppProperties();
        this.appProperties.setDataUrl("https://jsonplaceholder.typicode.com");
        this.technicalTestRestClient = new TechnicalTestRestClient(appProperties, restTemplate);
    }

    @Test
    void testGetPost_whenSuccessScenario_thenReturnNonEmptyList() {
        PostDto postDto = new PostDto();
        postDto.setId(1);
        String url = appProperties.getDataUrl() + "/posts";
        ResponseEntity<List<PostDto>> responseEntity = ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonList(postDto));
        Mockito.when(restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<PostDto>>() {
                })).thenReturn(responseEntity);
        List<PostDto> postDtos = technicalTestRestClient.populatePosts();

        Assert.assertEquals(postDtos.get(0).getId(), postDto.getId());

    }
}