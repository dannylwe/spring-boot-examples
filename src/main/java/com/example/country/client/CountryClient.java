package com.example.country.client;

import com.example.country.wsdl.CapitalCity;
import com.example.country.wsdl.CapitalCityResponse;
import com.example.country.wsdl.CountryName;
import com.example.country.wsdl.CountryNameResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CountryClient extends WebServiceGatewaySupport {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryClient.class);

    public CapitalCityResponse getCapitalCity (String city) {
        CapitalCity request = new CapitalCity();
        request.setSCountryISOCode(city);

        LOGGER.info("Requesting capital city for " + city + " ...");

//        CapitalCityResponse response = (CapitalCityResponse) getWebServiceTemplate()
//                .marshalSendAndReceive(request);

        CapitalCityResponse response = (CapitalCityResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso",
                        request, new SoapActionCallback("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso/CapitalCity"));
        return response;
    }

    public void printCapitalCity(CapitalCityResponse response) {
        var getCapital = response.getCapitalCityResult();
        if(!getCapital.isEmpty()) {
            LOGGER.info("The capital is " + getCapital);
        } else {
            LOGGER.info("No capital city received");
        }
    }

    public CountryNameResponse getCurrencyName() {
        CountryName country = new CountryName();
        country.setSCountryISOCode("IND");

        LOGGER.info(String.valueOf(country));

        return (CountryNameResponse) getWebServiceTemplate().marshalSendAndReceive(country);

    }
}
