package com.example.backend.controller;
import com.example.backend.model.Storage;
import com.example.backend.repo.StorageRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.io.InputStream;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StorageControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    StorageRepo storageRepo;

    @Test
    @DirtiesContext
    @WithMockUser(username = "user", password = "123")
    void getStorages() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/storages"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    @DirtiesContext
    @WithMockUser(username = "user", password = "123")
    void testAddStorage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/storage")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                        "id": "idString",
                        "description": "descriptionString" ,
                        "cratesOrg": 10,
                        "cratesNow": 5
                        }
                        """
                ).with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                            {
                            "id": "idString",
                            "description": "descriptionString" ,
                            "cratesOrg": 10,
                            "cratesNow": 5
                            }
                            """
                ))
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

    @Test
    @DirtiesContext
    @WithMockUser(username = "user", password = "123")
    void testGetStorageById() throws Exception {

        storageRepo.save(new Storage("100", "description", 100, 50));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/storage/100"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                            {
                            "id": "100",
                            "description": "description",
                            "cratesOrg": 100,
                            "cratesNow": 50
                            }
                            """
                ))
                .andExpect(jsonPath("$.id").isNotEmpty());
    }
}