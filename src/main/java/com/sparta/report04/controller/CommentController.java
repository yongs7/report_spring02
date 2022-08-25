package com.sparta.report04.controller;

import com.sparta.report04.domain.Comment;
import com.sparta.report04.dto.CommentDto;
import com.sparta.report04.dto.ResponseDto;
import com.sparta.report04.repository.CommentRepository;
import com.sparta.report04.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @PostMapping("/api/comments/{id}")
    public ResponseDto<?> createComment(@RequestBody CommentDto commentDto, @PathVariable Long id){
        return commentService.createComment(commentDto, id);
    }

    @GetMapping("/api/comments")
    public List<Comment> readComment(){
        return commentRepository.findAllBy();
    }

    @PutMapping("/api/comments/{id}")
    public ResponseDto<?> updateComment(@RequestBody CommentDto commentDto, @PathVariable Long id){
        return commentService.updateComment(commentDto, id);
    }

    @DeleteMapping("/api/comments/{id}")
    public Long deleteComment(@PathVariable Long id){
        commentRepository.deleteById(id);
        return id;
    }
}