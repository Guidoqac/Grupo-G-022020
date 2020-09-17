package ar.edu.unq.desapp.grupoG.backenddesappapi.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Qualification;

import static org.junit.jupiter.api.Assertions.*;

class QualificationTest {

    private Qualification qualification;

    @BeforeEach
    void setUp() {
        String comment = "A beautiful comment";
        qualification = new Qualification(0, 11, 33, 12, 7, comment);
    }

    @Test
    void getIdQualificationTest(){
        int expectedIdQualif = 0;
        assertEquals(expectedIdQualif, qualification.getIdQualification());
    }

    @Test
    void getIdUserTest() {
        int expectedIdUser = 11;
        assertEquals(expectedIdUser, qualification.getIdUser());
    }

    @Test
    void getIdLocationTest() {
        int expectedIdLocation = 33;
        assertEquals(expectedIdLocation, qualification.getIdLocation());
    }

    @Test
    void getIdDonationTest() {
        int expectedIdDonation = 12;
        assertEquals(expectedIdDonation, qualification.getIdDonation());
    }

    @Test
    void getScoreTest() {
        int expectedScore = 7;
        assertEquals(expectedScore, qualification.getScore());
    }

    @Test
    void getCommentTest() {
        String expectedComment = "A beautiful comment";
        assertEquals(expectedComment, qualification.getComment());
    }
}