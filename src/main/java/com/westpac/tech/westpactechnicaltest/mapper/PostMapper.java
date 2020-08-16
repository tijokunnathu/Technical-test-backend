package com.westpac.tech.westpactechnicaltest.mapper;

import com.westpac.tech.westpactechnicaltest.dto.PostDto;
import com.westpac.tech.westpactechnicaltest.dto.PostsCommentsDto;

public class PostMapper {

    public PostsCommentsDto mapPosts(PostDto post) {
        PostsCommentsDto postsCommentsDto = new PostsCommentsDto();
        postsCommentsDto.setBody(post.getBody());
        postsCommentsDto.setTitle(post.getTitle());
        postsCommentsDto.setId(post.getId());
        postsCommentsDto.setUserId(post.getUserId());
        return postsCommentsDto;
    }
}
