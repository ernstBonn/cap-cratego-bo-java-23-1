package com.example.backend.controller;

import com.example.backend.model.AppUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static reactor.core.publisher.Mono.when;

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
    @DirtiesContext
    @WithMockUser()
    void testGetMe() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/api/login")
                        .with(csrf()))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/me")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                        "id": "id",
                        "username": "name",
                        "storages": ["storage"]
                        }
                        """
                ).with(csrf()))
                .andExpect(status().isOk());
    }
}
