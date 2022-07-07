package com.microservice.post.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends  JpaRepository<Post, Integer>{
}
