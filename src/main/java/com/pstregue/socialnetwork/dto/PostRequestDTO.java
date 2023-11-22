package com.pstregue.socialnetwork.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@With
public class PostRequestDTO {
    String content;
}
