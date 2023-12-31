package com.example.backend.controller;
import com.example.backend.model.Storage;
import com.example.backend.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class StorageController {

    private final StorageService storageService;

    @GetMapping("storages")
        public List<Storage> getStorages(){
            return storageService.getStorages();
        }

    @PostMapping("storage")
    public Storage addStorage(@RequestBody Storage storage) {
        return storageService.addStorage(storage);
    }

    @GetMapping("storage")
    public List<Storage> getUserStorages(){
        return storageService.getUserStorages();
    }

    @GetMapping("/storage/{storageId}")
    public Optional<Storage> getStorageById(@PathVariable String storageId){
        return storageService.getStorageById(storageId);
    }

    @PutMapping("/storage/{id}")
    public Storage updateStorage(@PathVariable("id") String id, @RequestBody Storage storage){
        return storageService.updateStorage(id, storage);
    }
}
