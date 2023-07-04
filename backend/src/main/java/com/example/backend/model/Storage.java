package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("Storages")
public class Storage {

    private String id;
    private String description;
    private int cratesOrg;
    private int cratesNow;

}