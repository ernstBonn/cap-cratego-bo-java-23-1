package com.example.backend.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DirtiesContext
    @WithMockUser()
    void addUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                "name": "name",
                                "password": "password"
                                }
                                """
                        ).with(csrf()))
                .andExpect(status().isOk());
    }

    @Test
    @DirtiesContext
    @WithMockUser()
    void login() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                "name": "name",
                                "password": "password"
                                }
                                """
                        ).with(csrf()))
                .andExpect(status().isOk());

mockMvc.perform(MockMvcRequestBuilders.post("/api/login")
        .with(csrf()))
        .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user1", password = "123")
    void testGetMe() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/api/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                "username": "user1",
                                "password": "123"
                                }
                                """
                        ).with(csrf()))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/me")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    {
                      "username": "user1",
                      "storages": []
                    }
                    """))
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

//    @Test
//    @DirtiesContext
//    @WithMockUser(username = "user1", password = "123")
//    void testUpdateUser() throws Exception {
//
//        String userId = "userId";
//        AppUser updatedUser = new AppUser();
//        updatedUser.setStorages();
//
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/user/{id}", userId))
//    }

    @Test
    @DirtiesContext
    @WithMockUser()
    void testLogout() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/logout")
                        .with(csrf()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Logged out"));
    }
}
