package com.westpac.tech.westpactechnicaltest.service;

import com.westpac.tech.westpactechnicaltest.dto.CommentsDto;
import com.westpac.tech.westpactechnicaltest.dto.PostDto;
import com.westpac.tech.westpactechnicaltest.dto.PostsCommentsDto;
import com.westpac.tech.westpactechnicaltest.dto.UsersDto;
import com.westpac.tech.westpactechnicaltest.helper.TechnicalTestRestClient;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@Service
public class PostServiceImpl implements PostService {
    private final TechnicalTestRestClient restClient;

    @Autowired
    public PostServiceImpl(TechnicalTestRestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    @Cacheable("posts")
    public List<PostsCommentsDto> getPostsWithComments() {
        List<PostsCommentsDto> postsComments = new ArrayList<>();
        List<PostDto> postsList = restClient.populatePosts();
        List<CommentsDto> commentsList = restClient.populateComments();
        List<UsersDto> usersList = restClient.populateUserDetails();
        postsList.forEach(post -> {
            PostsCommentsDto postsCommentsDto = new PostsCommentsDto();
            List<CommentsDto> comments = commentsList.stream().filter(comment ->
                    comment.getPostId().equals(post.getId())).collect(Collectors.toList());
            postsCommentsDto.setBody(post.getBody());
            postsCommentsDto.setTitle(post.getTitle());
            postsCommentsDto.setId(post.getId());
            postsCommentsDto.setUserId(post.getUserId());
            UsersDto user = usersList.stream().filter(usersDto ->
                    usersDto.getId().equals(post.getUserId())).findAny().orElse(null);
            postsCommentsDto.setName(user.getName());
            postsCommentsDto.setUserName(user.getUsername());
            postsCommentsDto.setComments(comments);
            postsComments.add(postsCommentsDto);
        });


        return postsComments;
    }
}
