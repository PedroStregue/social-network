package com.pstregue.socialnetwork.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@With
public class PostDTO {
    String id;
    String content;
    String author;
    String authorId;
    LocalDateTime timestamp;
    List<String> likes;
    Map<String,String> comments;
}
