package com.example.backend.service;

import com.example.backend.model.AppUser;
import com.example.backend.model.AppUserDTO;
import com.example.backend.model.Storage;
import com.example.backend.repo.StorageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class StorageService {

    private final StorageRepo storageRepo;

    public List<Storage> getStorages() {
        return storageRepo.findAll();
    }

    public Storage addStorage(Storage storage){return storageRepo.save(storage);}

    public List<Storage> getUserStorages() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser authenticatedUser = (AppUser) authentication.getPrincipal();

        List<String> storages = authenticatedUser.getStorages();

        List<Storage> storageList = storageRepo.findAllById(storages);

        return storageList;
    }
}
