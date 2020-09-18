package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DonationTest {

	private Donation donation;

	private Donation donationWithoutId;

    @BeforeEach
    void setUp() {
        donation = new Donation(0, 1, 2, 5000.45);
        donationWithoutId = new Donation(1, 3, 50.5);
    }

    @Test
    void nullIdTest(){
        assertNull(donationWithoutId.getId());
    }

    @Test
    void getIdDonationTest() {
        int expectedId = 0;
        assertEquals(expectedId, donation.getId());
    }
    
    @Test
    void getIdUserDonationTest(){
        int expectedUserId = 1;
        assertEquals(expectedUserId, donation.getIdUser());
    }
    
    @Test
    void getIdProjectDonationTest(){
        int expectedIdProject = 2;
        assertEquals(expectedIdProject, donation.getIdProject());
    }
    
    @Test
    void getAmountDonationTest(){
        double expectedAmountDonation = 5000.45;
        assertEquals(expectedAmountDonation, donation.getAmount());
    }

    @Test
    void setIdTest(){
        donation.setId(7);
        int expectedIdDonation = 7;
        assertEquals(expectedIdDonation, donation.getId());
    }

    @Test
    void setIdUserTest(){
        donation.setIdUser(55);
        int expectedIdUser = 55;
        assertEquals(expectedIdUser, donation.getIdUser());
    }

    @Test
    void setIdProject(){
        donation.setIdProject(70);
        int expectedIdProject = 70;
        assertEquals(expectedIdProject, donation.getIdProject());
    }

    @Test
    void setAmountTest(){
        donation.setAmount(8000.0);
        double expectedAmount = 8000.0;
        assertEquals(expectedAmount, donation.getAmount());
    }

}
