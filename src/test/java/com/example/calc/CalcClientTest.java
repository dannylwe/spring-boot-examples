package com.example.calc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CalcClientTest {

    @Autowired
    CalcClient client;

    @Test
    public void getAddResponse() {
        AddResponse response;
        response = client.getAddResponse();
        assertEquals(3, response.getAddResult());
    }
}