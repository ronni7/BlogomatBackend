package com.blogomat.blogomat.services;

import com.blogomat.blogomat.model.entities.User;
import com.blogomat.blogomat.model.entities.dataObjects.UserLoggedDTO;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User registerNewUser(User u);

    User logUserIn(String login, String password);


}
