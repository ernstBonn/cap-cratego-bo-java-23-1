package com.example.backend.service;

import com.example.backend.model.AppUser;
import com.example.backend.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepo.findAppUserByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username:" + username + " not found"));
        return new User(appUser.getName(), appUser.getPassword(), List.of());
    }
}
