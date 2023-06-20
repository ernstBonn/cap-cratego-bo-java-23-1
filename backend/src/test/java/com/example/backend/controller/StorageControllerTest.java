package com.example.backend.controller;
import com.example.backend.service.StorageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.io.InputStream;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StorageControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private StorageService storageService;

    @Test
    @DirtiesContext
    void getStorages() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/storages"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void testAddStorage() throws Exception {

        InputStream imageStream = getClass().getResourceAsStream("/images/crateGo_logo.png");
        String imageName = "crateGo_logo.png";
        String imageContentType = "image/png";
        MockMultipartFile imageFile = new MockMultipartFile("image", imageName, imageContentType, imageStream);

        String id = "your-id";
        String description = "your-description";
        int crtsOrg = 10;
        int crtsNow = 20;

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.multipart("/api/storage")
                        .file(imageFile)
                        .param("id", id)
                        .param("description", description)
                        .param("crts_org", String.valueOf(crtsOrg))
                        .param("crts_now", String.valueOf(crtsNow))
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();

        // Assert the request and request parameters
        Assertions.assertEquals(id, result.getRequest().getParameter("id"));
        Assertions.assertEquals(description, result.getRequest().getParameter("description"));
        Assertions.assertEquals(String.valueOf(crtsOrg), result.getRequest().getParameter("crts_org"));
        Assertions.assertEquals(String.valueOf(crtsNow), result.getRequest().getParameter("crts_now"));
    }
}