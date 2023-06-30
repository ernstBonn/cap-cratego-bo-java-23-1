package com.example.backend.service;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

@Service
class SetUUIDTest {
    SetUUID setUUID = new SetUUID();
    @Test
    void setUUID() {
        String actualUUID = setUUID.setUUID();

        assertNotNull(actualUUID);
    }
}


