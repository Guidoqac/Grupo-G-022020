package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UserTest {

    private User user;

    private Reward rewardMock1;

    private Reward rewardMock2;

    private Reward rewardMock3;

    private ArrayList<Reward> rewardsMock;

    @BeforeEach
    void setUp() {
        rewardMock1 = mock(Reward.class);
        rewardMock2 = mock(Reward.class);
        rewardMock3 = mock(Reward.class);
        rewardsMock = mock(ArrayList.class);
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

    @Test
    void addRewardTest(){
        user.addReward(rewardMock1);
        user.addReward(rewardMock2);
        int amountExpected = 2;
        assertEquals(amountExpected, user.getRewards().size());
    }

}