package com.example.learning;

import com.google.gson.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserRepository repository;
    private Gson gson = new Gson();

    UserController(UserRepository repository) {
        this.repository = repository;
        gson = new Gson();
    }

    @GetMapping("/users")
    List<User> all() {
        return repository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void  addUser(@RequestBody String user) {
        User newUser = gson.fromJson(user,User.class);
        repository.save(newUser);
    }



    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }


}
