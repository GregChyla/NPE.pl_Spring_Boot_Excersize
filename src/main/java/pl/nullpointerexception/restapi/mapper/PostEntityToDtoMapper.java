package pl.nullpointerexception.restapi.mapper;

import pl.nullpointerexception.restapi.controller.dto.PostDto;
import pl.nullpointerexception.restapi.model.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostEntityToDtoMapper {
    private PostEntityToDtoMapper() {
    }

    public static List<PostDto> mapPostToPostDtos(List<Post> posts) {
        return posts.stream()
                .map(PostEntityToDtoMapper::mapToPostDto)
                .collect(Collectors.toList());
    }

    public static PostDto mapToPostDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .content(post.getContent())
                .created(post.getCreated())
                .title(post.getTitle())
                .build();
    }

}
