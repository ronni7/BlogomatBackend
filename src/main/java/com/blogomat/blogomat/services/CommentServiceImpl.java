package com.blogomat.blogomat.services;

import com.blogomat.blogomat.model.entities.Comment;
import com.blogomat.blogomat.repositories.CommentRepository;
import org.springframework.stereotype.Component;

@Component
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Iterable<Comment> getComments(int postID) {
        return this.commentRepository.findAllByPostID(postID);
    }

    @Override
    public Comment add(Comment comment) {
        return this.commentRepository.save(comment);
    }
}
