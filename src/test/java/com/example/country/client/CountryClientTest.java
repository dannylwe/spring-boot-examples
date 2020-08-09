package com.example.country.client;

import com.example.country.config.CountryClientConfig;
import com.example.country.wsdl.CapitalCityResponse;
import com.example.country.wsdl.CountryName;
import com.example.country.wsdl.CountryNameResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class CountryClientTest {


    @Test
    public void testGetCapitalCity() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CountryClientConfig.class);
        CountryClient countryClient = context.getBean(CountryClient.class);
        CapitalCityResponse response = countryClient.getCapitalCity("KE");
        countryClient.printCapitalCity(response);
        context.close();
        assertEquals("Nairobi", response.getCapitalCityResult());
    }

    @Test
    public void testGetCurrencyName() {
        CountryNameResponse nameResponse = new CountryNameResponse();
        nameResponse.setCountryNameResult("Kenya");

        var countryName = new CountryName();
        countryName.setSCountryISOCode("KE");

        CountryClient countryClientMock = mock(CountryClient.class);

        when(countryClientMock.getCurrencyName()).thenReturn(nameResponse);
        assertEquals("Kenya", nameResponse.getCountryNameResult());
    }
}