package com.example.learning.Controller;

import com.example.learning.Model.Message;
import com.example.learning.Model.User;
import com.example.learning.Repository.MessageRepository;
import com.example.learning.Repository.UserRepository;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatController {
    private MessageRepository repository;
    private Gson gson;

    public ChatController(MessageRepository repository) {
        this.repository = repository;
        gson = new Gson();
    }

    @GetMapping("/messages")
    List<Message> all() {
        return repository.findAll();
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public void  addUser(@RequestBody String message) {
        Message newMessage = gson.fromJson(message,Message.class);
        repository.save(newMessage);
    }



}
