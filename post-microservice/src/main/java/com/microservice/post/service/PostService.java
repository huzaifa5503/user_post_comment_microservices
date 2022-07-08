package com.microservice.post.service;

import com.microservice.post.reponse.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Response getPosts() {
        try {
            log.info("Post Returned from database");
            return new Response("Post Returned from database", Boolean.TRUE, "", postRepository.findAll());
        } catch (Exception e) {
            log.error("Post could not be returned from database due to exception... " + e.getMessage());
            return new Response("Post could not be returned from database due to exception", Boolean.FALSE, "", null);
        }
    }


    public Response addPost(Post post) {
        try {
            postRepository.save(post);
            log.info("Post Added Successfully");
            return new Response("Post Added Successfully", Boolean.TRUE, "", null);
        } catch (Exception e) {
            log.info("Post could not be added due to exception... " + e.getMessage());
            return new Response("Post could not be added due to some exception", Boolean.FALSE, "", null);
        }

    }

    public Response getPostById(int id) {
        try {
            if (postRepository.existsById(id)) {
                log.info("Post Returned from database");
                return new Response("Post Returned from database", Boolean.TRUE, "", postRepository.findById(id));
            } else {
                log.info("Post with id: " + id + " does not exist in database");
                return new Response("Post with id: " + id + " does not exist in database", Boolean.FALSE, "", null);
            }
        } catch (Exception e) {
            log.info("Post could not be returned due to some exception... " + e.getMessage());
            return new Response("Post could not be returned due to some exception", Boolean.FALSE, "", null);
        }

    }

    public Response updatePost(int id, Post post) {
        try {
            if (postRepository.existsById(id)) {
                Post post1 = postRepository.findById(id);
                // post1 = post
                postRepository.save(post);
                log.info("Post Updated Successfully");
                return new Response("Post Updated Successfully", Boolean.TRUE, "", null);
            } else {
                log.info("Post with id: " + id + " does not exist in database");
                return new Response("Post with id: " + id + " does not exist in database", Boolean.FALSE, "", null);
            }
        } catch (Exception e) {
            log.info("Post could not be updated due to some exception... " + e.getMessage());
            return new Response("Post could not be updated due to some exception", Boolean.FALSE, "", null);
        }

    }

    public Response deletePostById(int id) {
        try {
            if (postRepository.existsById(id)) {
                postRepository.deleteById(id);
                log.info("Post Deleted Successfully");
                return new Response("Post Deleted Successfully", Boolean.TRUE, "", null);
            } else {
                log.info("Post with id: " + id + " does not exist in database");
                return new Response("Post with id: " + id + " does not exist in database", Boolean.FALSE, "", null);
            }
        } catch (Exception e) {
            log.info("Post could not be deleted due to some exception... " + e.getMessage());
            return new Response("Post could not be deleted due to some exception", Boolean.FALSE, "", null);
        }


    }
}
