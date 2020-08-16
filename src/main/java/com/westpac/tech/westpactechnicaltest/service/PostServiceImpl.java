package com.westpac.tech.westpactechnicaltest.service;

import com.westpac.tech.westpactechnicaltest.dto.CommentsDto;
import com.westpac.tech.westpactechnicaltest.dto.PostDto;
import com.westpac.tech.westpactechnicaltest.dto.PostsCommentsDto;
import com.westpac.tech.westpactechnicaltest.dto.UsersDto;
import com.westpac.tech.westpactechnicaltest.helper.TechnicalTestRestClient;
import com.westpac.tech.westpactechnicaltest.mapper.CommentMapper;
import com.westpac.tech.westpactechnicaltest.mapper.PostMapper;
import com.westpac.tech.westpactechnicaltest.mapper.UserMapper;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            CommentMapper commentMapper = new CommentMapper(commentsList);
            PostMapper postMapper = new PostMapper();
            PostsCommentsDto postsCommentsDto = postMapper.mapPosts(post);
            UserMapper userMapper = new UserMapper(usersList);
            UsersDto user = userMapper.mapUsers(post.getUserId());
            postsCommentsDto.setName(user.getName());
            postsCommentsDto.setUserName(user.getUsername());
            postsCommentsDto.setComments(commentMapper.mapComments(post.getId()));
            postsComments.add(postsCommentsDto);
        });
        return postsComments;
    }
}
