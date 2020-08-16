package com.westpac.tech.westpactechnicaltest.mapper;

import com.westpac.tech.westpactechnicaltest.dto.PostDto;
import com.westpac.tech.westpactechnicaltest.dto.PostsCommentsDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostMapperTest {

    @Test
    void testPostMapper_whenSuccessScenario_thenValidPostComments() {
        PostDto postDto = new PostDto();
        postDto.setId(1);
        postDto.setUserId(1);
        postDto.setBody("post body");
        postDto.setTitle("post title");
        PostMapper postMapper = new PostMapper();
        PostsCommentsDto postsCommentsDto = postMapper.mapPosts(postDto);
        Assert.assertNotNull(postsCommentsDto);
        Assert.assertEquals(postDto.getId(), postsCommentsDto.getId());
        Assert.assertEquals(postDto.getUserId(), postsCommentsDto.getUserId());
        Assert.assertEquals(postDto.getBody(), postsCommentsDto.getBody());
        Assert.assertEquals(postDto.getTitle(), postsCommentsDto.getTitle());


    }

}