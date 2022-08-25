package com.sparta.report04.service;

import com.sparta.report04.domain.Comment;
import com.sparta.report04.domain.Post;
import com.sparta.report04.dto.CommentDto;
import com.sparta.report04.dto.ResponseDto;
import com.sparta.report04.repository.CommentRepository;
import com.sparta.report04.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    public ResponseDto<?> createComment(CommentDto commentDto, Long id){
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NULL_POST_ID", "post id isn't exist");
        }
        commentDto.setPost(optionalPost.get());

        Comment comment = new Comment(commentDto);
        commentRepository.save(comment);

        return ResponseDto.success(comment);
    }

    public ResponseDto<?> updateComment(CommentDto commentDto, Long id){
        Optional<Comment> optionalComment = commentRepository.findById(id);

        if (optionalComment.isEmpty()) {
            return ResponseDto.fail("NULL_COMMENT_ID", "comment id isn't exist");
        }
        Comment comment = optionalComment.get();
        comment.update(commentDto);

        return ResponseDto.success(comment);
    }
}
