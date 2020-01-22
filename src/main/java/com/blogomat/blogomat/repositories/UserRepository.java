package com.blogomat.blogomat.repositories;

import com.blogomat.blogomat.model.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();

    Iterable<User> findByLogin(String login);

    Optional<User> findByUsername(String Username);
}
