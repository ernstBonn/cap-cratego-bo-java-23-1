package com.example.backend.repo;

import com.example.backend.model.Storage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StorageRepo {

    private final Map<String, Storage> storageMap = new HashMap<>();

    public List<Storage> getStorages() {
        return new ArrayList<>(storageMap.values());
    }

    public Storage addTask(Storage storage) {
        storageMap.put(storage.getId(), storage);
        return storage;
    }
}
