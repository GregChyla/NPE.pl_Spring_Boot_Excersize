package pl.nullpointerexception.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.nullpointerexception.restapi.model.Post;
import pl.nullpointerexception.restapi.repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getPosts() {
        return postRepository.findAllPosts();
    }

    public List<Post> getPostsByPage(int pageStart, int pageSize) {
        return postRepository.findAllPostsByPage(PageRequest.of(pageStart, pageSize));
    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }
}
