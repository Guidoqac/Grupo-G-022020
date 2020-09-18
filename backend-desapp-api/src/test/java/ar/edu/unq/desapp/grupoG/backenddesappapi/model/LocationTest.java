package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocationTest {

    private Location location;

    @BeforeEach
    void setUp() {
        location= new Location(0, "Quilmes", "Buenos Aires", 100, "En Planificación");
    }

    @Test
    void GetIdLocationTest(){
        int expectedId = 0;
        assertEquals(expectedId, location.getId());
    }
    
    @Test
    void GetNameLocationTest(){
        String expectedName = "Quilmes";
        assertEquals(expectedName, location.getName());
    }
    
    @Test
    void GetProvinceLocationTest(){
        String expectedProvinceName = "Buenos Aires";
        assertEquals(expectedProvinceName, location.getProvince());
    }
    
    @Test
    void GetPopulationLocationTest(){
        int expectedPopulationAmount = 100;
        assertEquals(expectedPopulationAmount, location.getPopulation());
    }
    
    @Test
    void GetStateLocationTest(){
        String connectivityStatusExpected = "En Planificación";
        assertEquals(connectivityStatusExpected, location.getStatus());
    }

    @Test
    void SetIdTest(){
        location.setId(77);
        int expectedIdLocation = 77;
        assertEquals(expectedIdLocation, location.getId());
    }

    @Test
    void SetName(){
        location.setName("Avellaneda");
        String expectedName = "Avellaneda";
        assertEquals(expectedName, location.getName());
    }

    @Test
    void SetProvince(){
        location.setProvince("Salta");
        String expectedProvinceName = "Salta";
        assertEquals(expectedProvinceName, location.getProvince());
    }

    @Test
    void SetPopulation(){
        location.setPopulation(999);
        int expectedPopulationAmount = 999;
        assertEquals(expectedPopulationAmount, location.getPopulation());
    }

    @Test
    void SetConnectivityStatusTest(){
        location.setStatus("En linea");
        String connectivityStatusExpected = "En linea";
        assertEquals(connectivityStatusExpected, location.getStatus());
    }
    
}
