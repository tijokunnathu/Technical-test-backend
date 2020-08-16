package com.westpac.tech.westpactechnicaltest.mapper;

import com.westpac.tech.westpactechnicaltest.dto.CommentsDto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CommentMapper {

    private List<CommentsDto> commentsList;

    public CommentMapper(List<CommentsDto> commentsList) {
        this.commentsList = commentsList;
    }

    public List<CommentsDto> mapComments(Integer id) {
        if (commentsList == null)
            return Collections.emptyList();
        return commentsList.stream().filter(comment ->
                comment.getPostId().equals(id)).collect(Collectors.toList());
    }
}
