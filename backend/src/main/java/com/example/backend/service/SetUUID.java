package com.example.backend.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SetUUID {

    public String setUUID(){
        return UUID.randomUUID().toString();
    }
}
