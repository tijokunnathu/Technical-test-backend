package com.westpac.tech.westpactechnicaltest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostsCommentsDto {
    private Integer id;
    private Integer userId;
    private String name;
    private String userName;
    private String title;
    private String body;
    private List<CommentsDto> comments;
}
