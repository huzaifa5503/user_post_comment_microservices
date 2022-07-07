package com.microservice.post.service;

import com.microservice.post.reponse.Response;
import com.microservice.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Response getPosts() {
        return new Response("Post Returned from database", Boolean.TRUE, "",  postRepository.findAll());
    }

    public Response addPost(Post post) {
        postRepository.save(post);
        return new Response("Post Added Successfully", Boolean.TRUE, "", null);
    }

    public Response getPostById(int id) {
        return new Response("Post Returned from database", Boolean.TRUE, "",  postRepository.findById(id));
    }

    public Response updatePost(int id, Post post) {
        postRepository.save(post);
        return new Response("Post Updated", Boolean.TRUE, "", null);
    }

    public Response deletePostById(int id) {
        postRepository.deleteById(id);
        return new Response("Post Deleted Successfully", Boolean.TRUE, "", null);

    }
