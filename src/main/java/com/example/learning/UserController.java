package com.example.learning;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    List<User> all() {
        return repository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void  addUser(@RequestBody String user) {
        JSONObject object = JSON.parseObject(user);
        String username = object.getString("username");
        String password = object.getString("password");
        User newUser = new User(username,password);
        repository.save(newUser);
    }



    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }


}
