package com.example.backend.service;
import com.example.backend.model.Storage;
import com.example.backend.repo.StorageRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class StorageServiceTest {

    StorageRepo storageRepo = mock(StorageRepo.class);
    StorageService storageService = new StorageService(storageRepo);

    @Test
    void getStorages() {
        //GIVEN
        when(storageRepo.findAll()).thenReturn(List.of());
        //WHEN
        List<Storage> actual = storageService.getStorages();
        //THEN
        assertEquals(List.of(), actual);
        verify(storageRepo).findAll();
    }

    @Test
    void testAddStorage() throws IOException, URISyntaxException {
        //GIVEN
        String id = "your-id";
        String description = "your-description";
        int crtsOrg = 10;
        int crtsNow = 20;
        MultipartFile imageFile = new MockMultipartFile(
                "image",
                "crateGo_logo.png",
                "image/png",
                Files.readAllBytes(Paths.get(getClass().getResource("/images/crateGo_logo.png").toURI()))
        );
        Storage expectedStorage = new Storage();
        when(storageRepo.save(any(Storage.class))).thenReturn(expectedStorage);
        //WHEN
        Storage createdStorage = storageService.addStorage(id, description, crtsOrg, crtsNow, imageFile);
        //THEN
        verify(storageRepo).save(Mockito.any(Storage.class));
        Assertions.assertEquals(expectedStorage, createdStorage);
    }
}