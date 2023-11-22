package com.pstregue.socialnetwork.util;

import com.pstregue.socialnetwork.dto.PostDTO;
import com.pstregue.socialnetwork.dto.PostRequestDTO;
import com.pstregue.socialnetwork.module.Post;
import org.mapstruct.Mapper;

@Mapper
public interface PostMapper {
    PostDTO postToPostDTO(Post post);
    Post postRequestToPost(PostRequestDTO postRequestDTO);
}
