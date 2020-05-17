package pl.nullpointerexception.restapi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.nullpointerexception.restapi.controller.dto.PostDto;
import pl.nullpointerexception.restapi.model.Post;
import pl.nullpointerexception.restapi.service.PostService;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<PostDto> getPosts(
            @RequestParam(required = false) Integer page,
            @RequestParam @DefaultValue(value = "ASC") Sort.Direction sort) {
        page = putZeroIfNullOrNegative(page);
        return postService.getPosts(page, sort);
    }

    @GetMapping("/posts/{id}/comments")
    public Post getSinglePost(@PathVariable @NotNull long id) {
        return postService.getSinglePost(id);
    }

    @GetMapping("/posts/{pageStart}/{pageSize}")
    public List<Post> getPostsByPage(@PathVariable int pageStart, @PathVariable int pageSize) {
        return postService.getPostsByPage(pageStart, pageSize);
    }

    @GetMapping("/posts/{id}")
    public PostDto getSinglePostWithoutComments(@PathVariable long id) {
        return postService.getSinglePostWithoutComments(id);
    }

    @GetMapping("/posts/comments")
    public List<Post> getPostsWithComments(
            @RequestParam(required = false) Integer page,
            @RequestParam @DefaultValue(value = "ASC") Sort.Direction sort
    ) {
        page = putZeroIfNullOrNegative(page);
        return postService.getPostsWithComments(page, sort);
    }

    private int putZeroIfNullOrNegative(Integer page) {
        return (Objects.isNull(page) || page <= 0) ? 0 : page;
    }
}
