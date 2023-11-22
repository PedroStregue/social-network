package com.pstregue.socialnetwork.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@With
public class UserDTO {
    String id;
    String name;
    String email;
}
