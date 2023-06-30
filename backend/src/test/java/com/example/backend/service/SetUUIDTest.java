package com.example.backend.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetUUIDTest {
    SetUUID setUUID = new SetUUID();
    @Test
    void setUUID() {
        String actualUUID = setUUID.setUUID();

        assertNotNull(actualUUID);
    }
}


