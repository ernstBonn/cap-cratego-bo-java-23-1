package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Storage {

    private String id;
    private String description;
    private int crts_org;
    private int crts_now;

}
