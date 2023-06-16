package com.example.backend.controller;

import com.example.backend.model.Storage;
import com.example.backend.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class StorageController {

    private final StorageService storageService;

    @GetMapping("storages")
        public List<Storage> getStorages(){
            return storageService.getStorages();
        }

    @PostMapping("storage/new")
        public Storage addStorage(@RequestBody Storage storage){
            return storageService.addStorage(storage);
    }

    @PostMapping("image")
    public ResponseEntity<?> createStorage(@RequestParam String description,
                                            @RequestParam("file") MultipartFile file) {
        try {
            Storage createdStorage = storageService.createStorage(description, file);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdStorage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
