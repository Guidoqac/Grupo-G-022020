package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import antlr.collections.List;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Donation;

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
    void getIdProjectDonationTest(){
        assertEquals(2, donation.getIdProject());
    }
    
    @Test
    void getAmountDonationTest(){
        assertEquals(5000.45, donation.getAmount());
    }
}
