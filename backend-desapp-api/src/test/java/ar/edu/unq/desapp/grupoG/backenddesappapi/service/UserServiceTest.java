package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService us;

    @Test
    void saveTest() {
        User user1 = new User(0, "Pedro", "Picapiedra", "PP", "16asd34", "user@gmail.com");

        us.save(user1);

        Mockito.verify(userRepository, times(2)).save(user1);
    }
}