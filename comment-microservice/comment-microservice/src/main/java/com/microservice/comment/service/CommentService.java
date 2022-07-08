package com.microservice.comment.service;

import com.microservice.comment.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class CommentService {

    //Will be fetched from common service
    @Autowired
    private CommentRepository commentRepository;

    //Will be fetched from common service
    @Autowired
    private PostRepository postRepository;

    public Response getCommentsForPost(int postid) {
        if (postRepository.existsById(postid)) {
            List<Comment> comments = new ArrayList<>();
            commentRepository.findByPostId(postid).forEach(comments::add);
            if (comments.isEmpty()) {
                log.info("No comments exist for this post");
                return new Response("No comments exist for this post", Boolean.FALSE, "", null);
            } else {
                log.info("Comments returned from database post with id: " + postid);
                return new Response("Comments returned from database post with id: " + postid, Boolean.TRUE, "", comments);
            }
        } else {
            log.info("No post with id: " + postid + " exist in database");
            return new Response("No post with id: " + postid + " exist in database", Boolean.FALSE, "", null);
        }

    }

    public Response getCommentById(int id) {
        try {
            if (commentRepository.existById(id)) {
                log.info("Comment with id: " + id + " returned");
                return new Response("Comment with id: " + id + " returned", Boolean.TRUE, "", commentRepository.findById(id));
            } else {
                log.info("Comment with id: " + id + " does not exist in the database");
                return new Response("Comment with id: " + id + " does not exist in the database", Boolean.FALSE, "", null);
            }
        } catch (Exception e) {
            log.error("Comment with id: " + id + " could not be deleted due to some exception..." + e.getMessage());
            return new Response("Comment with id: " + id + " could not be deleted due to some exception", Boolean.FALSE, "", null);
        }
    }

    public Response addCommentToPost(int postId, Comment comment) {
        try {
            if (postRepository.existsById(postId)) {
                Post post = postRepository.findById(postId);
                comment.setPost(post);
                commentRepository.save(comment);
                log.info("Comment saved successfully");
                return new Response("Comment saved successfully", Boolean.TRUE, "", null);
            } else {
                log.info("Post does not exist in the database");
                return new Response("Post does not exist in the database", Boolean.FALSE, "", null);
            }

        } catch (Exception ex) {
            log.error("Comment could not be updated due to some exception..." + ex.getMessage());
            return new Response("Comment could not be updated due to some exception", Boolean.FALSE, "", null);
        }
    }

    public Response updateComment(Comment comment, int postId) {
        try {
            if (postRepository.existsById(postId)) {
                Post post = postRepository.findById(postId);
                comment.setPost(post);
                commentRepository.save(comment);
                log.info("Comment updated successfully");
                return new Response("Comment updated successfully", Boolean.TRUE, "", null);
            } else {
                log.info("Post does not exist in the database");
                return new Response("Post does not exist in the database", Boolean.FALSE, "", null);
            }

        } catch (Exception ex) {
            log.error("Comment could not be updated due to some exception..." + ex.getMessage());
            return new Response("Comment could not be updated due to some exception", Boolean.FALSE, "", null);
        }
    }

    public Response deleteCommentById(int id) {
        try {
            if (commentRepository.existsById(id)) {
                commentRepository.deleteById(id);
                log.info("Comment deleted successfully");
                return new Response("Comment deleted successfully", Boolean.TRUE, "", null);
            } else {
                log.info("Comment does not exist in the database");
                return new Response("Comment does not exist in the database", Boolean.FALSE, "", null);
            }
        } catch (Exception exception) {
            log.error("Comment could not be deleted due to some exception..." + exception.getMessage());
            return new Response("Comment could not be deleted due to some exception", Boolean.FALSE, "", null);
        }
    }


}