package com.blogomat.blogomat.controllers;


import com.blogomat.blogomat.model.entities.*;
import com.blogomat.blogomat.model.VO.CredentialsVO;
import com.blogomat.blogomat.model.VO.UserContextVO;
import com.blogomat.blogomat.services.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/user")
public class MainController {

    private final UserServiceImpl userService;
    @Autowired
    ObjectMapper objectMapper;

    public MainController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/hello")
    public @ResponseBody
    String hello() {
        return "Hello World";
    }

    @PostMapping(path = "/login")
    public @ResponseBody
    UserContextVO logUserIn(@RequestBody CredentialsVO credentialsVO) {
        return userService.logUserIn(credentialsVO.getLogin(), credentialsVO.getPassword());
    }

    @PostMapping(path = "/register")
    public @ResponseBody
    User registerNewUser(@RequestBody User u) {
        return userService.registerNewUser(u);
    }

    @PostMapping(path = "/contactAdmin")
    public @ResponseBody
    void contactAdmin(@RequestBody ContactMessage contactMessage) {
        userService.contactAdmin(contactMessage);
    }

    @GetMapping(path = "/getUserDetails/{userID}")
    public @ResponseBody
    Optional<UserDetails> getUserDetails(@PathVariable Integer userID) {
        return userService.getUserDetails(userID);
    }

    @GetMapping(path = "/getUserSocialMedia/{author}")
    public @ResponseBody
    Optional<SocialMedia> getUserSocialMedia(@PathVariable String author) {
        return userService.getUserSocialMedia(author);
    }

    @PostMapping(path = "/saveSocialMedia")
    public @ResponseBody
    SocialMedia saveSocialMedia(@RequestBody SocialMedia socialMedia) {
        return userService.saveUserSocialMedia(socialMedia);
    }

    @PostMapping(path = "/savePersonalDataSettings")
    public @ResponseBody
    PersonalDataSettings savePersonalDataSettings(@RequestBody PersonalDataSettings personalDataSettings) {
        return userService.savePersonalDataSettings(personalDataSettings);
    }

    @GetMapping(path = "/getPersonalDataSettings/{userID}")
    public @ResponseBody
    Optional<PersonalDataSettings> getPersonalDataSettings(@PathVariable Integer userID) {
        return userService.getPersonalDataSettings(userID);
    }

    @PostMapping(path = "/saveSocialMediaSettings")
    public @ResponseBody
    SocialMediaSettings savePersonalDataSettings(@RequestBody SocialMediaSettings socialMediaSettings) {
        return userService.saveSocialMediaSettings(socialMediaSettings);
    }

    @GetMapping(path = "/getSocialMediaSettings/{userID}")
    public @ResponseBody
    Optional<SocialMediaSettings> getSocialMediaSettings(@PathVariable Integer userID) {
        return userService.getSocialMediaSettings(userID);
    }

    @PostMapping(path = "/saveSelectedTheme")
    public @ResponseBody
    Theme saveSelectedTheme(@RequestBody Theme theme) {
        return userService.saveSelectedTheme(theme);
    }

    @GetMapping(path = "/getSelectedTheme/{userID}")
    public @ResponseBody
    Optional<Theme> getSelectedTheme(@PathVariable Integer userID) {
        return userService.getSelectedTheme(userID);
    }

}