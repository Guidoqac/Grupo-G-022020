package ar.edu.unq.desapp.grupoG.backenddesappapi.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QualificationTest {

    private Qualification qualification;

    @BeforeEach
    void setUp() {
        String comment = "A beautiful comment";
        qualification = new Qualification(0, 11, 33, 12, 7, comment);
    }

    @Test
    void GetIdQualificationTest(){
        int expectedIdQualif = 0;
        assertEquals(expectedIdQualif, qualification.getIdQualification());
    }

    @Test
    void GetIdUserTest() {
        int expectedIdUser = 11;
        assertEquals(expectedIdUser, qualification.getIdUser());
    }

    @Test
    void GetIdLocationTest() {
        int expectedIdLocation = 33;
        assertEquals(expectedIdLocation, qualification.getIdLocation());
    }

    @Test
    void GetIdDonationTest() {
        int expectedIdDonation = 12;
        assertEquals(expectedIdDonation, qualification.getIdDonation());
    }

    @Test
    void GetScoreTest() {
        int expectedScore = 7;
        assertEquals(expectedScore, qualification.getScore());
    }

    @Test
    void GetCommentTest() {
        String expectedComment = "A beautiful comment";
        assertEquals(expectedComment, qualification.getComment());
    }
}