package com.example.weather.prototype;

import com.example.weather.config.WeatherClientConfiguration;
import com.example.weather.wsdl.GetCityForecastByZIPResponse;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

class WeatherClientTest {

    @Test
    void getCityForecastByZip() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WeatherClientConfiguration.class);
        WeatherClient weatherClient = context.getBean(WeatherClient.class);
        GetCityForecastByZIPResponse response = weatherClient.getCityForecastByZip("94304");
        weatherClient.printResponse(response);
        context.close();
    }
}