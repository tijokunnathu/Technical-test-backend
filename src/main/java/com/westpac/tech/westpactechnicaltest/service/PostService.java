package com.westpac.tech.westpactechnicaltest.service;

import com.westpac.tech.westpactechnicaltest.dto.PostsCommentsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    List<PostsCommentsDto> getPostsWithComments();
}
