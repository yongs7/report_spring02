package com.sparta.report04.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.report04.dto.CommentDto;
import com.sparta.report04.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity
// 테이블과 연계됨을 스프링에게 알려줍니다.
public class Comment extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "POST_COMMENT")
    private Post post;


    public Comment(CommentDto commentDto) {
        this.comment = commentDto.getComment();
        this.post = commentDto.getPost();
    }
    public void update(CommentDto commentDto) {
        this.comment = commentDto.getComment();
        this.post = commentDto.getPost();
    }
}