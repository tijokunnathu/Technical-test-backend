package com.westpac.tech.westpactechnicaltest.service;

import com.westpac.tech.westpactechnicaltest.config.AppProperties;
import com.westpac.tech.westpactechnicaltest.dto.CommentsDto;
import com.westpac.tech.westpactechnicaltest.dto.PostDto;
import com.westpac.tech.westpactechnicaltest.dto.PostsCommentsDto;
import com.westpac.tech.westpactechnicaltest.dto.UsersDto;
import com.westpac.tech.westpactechnicaltest.helper.TechnicalTestRestClient;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

class PostServiceImplTest {

    private TechnicalTestRestClient technicalTestRestClient;
    private PostServiceImpl postService;

    public PostServiceImplTest() {
        this.technicalTestRestClient = Mockito.mock(TechnicalTestRestClient.class);
        this.postService = new PostServiceImpl(technicalTestRestClient);
    }

    @Test
    void testPostsWithComments_whenSuccessScenario_thenReturnPostCommentsDto() {
        PostDto postDto = new PostDto();
        postDto.setId(1);
        postDto.setTitle("postTitle");
        postDto.setBody("body");
        List<PostDto> postDtos = Arrays.asList(postDto);
        Mockito.when(technicalTestRestClient.populatePosts()).thenReturn(postDtos);
        List<PostDto> postDtos1 = technicalTestRestClient.populatePosts();
        Assert.assertEquals(postDto, postDtos1.get(0));
        CommentsDto commentsDto = new CommentsDto();
        commentsDto.setPostId(1);
        commentsDto.setId(1);
        commentsDto.setBody("Comment Body");
        commentsDto.setEmail("email@email.com");
        List<CommentsDto> comments = Arrays.asList(commentsDto);
        Mockito.when(technicalTestRestClient.populateComments()).thenReturn(comments);
        Assert.assertEquals(commentsDto, comments.get(0));
        UsersDto usersDto = new UsersDto();
        usersDto.setId(1);
        usersDto.setName("username");
        List<UsersDto> users = Arrays.asList(usersDto);
        Mockito.when(technicalTestRestClient.populateUserDetails()).thenReturn(users);
        Assert.assertEquals(usersDto, users.get(0));

    }
}