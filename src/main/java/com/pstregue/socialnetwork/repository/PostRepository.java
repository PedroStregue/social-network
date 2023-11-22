package com.pstregue.socialnetwork.repository;

import com.pstregue.socialnetwork.module.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
