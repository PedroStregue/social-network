package com.pstregue.socialnetwork.service;

import com.pstregue.socialnetwork.dto.AuthenticationDTO;
import com.pstregue.socialnetwork.dto.LoginDTO;
import com.pstregue.socialnetwork.dto.UserDTO;
import com.pstregue.socialnetwork.dto.UserRequestDTO;
import com.pstregue.socialnetwork.exceptions.UserAlreadyExistsException;
import com.pstregue.socialnetwork.module.User;
import com.pstregue.socialnetwork.repository.UserRepository;
import com.pstregue.socialnetwork.security.TokenService;
import com.pstregue.socialnetwork.util.MapperConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.pstregue.socialnetwork.util.MapperConstants.userMapper;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;


    public UserDTO create(UserRequestDTO user) {
        if(this.repository.findByEmail(user.getEmail()) != null) throw new UserAlreadyExistsException("Usuario com email" + user.getEmail() + "já existe");

        String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        return userMapper.userToUserDTO(repository.save(userMapper.requestToUser(user.withPassword(encryptedPassword))));
    }

    public LoginDTO login(AuthenticationDTO auth){
        var usernamePassword = new UsernamePasswordAuthenticationToken(auth.email(), auth.password());
        var authentication = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User)authentication.getPrincipal());

        return new LoginDTO(token);
    }

    public void follow(String id, String idToFollow){
        var userToBeFollowed = repository.findById(idToFollow);
        var user = repository.findById(id);

        userToBeFollowed.ifPresent(u -> {
            var followers = u.getFollowers();
            followers.add(id);
            repository.save(u.withFollowers(followers));
        });
        user.ifPresent(u -> {
            var following = u.getFollows();
            following.add(idToFollow);
            repository.save(u.withFollows(following));
        });
    }

}
