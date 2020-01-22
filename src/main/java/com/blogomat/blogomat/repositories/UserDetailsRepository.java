package com.blogomat.blogomat.repositories;

import com.blogomat.blogomat.model.entities.UserDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDetailsRepository extends CrudRepository<UserDetails, Integer> {
    Optional<UserDetails> findByUserID(int postID);
}
