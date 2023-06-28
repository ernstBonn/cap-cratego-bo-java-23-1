package com.example.backend.repo;

import com.example.backend.model.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<AppUser, String> {

    Optional<AppUser> findAppUserByName(String name);
}