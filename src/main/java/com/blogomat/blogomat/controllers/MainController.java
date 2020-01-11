package com.blogomat.blogomat.controllers;


import com.blogomat.blogomat.model.entities.User;
import com.blogomat.blogomat.model.entities.dataObjects.CredentialsVO;
import com.blogomat.blogomat.services.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    User logUserIn(@RequestParam CredentialsVO credentialsVO) {
        return userService.logUserIn(credentialsVO.getLogin(), credentialsVO.getPassword());
    }

    @PostMapping(path = "/register")
    public @ResponseBody
    User registerNewUser(@RequestBody User u) {
        return userService.registerNewUser(u);
    }
}