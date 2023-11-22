package com.pstregue.socialnetwork.service;

import com.pstregue.socialnetwork.dto.PostDTO;
import com.pstregue.socialnetwork.dto.PostRequestDTO;
import com.pstregue.socialnetwork.module.User;
import com.pstregue.socialnetwork.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

import static com.pstregue.socialnetwork.util.MapperConstants.postMapper;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;

    public PostDTO create(PostRequestDTO post){
        var loggedUser = LoggedUserService.returnLoggedUser();
        return postMapper.postToPostDTO(repository.save(postMapper.postRequestToPost(post).withLikes(new ArrayList<>()).withComments(new HashMap<>()).withAuthorId(loggedUser.getId()).withAuthor(loggedUser.getName())));
    }

    public void commentPost(String postId, String comment){
        var post = repository.findById(postId);
        var loggedUser = LoggedUserService.returnLoggedUser();
        post.ifPresent(p -> {
            var comments = p.getComments();
            comments.put(loggedUser.getId(), comment);
            repository.save(p.withComments(comments));
        });
    }

    public void likePost(String postId){
        var post = repository.findById(postId);
        var loggedUser = LoggedUserService.returnLoggedUser();
        post.ifPresent(p -> {
            var likes = p.getLikes();
            //If the User has already liked the post, the like are removed
            if (likes.contains(loggedUser.getId())){
                likes.remove(loggedUser.getId());
                repository.save(p.withLikes(likes));
            }else{
            likes.add(loggedUser.getId());
            repository.save(p.withLikes(likes));
            }
        });
    }
}
