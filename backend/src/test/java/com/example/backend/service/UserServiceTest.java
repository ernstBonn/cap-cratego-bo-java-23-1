package com.example.backend.service;

import com.example.backend.model.AppUser;
import com.example.backend.model.AppUserDTO;
import com.example.backend.model.Storage;
import com.example.backend.repo.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static de.flapdoodle.embed.mongo.packageresolver.PlatformMatch.any;
import static org.bouncycastle.math.ec.rfc8032.Ed448.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserServiceTest {


    @Mock
    private UserRepo userRepo;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private SetUUID setUUID;
    private UserService userService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepo, setUUID);
    }

    @Test
    void loadUserByUsername() {
        //GIVEN
        String userName = "user";
        String password = "123";

        AppUser appUser = new AppUser();
        appUser.setUsername(userName);
        appUser.setPassword(password);

        //WHEN
        when(userRepo.findAppUserByUsername(userName)).thenReturn(Optional.of(appUser));
        UserDetails result = userService.loadUserByUsername(userName);
        //THEN
        assertEquals(userName, result.getUsername());
        assertEquals(password, result.getPassword());
    }

    @Test
    void addUser() {

    }
}