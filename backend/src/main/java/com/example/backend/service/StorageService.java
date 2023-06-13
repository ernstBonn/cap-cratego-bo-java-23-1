package com.example.backend.service;

import com.example.backend.model.Storage;
import com.example.backend.repo.StorageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StorageService {

    private final StorageRepo storageRepo;

    public List<Storage> getStorages() {
        return storageRepo.getStorages();
    }

    public Storage addStorage(Storage storage) {
        return storageRepo.addTask(storage);
    }
}
