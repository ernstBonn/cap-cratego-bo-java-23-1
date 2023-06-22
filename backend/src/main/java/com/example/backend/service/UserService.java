package com.example.backend.service;

import com.example.backend.model.User;
import com.example.backend.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final SetUUID setUUID;


    public User addUser(User user) {
        user.setId(setUUID.setUUID());
        userRepo.save(user);
        return user;
    }
}
