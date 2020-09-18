package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User(0, "Roque", "Pistone", "Rocky", "a1a2a3", "roco2020@gmail.com");
    }

    @Test
    void getIdUserTest(){
        int expectedId = 0;
        assertEquals(expectedId, user.getIdUser());
    }

    @Test
    void getNameTest() {
        String expectedName = "Roque";
        assertEquals(expectedName, user.getName());
    }

    @Test
    void getSurnameTest() {
        String expectedSurname = "Pistone";
        assertEquals(expectedSurname, user.getSurname());
    }

    @Test
    void getNickTest() {
        String expectedNick = "Rocky";
        assertEquals(expectedNick, user.getNick());
    }

    @Test
    void getEmailTest() {
        String expectedEmail = "roco2020@gmail.com";
        assertEquals(expectedEmail, user.getEmail());
    }

    @Test
    void getPasswordTest(){
        String expectedPassword = "a1a2a3";
        assertEquals(expectedPassword, user.getPassword());
    }
}