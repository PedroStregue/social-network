package com.pstregue.socialnetwork.util;

import com.pstregue.socialnetwork.dto.UserDTO;
import com.pstregue.socialnetwork.dto.UserRequestDTO;
import com.pstregue.socialnetwork.module.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User requestToUser(UserRequestDTO userRequestDTO);
    UserDTO userToUserDTO(User user);
}
