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

    @PostMapping("storage")
    public ResponseEntity<Storage> addStorage(@RequestParam String id,
                                            @RequestParam String description,
                                            @RequestParam int crts_org,
                                            @RequestParam int crts_now,
                                            @RequestParam("image") MultipartFile file) {
        try {
            Storage createdStorage = storageService.addStorage(id,description, crts_org, crts_now, file);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdStorage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
