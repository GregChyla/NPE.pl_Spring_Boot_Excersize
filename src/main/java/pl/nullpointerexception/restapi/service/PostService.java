package pl.nullpointerexception.restapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.nullpointerexception.restapi.controller.dto.PostDto;
import pl.nullpointerexception.restapi.mapper.PostEntityToDtoMapper;
import pl.nullpointerexception.restapi.model.Post;
import pl.nullpointerexception.restapi.repository.PostRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private static final int PAGE_SIZE = 20;
    private final PostRepository postRepository;

    public List<PostDto> getPosts(int page, Sort.Direction sort) {
        return PostEntityToDtoMapper.mapPostToPostDtos(postRepository
                .findAllPosts(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id"))));
    }

    public List<Post> getPostsByPage(@NotNull int page, int pageSize) {
        return postRepository.findAllPostsByPage(PageRequest.of(page, pageSize));
    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }

    public PostDto getSinglePostWithoutComments(long id) {
        return PostEntityToDtoMapper.mapToPostDto(postRepository.getOne(id));
    }

    public List<Post> getPostsWithComments(int page, Sort.Direction sort) {
        return postRepository.findAllWithComments(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
    }
}
