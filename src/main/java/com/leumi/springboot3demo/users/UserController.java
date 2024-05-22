package com.leumi.springboot3demo.users;

import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/users")
public class UserController {
    Logger log=LoggerFactory.getLogger(UserController.class);

    @GetMapping("/")
    public String getAllUsers() {
        log.info("Got a get request");
        return "Got users";
    }
}
