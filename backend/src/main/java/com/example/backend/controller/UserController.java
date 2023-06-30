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

    //    @PostMapping("register")
//    public void addUser(@RequestBody AppUserDTO user) {
//    }
    @PostMapping("register")
    public void addUser(@RequestBody AppUser user) {
    }

    @PostMapping("login")
    public String login() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
