package com.blogomat.blogomat.repositories;

import com.blogomat.blogomat.model.entities.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    Iterable<Comment> findAllByPostID(int postID);
}
