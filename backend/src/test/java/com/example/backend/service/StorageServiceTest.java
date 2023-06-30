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
        Storage storage = Storage.builder()
                .id("storageId")
                .description("storageDescription")
                .cratesOrg(10)
                .cratesNow(5)
                .build();

        when(storageRepo.save(storage)).thenReturn(storage);
        //WHEN
        Storage result = storageService.addStorage(storage);
        //THEN
        verify(storageRepo).save(storage);
        Assertions.assertEquals(storage, result);
    }
}