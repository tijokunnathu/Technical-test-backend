package com.westpac.tech.westpactechnicaltest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentsDto {
    private Integer id;
    private Integer postId;
    private String name;
    private String email;
    private String body;
}
