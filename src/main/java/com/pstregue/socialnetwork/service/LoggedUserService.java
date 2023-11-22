package com.pstregue.socialnetwork.service;

import com.pstregue.socialnetwork.module.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoggedUserService {

    public static User returnLoggedUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
