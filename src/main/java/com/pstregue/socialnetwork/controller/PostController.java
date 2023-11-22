package com.pstregue.socialnetwork.controller;

import com.pstregue.socialnetwork.dto.PostDTO;
import com.pstregue.socialnetwork.dto.PostRequestDTO;
import com.pstregue.socialnetwork.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService service;
    @PostMapping
    @Operation(summary = "Create a new post", security = {@SecurityRequirement(name = "bearerAuth")})
    public PostDTO createPost(PostRequestDTO postRequestDTO) {
        return service.create(postRequestDTO);
    }

    @PatchMapping("/comment")
    @Operation(summary = "Comment a post", security = {@SecurityRequirement(name = "bearerAuth")})
    public void comment(@RequestParam String postId, @RequestBody String comment) {
        service.commentPost(postId, comment);
    }

    @PostMapping("/like")
    @Operation(summary = "Like a post", security = {@SecurityRequirement(name = "bearerAuth")})
    public void like(@RequestParam String postId) {
        service.likePost(postId);
    }
}
