package com.example.backend.service;

import com.example.backend.model.AppUser;
import com.example.backend.model.AppUserDTO;
import com.example.backend.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;
    private final SetUUID setUUID;
    private final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepo.findAppUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username:" + username + " not found"));
        return new User(appUser.getUsername(), appUser.getPassword(), List.of());
    }

    public AppUserDTO addUser(AppUser user) {
        if (userRepo.findAppUserByUsername(user.getUsername()).equals(user.getUsername())){
            throw new IllegalArgumentException("Username already taken");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        user.setStorages(List.of());
        userRepo.insert(user);
        return new AppUserDTO(user.getId(), user.getUsername(), user.getStorages());
    }

    public Optional<AppUser> getMe() {
        return userRepo.findAppUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    public AppUser updateUser(String id, AppUser updatedUser) {
        AppUser user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));

        user.setStorages(updatedUser.getStorages());

        return userRepo.save(user);
    }
}