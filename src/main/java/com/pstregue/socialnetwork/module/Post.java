package com.pstregue.socialnetwork.module;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Document(collection = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@With
public class Post {
    @Id
    private String id;
    private String content;
    private String author;
    private String authorId;
    private LocalDateTime timestamp;
    private List<String> likes;
    private Map<String, String> comments;
}
