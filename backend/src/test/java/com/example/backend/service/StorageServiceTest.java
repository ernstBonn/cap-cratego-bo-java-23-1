package com.example.backend.service;

import com.example.backend.model.Storage;
import com.example.backend.repo.StorageRepo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class StorageServiceTest {

    StorageRepo repo = mock(StorageRepo.class);
    StorageService service = new StorageService(repo);

    @Test
    void getStorages() {
        //GIVEN
        when(repo.findAll()).thenReturn(List.of());
        //WHEN
        List<Storage> actual = service.getStorages();
        //THEN
        assertEquals(List.of(), actual);
        verify(repo).findAll();
    }

    @Test
    void addStorage() {
    //GIVEN
        Storage asserted = new Storage("055", "feathers", 49, 32);
        when(repo.save(asserted)).thenReturn(asserted);
    //WHEN
        Storage actual = repo.save(asserted);
    //THEN
        assertEquals(asserted, actual);
        verify(repo).save(asserted);
    }
}