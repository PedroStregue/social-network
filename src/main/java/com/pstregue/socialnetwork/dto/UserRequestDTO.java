package com.pstregue.socialnetwork.dto;

import com.pstregue.socialnetwork.UserRole;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@With
public class UserRequestDTO {
    String name;
    String email;
    String password;
    UserRole role;
}
