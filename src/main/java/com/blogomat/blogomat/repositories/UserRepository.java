package com.blogomat.blogomat.repositories;

import com.blogomat.blogomat.model.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();

    User findByLogin(String login);

    User findByUsername(String Username);
}
