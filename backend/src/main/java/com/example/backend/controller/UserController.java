package com.example.backend.controller;


import com.example.backend.model.User;
import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("user")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
