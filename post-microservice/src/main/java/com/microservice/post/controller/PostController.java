package com.microservice.post.controller;

import com.microservice.post.reponse.Response;
import com.microservice.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public Response getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/{id}")
    public Response getPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @PostMapping("/add")
    public Response addPost(@RequestBody Post post) {
        postService.addPost(post);
    }

    @PutMapping("/{id}")
    public Response updatePost(@PathVariable int id, @RequestBody Post post) {
        postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public Response deletePostById(@PathVariable int id) {
        postService.deletePdeletePostByIdost(id);
    }
}
