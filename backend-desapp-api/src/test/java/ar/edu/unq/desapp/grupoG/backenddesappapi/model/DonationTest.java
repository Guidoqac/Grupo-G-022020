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
    void NullIdTest(){
        assertNull(donationWithoutId.getId());
    }

    @Test
    void GetIdDonationTest() {
        int expectedId = 0;
        assertEquals(expectedId, donation.getId());
    }
    
    @Test
    void GetIdUserDonationTest(){
        int expectedUserId = 1;
        assertEquals(expectedUserId, donation.getIdUser());
    }
    
    @Test
    void GetIdProjectDonationTest(){
        int expectedIdProject = 2;
        assertEquals(expectedIdProject, donation.getIdProject());
    }
    
    @Test
    void GetAmountDonationTest(){
        double expectedAmountDonation = 5000.45;
        assertEquals(expectedAmountDonation, donation.getAmount());
    }

    @Test
    void SetIdTest(){
        donation.setId(7);
        int expectedIdDonation = 7;
        assertEquals(expectedIdDonation, donation.getId());
    }

    @Test
    void SetIdUserTest(){
        donation.setIdUser(55);
        int expectedIdUser = 55;
        assertEquals(expectedIdUser, donation.getIdUser());
    }

    @Test
    void SetIdProject(){
        donation.setIdProject(70);
        int expectedIdProject = 70;
        assertEquals(expectedIdProject, donation.getIdProject());
    }

    @Test
    void SetAmountTest(){
        donation.setAmount(8000.0);
        double expectedAmount = 8000.0;
        assertEquals(8000.0, donation.getAmount());
    }

}
