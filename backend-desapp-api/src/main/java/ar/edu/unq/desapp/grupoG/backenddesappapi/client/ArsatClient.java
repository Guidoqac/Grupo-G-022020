package ar.edu.unq.desapp.grupoG.backenddesappapi.client;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.ArsatData;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;


public class ArsatClient {

    private final RestTemplate restTemplate;

    public ArsatClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public ArsatData getLocations(){
        String url = "https://prod.arsat.apim.junar.com/plan-federal-de-internet/v1/puntos/futuros.json/?auth_key=GmxMgYaeRBUzieHrRGgmYnjTrJ4nlZMQvCQVxgYN";
        return this.restTemplate.getForObject(url, ArsatData.class);
    }

}
