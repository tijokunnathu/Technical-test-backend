package com.westpac.tech.westpactechnicaltest.controller;

import com.westpac.tech.westpactechnicaltest.service.PostService;
import com.westpac.tech.westpactechnicaltest.dto.PostsCommentsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/posts")
public class PostController {
    private PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostsCommentsDto> getPostsWithComments(){

    return postService.getPostsWithComments();


    }
}
