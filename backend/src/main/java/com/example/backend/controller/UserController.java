package com.example.backend.controller;


import com.example.backend.model.AppUser;
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
    public List<AppUser> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("user")
    public AppUser addUser(@RequestBody AppUser user) {
        return userService.addAppUser(user);
    }
}
