package com.example.calc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CalcClientTest {

    @Autowired
    CalcClient client;

    @Test
    public void getAddResponse() {
        AddResponse response = new AddResponse();
        response.setAddResult(3);

        CalcClient clientMock = mock(CalcClient.class);
        when(clientMock.getAddResponse()).thenReturn(response);

        assertEquals(3, response.getAddResult());
    }
}