package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import javax.annotation.PostConstruct;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class InitServiceInMemory {

    //@Autowired
    //private UserService userService;

    @Autowired
    private ProjectService projectService;

    @PostConstruct
    public void initialize() {
        fireInitialData();
    }

    private void fireInitialData() {
        //User user = new User(5, "Gonza", "veron", "Spore", "2135", "user@gmail.com");
        //userService.save(user);

        Location locationToninas = new Location("Las Toninas", "Buenos Aires", 5000, "Un status");
        LocalDate startProjectDate = LocalDate.of(1996, 04, 25);
        LocalDate closeProjectDate = LocalDate.now();

        Project project = new Project(locationToninas, 2000.0, "Salvemos a Las Toninas", closeProjectDate, startProjectDate);

        projectService.save(project);
    }
}
