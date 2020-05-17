package pl.nullpointerexception.restapi.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostDto {
    private final long id;
    private final String title;
    private final String content;
    private final LocalDateTime created;
}
