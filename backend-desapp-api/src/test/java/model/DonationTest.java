package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Donation;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Location;

public class DonationTest {
	private Donation donation;

    @BeforeEach
    void setUp() {
        donation = new Donation(0, 1, 2, 5000.45);
    }

    @Test
    void getIdDonationTest(){
        int expectedId = 0;
        assertEquals(expectedId, donation.getId());
    }
    
    @Test
    void getIdUserDonationTest(){
        assertEquals(1, donation.getIdUser());
    }
    
    @Test
    void getIdLocationDonationTest(){
        assertEquals(2, donation.getIdLocation());
    }
    
    @Test
    void getAmountDonationTest(){
        assertEquals(5000.45, donation.getAmount());
    }
}
