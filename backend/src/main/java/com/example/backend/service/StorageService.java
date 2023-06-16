package com.example.backend.service;

import com.example.backend.model.Storage;
import com.example.backend.repo.StorageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor

public class StorageService {

    private final StorageRepo storageRepo;

    public List<Storage> getStorages() {
        return storageRepo.findAll();
    }

    public Storage addStorage(Storage storage) {
        return storageRepo.save(storage);
    }

    public Storage createStorage(String description, MultipartFile file) throws IOException {
        Storage storage = new Storage();
        storage.setDescription(description);
        storage.setImage(file.getBytes());
        return storageRepo.save(storage);
    }
}
