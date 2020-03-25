package com.example.demo.controllers;

import com.example.demo.models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/users/1", method = RequestMethod.GET)
    public User getUser() {
        return new User(1, "John");
    }

}
