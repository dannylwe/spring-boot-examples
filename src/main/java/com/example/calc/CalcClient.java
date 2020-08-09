package com.example.calc;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CalcClient extends WebServiceGatewaySupport {
    public AddResponse getAddResponse() {
        Add request = new Add();
        request.setIntA(4);
        request.setIntB(9);
        AddResponse response = (AddResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        return response;
    }

}
