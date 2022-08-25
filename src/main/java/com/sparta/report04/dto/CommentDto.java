package com.sparta.report04.dto;

import com.sparta.report04.domain.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private String comment;
    private Post post;
}
