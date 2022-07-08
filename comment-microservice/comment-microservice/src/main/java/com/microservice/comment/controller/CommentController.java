package com.microservice.comment.controller;

import com.microservice.comment.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public Response getCommentsForPost(@RequestParam("postId") int postId) {
        return commentService.getComments(postId);
    }

    @GetMapping("/comments")
    public Response getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/comments/{commentid}")
    public Response getCommentById(@PathVariable int commentid) {
        return commentService.getCommentById(commentid);
    }

    @PostMapping("/comments")
    public Response addCommentToPost(@RequestParam("postId") int postId, @RequestBody Comment comment) {
        commentService.addCommentToPost(postId, comment);
    }

    @PutMapping("/comments/{commentid}")
    public Response updateComment(@RequestBody Comment comment, @PathVariable int commentid) {
        commentService.updateComment(comment, commentid);
    }

    @DeleteMapping("/{commentid}")
    public Response deleteCommentById(@PathVariable int commentid) {
        commentService.deleteCommentById(commentid);
    }
}
