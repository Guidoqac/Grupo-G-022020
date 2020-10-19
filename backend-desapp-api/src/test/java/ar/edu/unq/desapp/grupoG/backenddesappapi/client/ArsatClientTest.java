package ar.edu.unq.desapp.grupoG.backenddesappapi.client;


import ar.edu.unq.desapp.grupoG.backenddesappapi.model.ArsatData;
import net.minidev.json.writer.JsonReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

class ArsatClientTest {

	//commentario
	
//    private ArsatClient arsat;
//
//
//    @BeforeEach
//    void setUp() {
//        arsat = new ArsatClient(new RestTemplateBuilder());
//        arsat.disableSslVerification();
//    }
//
//    @Test
//    void getLocationsTest(){
//        ArsatData locations = arsat.getLocations();
//
//        System.out.println(locations.data);
//    }
}