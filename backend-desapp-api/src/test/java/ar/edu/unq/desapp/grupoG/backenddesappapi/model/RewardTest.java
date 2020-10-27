package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RewardTest {

    private Reward reward;

    private Reward rewardWithoutId;

    private User user;

    @BeforeEach
    void setUp() {
        String description = "Descuento";
        String code = "102354gw1";
        int pointsNeeded = 500;
        user = new User(0, "Gonza", "Veron", "Spore", "12345", "gonza@gmail.com");

        reward = new Reward(0, user, description, code, pointsNeeded);
        rewardWithoutId = new Reward(user, description, code, pointsNeeded);
    }

    @Test
    void nullIdTest(){
        assertNull(rewardWithoutId.getIdReward());
    }

    @Test
    void getCode() {
        String codeExpected = "102354gw1";
        assertEquals(codeExpected, reward.getCode());
    }

    @Test
    void getDescription() {
        String descriptionExpected = "Descuento";
        assertEquals(descriptionExpected, reward.getDescription());
    }

    @Test
    void setDescription() {
        String newDesc = "codacy pls";
        reward.setDescription(newDesc);
        assertEquals(newDesc, reward.getDescription());
    }

    @Test
    void getPoints() {
        int pointsExpected = 500;
        assertEquals(pointsExpected, reward.getPoints());
    }

    @Test
    void setPoints() {
        int newPoints = 1635412;
        reward.setPoints(newPoints);
        assertEquals(newPoints, reward.getPoints());
    }

    @Test
    void getIdReward() {
        int idExpected = 0;
        assertEquals(idExpected, reward.getIdReward());
    }

    @Test
    void getIdUser() {
        User userExpected = user;
        assertEquals(userExpected, reward.getUser());
    }

}