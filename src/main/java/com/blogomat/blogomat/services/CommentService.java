package com.blogomat.blogomat.services;

import com.blogomat.blogomat.model.entities.Comment;

public interface CommentService {

    Iterable<Comment> getComments(int postID);

    Comment add(Comment comment);
}
