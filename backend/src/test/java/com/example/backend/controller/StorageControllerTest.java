package com.example.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StorageControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    @DirtiesContext
    void getStorages() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/api/storages"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    @DirtiesContext
    void addStorage() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/api/storage/new")
                .contentType("application/json")
                .content("""
                                {
                                    "id": "055",
                                    "description": "feathers",
                                    "crts_org": 49,
                                    "crts_now": 32
                                }
                            """))
            .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders.get("/api/storages"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                            [
                                {
                                    "id": "055",
                                    "description": "feathers",
                                    "crts_org": 49,
                                    "crts_now": 32
                                }
                            ]
                            """)).andExpect(jsonPath("$[0].id").isNotEmpty());
    }
}