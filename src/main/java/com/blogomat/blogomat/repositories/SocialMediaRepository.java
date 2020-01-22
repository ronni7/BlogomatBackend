package com.blogomat.blogomat.repositories;

import com.blogomat.blogomat.model.entities.SocialMedia;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SocialMediaRepository extends CrudRepository<SocialMedia, Integer> {
    Optional<SocialMedia> findByUserID(int postID);
}
