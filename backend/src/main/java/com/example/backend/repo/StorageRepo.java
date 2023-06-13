package com.example.backend.repo;

import com.example.backend.model.Storage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepo extends MongoRepository<Storage, String> {

}
