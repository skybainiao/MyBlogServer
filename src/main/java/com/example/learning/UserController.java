package com.example.learning;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    List<User> all() {
        return repository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    User addUser() {
        User newUser = new User("Sofia","Software engineer");
        repository.save(newUser);
        return newUser;
    }



}
