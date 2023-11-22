package com.pstregue.socialnetwork.controller;

import com.pstregue.socialnetwork.dto.AuthenticationDTO;
import com.pstregue.socialnetwork.dto.LoginDTO;
import com.pstregue.socialnetwork.dto.UserDTO;
import com.pstregue.socialnetwork.dto.UserRequestDTO;
import com.pstregue.socialnetwork.module.User;
import com.pstregue.socialnetwork.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public UserDTO signup(@RequestBody UserRequestDTO user) {
        return userService.create(user);
    }

    @PatchMapping("/follow")
    @Operation(summary = "Follow User", security = {@SecurityRequirement(name = "bearerAuth")})
    public void follow(@RequestParam String id, @RequestParam String idToFollow) {
        userService.follow(id, idToFollow);
    }

    @PostMapping("/login")
    public LoginDTO login(@RequestBody AuthenticationDTO auth) {
        return userService.login(auth);
    }
}
