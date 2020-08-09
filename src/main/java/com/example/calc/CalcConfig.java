package com.example.calc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CalcConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setPackagesToScan("com.example.calc");
//        marshaller.setContextPath("com.example.calc");
        return marshaller;
    }

    public CalcClient Calclient(Jaxb2Marshaller marshaller) {
        CalcClient calcClient = new CalcClient();
        calcClient.setDefaultUri("http://www.dneonline.com/calculator.asmx");
        calcClient.setMarshaller(marshaller);
        calcClient.setUnmarshaller(marshaller);
        return calcClient;
    }
}
