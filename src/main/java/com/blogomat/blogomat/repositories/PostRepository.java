package com.blogomat.blogomat.repositories;

import com.blogomat.blogomat.model.entities.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;


public interface PostRepository extends CrudRepository<Post, Integer> {
    Iterable<Post> findAll(Sort sort);

}
