package com.example.backend.service;

import com.example.backend.model.AppUser;
import com.example.backend.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final SetUUID setUUID;

    public AppUser addAppUser(AppUser user) {
        user.setId(setUUID.setUUID());
        userRepo.insert(user);
        return user;
    }

    public List<AppUser> getUsers() {
        return userRepo.findAll();
    }
}
