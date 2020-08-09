package com.example.weather.config;

import com.example.weather.prototype.WeatherClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WeatherClientConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.weather.wsdl");
        return marshaller;
    }

    @Bean
    public WeatherClient weatherClient(Jaxb2Marshaller marshaller) {
        final WeatherClient client = new WeatherClient();
        client.setDefaultUri("http://ws.cdyne.com/WeatherWS");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
