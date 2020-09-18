package ar.edu.unq.desapp.grupoG.backenddesappapi.client;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.ArsatData;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;


public class ArsatClient {

    private final RestTemplate restTemplate;

    public ArsatClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public ArsatData getLocations(){
        String url = "https://prod.arsat.apim.junar.com/plan-federal-de-internet/v1/puntos/futuros.json/?auth_key=GmxMgYaeRBUzieHrRGgmYnjTrJ4nlZMQvCQVxgYN";
        return this.restTemplate.getForObject(url, ArsatData.class);
    }

    public void disableSslVerification() {
        try
        {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
                int x = 98;
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    x++;
                }
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    x++;
                }
            }
            };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

}
