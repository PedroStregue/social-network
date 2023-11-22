package com.pstregue.socialnetwork.repository;

import com.pstregue.socialnetwork.module.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    UserDetails findByEmail(String email);
}
