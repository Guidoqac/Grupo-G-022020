package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DonationTest {

	private Donation donation;

	private Donation donationWithoutId;

	private String comment;

	private LocalDate donationDate;

    @BeforeEach
    void setUp() {
        donationDate = LocalDate.now();
        comment = "A beautiful comment";
        donation = new Donation(0, 1, 2, 5000.45, comment, donationDate);
        donationWithoutId = new Donation(1, 3, 50.5, comment, donationDate);
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

    @Test
    void getCommentTest(){
        assertEquals(comment, donation.getComment());
    }

    @Test
    void setCommentTest(){
        String newComment = "relleno";
        donation.setComment(newComment);
        assertEquals(newComment, donation.getComment());
    }

    @Test
    void getDonationDateTest(){
        assertEquals(donationDate, donation.getDonationDate());
    }

}
