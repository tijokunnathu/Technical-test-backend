package com.westpac.tech.westpactechnicaltest.mapper;

import com.westpac.tech.westpactechnicaltest.dto.CommentsDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommentMapperTest {

    @Test
    void testCommentMapper_whenSuccessScenario_thenValidCommentsList() {
        CommentsDto commentsDto = new CommentsDto();
        commentsDto.setId(1);
        commentsDto.setPostId(1);
        commentsDto.setBody("comment body");
        CommentMapper commentMapper = new CommentMapper(Arrays.asList(commentsDto));
        List<CommentsDto> comments = commentMapper.mapComments(1);
        Assert.assertEquals(commentsDto.getPostId(), comments.get(0).getPostId());

    }
    @Test
    void testCommentMapper_whenCommentList_thenReturnEmptyCommentsDtoList() {
        CommentMapper commentMapper = new CommentMapper(null);
        Assert.assertTrue(commentMapper.mapComments(1).isEmpty());
    }
}