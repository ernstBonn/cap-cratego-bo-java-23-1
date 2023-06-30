package com.example.backend.service;

import com.example.backend.model.AppUser;
import com.example.backend.model.AppUserDTO;
import com.example.backend.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.method.P;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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

//    public void addUser(AppUserDTO user) {
//        if (userRepo.findAppUserByUsername(user.getUsername()).equals(user.getUsername())){
//            throw new IllegalArgumentException("Username already taken");
//        }
//        PasswordEncoder encoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();
//        AppUser realUser = new AppUser(
//                setUUID.setUUID(),
//                user.getUsername(),
//                encoder.encode(user.getPassword()),
//                List.of());
//        userRepo.save(realUser);
//    }

    public void addUser(AppUser user) {
        if (userRepo.findAppUserByUsername(user.getUsername()).equals(user.getUsername())){
            throw new IllegalArgumentException("Username already taken");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.insert(user);
    }
}
