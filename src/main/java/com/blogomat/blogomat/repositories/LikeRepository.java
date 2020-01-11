package com.blogomat.blogomat.repositories;

import com.blogomat.blogomat.model.entities.Like;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LikeRepository extends CrudRepository<Like, Integer> {
    Optional<Like> findByPostID(int postID);
}
