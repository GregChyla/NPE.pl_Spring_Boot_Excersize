package pl.nullpointerexception.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.nullpointerexception.restapi.model.Comment;
import pl.nullpointerexception.restapi.repository.CommentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }

    public List<Comment> findCommentsByPostId(Long id) {
        return commentRepository.findCommentsByPostId(id);
    }
}
