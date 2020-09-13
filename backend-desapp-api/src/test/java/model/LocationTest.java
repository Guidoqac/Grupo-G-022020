package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Qualification;

public class LocationTest {
    private Location location;

    @BeforeEach
    void setUp() {
        location= new Location(0, "Quilmes", "Buenos Aires", 100, true);
    }

    @Test
    void getIdQualificationTest(){
        int expectedId = 0;
        assertEquals(expectedId, location.getId());
    }
}
