package com.example.backend.controller;

import com.example.backend.model.AppUser;
import com.example.backend.model.AppUserDTO;
import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("me")
    public AppUserDTO getMe(){
        AppUser user = userService.getMe().orElseThrow(()-> new ResponseStatusException(HttpStatus.UNAUTHORIZED));
        return new AppUserDTO(user.getId(), user.getUsername(), user.getStorages());
    }

    @PostMapping("register")
    public AppUserDTO addUser(@RequestBody AppUser user) {
        return userService.addUser(user);
    }

    @PostMapping("login")
    public String login() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @PutMapping("user/{id}")
    public AppUser updateUser(@PathVariable("id") String id, @RequestBody AppUser user) {
        return userService.updateUser(id, user);
    }
}
