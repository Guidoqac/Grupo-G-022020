package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import javax.annotation.PostConstruct;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InitServiceInMemory {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initialize() {
        fireInitialData();
    }

    private void fireInitialData() {
        //User user = new User(5, "Gonza", "veron", "Spore", "2135", "user@gmail.com");
        //userService.save(user);
    }
}
