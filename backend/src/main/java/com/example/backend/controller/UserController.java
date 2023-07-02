package com.example.backend.controller;

import com.example.backend.model.AppUser;
import com.example.backend.model.AppUserDTO;
import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping("me")
    public String getMe(){
        return userService.getMe();
    }

    @PostMapping("register")
    public AppUserDTO addUser(@RequestBody AppUser user) {
        return userService.addUser(user);
    }

    @PostMapping("login")
    public String login() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }


}
