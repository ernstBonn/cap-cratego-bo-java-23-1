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
    public Storage addTStorage(@RequestBody Storage storage) {
        return storageService.addStorage(storage);
    }
}
