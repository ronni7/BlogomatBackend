package com.blogomat.blogomat.services;

import com.blogomat.blogomat.model.entities.ContactMessage;
import com.blogomat.blogomat.model.entities.User;
import com.blogomat.blogomat.repositories.ContactRepository;
import com.blogomat.blogomat.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ContactRepository contactRepository;

    public UserServiceImpl(UserRepository userRepository, ContactRepository contactRepository) {
        this.userRepository = userRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    public List<com.blogomat.blogomat.model.entities.User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public com.blogomat.blogomat.model.entities.User registerNewUser(com.blogomat.blogomat.model.entities.User u) {
        //u.setPassword(BCrypt.hashpw(String.valueOf(u.getPassword()), BCrypt.gensalt()).toCharArray());
        return userRepository.save(u);
    }

    @Override
    public User logUserIn(String login, String password) {
        // ArrayList<User> list = new ArrayList<>(userRepository.findByLogin(login));
        //  for (User u : list)
         /*   if (BCrypt.checkpw(String.valueOf(password), String.valueOf(u.getPassword())))
                return new UserLoggedDTO(u.getName(), u.getEmail(), u.getSex(), u.getRole());*/

        /*   logUserIn(login, password);*/
        return userRepository.findByLogin(login);
    }

    @Override
    public void contactAdmin(ContactMessage contactMessage) {
        contactRepository.save(contactMessage);
    }

    @Override
    public Iterable<ContactMessage> getContactMessages() {
        return contactRepository.findAll();
    }
/*
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User registerNewUser(User u) {
        if (userRepository.findByLogin(u.getLogin()).size() == 1)
            return new User(-1);
        u.setPassword(BCrypt.hashpw(String.valueOf(u.getPassword()), BCrypt.gensalt()).toCharArray());
        return userRepository.save(u);
    }

    @Override
    public UserLoggedDTO logUserIn(String login, char[] password) {
        ArrayList<User> list = new ArrayList<>(userRepository.findByLogin(login));
        for (User u : list)
            if (BCrypt.checkpw(String.valueOf(password), String.valueOf(u.getPassword())))
                return new UserLoggedDTO(u.getName(), u.getEmail(), u.getSex(), u.getRole());
        return null;
    }*/

}
