package ar.edu.unq.desapp.grupoG.backenddesappapi.service;

import javax.annotation.PostConstruct;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Donation;
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

        Donation don1 = new Donation(0, 1, 500.0 , "Buenisimo1",  LocalDate.now());
        Donation don2 = new Donation(0, 1, 1500.0 , "Buenisimo2",  LocalDate.now());
        Donation don3 = new Donation(0, 1, 2500.0 , "Buenisimo3",  LocalDate.now());

        Location locationToninas = new Location("Las Toninas", "Buenos Aires", 5000, "Un status");
        LocalDate startProjectDate = LocalDate.of(1996, 04, 25);
        LocalDate closeProjectDate = LocalDate.now();

        Project project = new Project(locationToninas, 2000.0, "Salvemos a Las Toninas", closeProjectDate, startProjectDate);
        //locationToninas.setProject(project);
        project.addDonation(don1);
        project.addDonation(don2);
        project.addDonation(don3);

        //don1.setProject(project);
        //don2.setProject(project);
        //don3.setProject(project);

        project.setLastDonationDate(LocalDate.now());

        projectService.save(project);
    }
}
