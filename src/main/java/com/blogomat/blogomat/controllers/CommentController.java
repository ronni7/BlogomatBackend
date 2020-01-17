package com.blogomat.blogomat.controllers;

import com.blogomat.blogomat.model.entities.Comment;
import com.blogomat.blogomat.services.CommentServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/comment")
public class CommentController {
    private final CommentServiceImpl commentService;

    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @PostMapping(path = "/getComments")
    public @ResponseBody
    Iterable<Comment> getComments(@RequestBody Integer postID) {
        System.out.println("postID = " + postID);
        System.out.println("commentService posts= " + commentService.getComments(postID));
        return commentService.getComments(postID);
    }

    // @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @PostMapping(path = "/addComment")
    public @ResponseBody
    Comment addComment(@RequestBody Comment comment) {
        return commentService.add(comment);
    }


}
