package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import javax.annotation.PostConstruct;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class InitServiceInMemory {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @PostConstruct
    public void initialize() {
        fireInitialData();
    }

    private void fireInitialData() {
        User user1 = new User("Gonza", "veron", "Spore", "asdasdas", "gonza@gmail.com");
        User user2 = new User("Guido", "Montorfano", "Quilmes", "12345", "guido@gmail.com");
        userService.save(user1);
        userService.save(user2);

        //Donation don1 = new Donation(0, 1, 500.0 , "Buenisimo1");
        //Donation don2 = new Donation(0, 1, 1500.0 , "Buenisimo2",  LocalDate.now());
        //Donation don3 = new Donation(0, 1, 2500.0 , "Buenisimo3",  LocalDate.now());

        Location locationToninas = new Location("Las Toninas", "Buenos Aires", 5000, "Un status");
        LocalDate startProjectDateT = LocalDate.of(1996, 04, 25);
        LocalDate closeProjectDateT = LocalDate.now();
        Project project1 = new Project(locationToninas, 2000.0, "Salvemos a Las Toninas", closeProjectDateT, startProjectDateT);

        Location locationBernal = new Location("Bernal", "Buenos Aires", 7000, "Un status");
        LocalDate startProjectDateB = LocalDate.of(2020, 01, 13);
        LocalDate closeProjectDateB = LocalDate.of(2020, 11, 5);
        Project project2 = new Project(locationBernal, 2000.0, "Salvemos a Las Toninas", closeProjectDateB, startProjectDateB);


        //project.addDonation(don1);
        //project.addDonation(don2);
        //project.addDonation(don3);

        //project1.setLastDonationDate(LocalDate.now());

        projectService.save(project1);
        projectService.save(project2);
    }
}
