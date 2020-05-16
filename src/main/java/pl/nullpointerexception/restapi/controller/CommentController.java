package pl.nullpointerexception.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.nullpointerexception.restapi.model.Comment;
import pl.nullpointerexception.restapi.repository.CommentRepository;
import pl.nullpointerexception.restapi.service.CommentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return commentService.findAllComments();
    }

    @GetMapping("/posts/{id}/comments")
    public List<Comment> getCommentsByPostId(@PathVariable Long id) {
        return commentService.findCommentsByPostId(id);
    }
}
