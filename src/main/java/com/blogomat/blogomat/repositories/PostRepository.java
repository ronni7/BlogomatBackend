package com.blogomat.blogomat.repositories;

import com.blogomat.blogomat.model.entities.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface PostRepository extends CrudRepository<Post, Integer> {
    Iterable<Post> findAll(Sort sort);

    Iterable<Post> findAllByAuthor(String username);

    Optional<Post> findById(Integer id);
}
