package ar.edu.unq.desapp.grupoG.backenddesappapi;

import javax.annotation.PostConstruct;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.LocationService;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.ProjectService;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.UserService;
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

    @Autowired
    private LocationService locationService;

    @PostConstruct
    public void initialize() throws Exception {
        fireInitialData();
    }

    private void fireInitialData() throws Exception {
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


        Location loc1 = new Location("Loc1", "prov1", 50, "Status");
        Location loc2 = new Location("Loc2", "prov2", 50, "Status");
        Location loc3 = new Location("Loc3", "prov3", 50, "Status");
        Location loc4 = new Location("Loc4", "prov4", 50, "Status");
        Location loc5 = new Location("Loc5", "prov5", 50, "Status");
        Location loc6 = new Location("Loc6", "prov6", 50, "Status");
        Location loc7 = new Location("Loc7", "prov7", 50, "Status");
        Location loc8 = new Location("Loc8", "prov8", 50, "Status");
        Location loc9 = new Location("Loc9", "prov9", 50, "Status");
        Location loc10 = new Location("Loc10", "prov10", 50, "Status");
        Location loc11 = new Location("Loc11", "prov11", 50, "Status");
        Location loc12 = new Location("Loc12", "prov12", 50, "Status");
        Location loc13 = new Location("Loc13", "prov13", 50, "Status");

        Project proj1 = new Project(loc1, 10.0, "Proj1", LocalDate.now(), LocalDate.now());
        Project proj2 = new Project(loc2, 10.0, "Proj2", LocalDate.now(), LocalDate.now());
        Project proj3 = new Project(loc3, 10.0, "Proj3", LocalDate.now(), LocalDate.now());
        Project proj4 = new Project(loc4, 10.0, "Proj4", LocalDate.now(), LocalDate.now());
        Project proj5 = new Project(loc5, 10.0, "Proj5", LocalDate.now(), LocalDate.now());
        Project proj6 = new Project(loc6, 10.0, "Proj6", LocalDate.now(), LocalDate.now());
        Project proj7 = new Project(loc7, 10.0, "Proj7", LocalDate.of(2020, 7, 22), LocalDate.now());
        Project proj8 = new Project(loc8, 10.0, "Proj8", LocalDate.now(), LocalDate.now());
        Project proj9 = new Project(loc9, 10.0, "Proj9", LocalDate.now(), LocalDate.now());
        Project proj10 = new Project(loc10, 10.0, "Proj10", LocalDate.now(), LocalDate.now());
        Project proj11 = new Project(loc11, 10.0, "Proj11", LocalDate.now(), LocalDate.now());
        Project proj12 = new Project(loc12, 10.0, "Proj12", LocalDate.now(), LocalDate.now());
        Project proj13 = new Project(loc13, 10.0, "Proj13", LocalDate.now(), LocalDate.now());


        proj7.closeProject();
        //project.addDonation(don1);
        //project.addDonation(don2);
        //project.addDonation(don3);

        //project1.setLastDonationDate(LocalDate.now());

        //projectService.save(project1);
        //projectService.save(project2);

        projectService.save(proj1);
        projectService.save(proj2);
        projectService.save(proj3);
        projectService.save(proj4);
        projectService.save(proj5);
        projectService.save(proj6);
        projectService.save(proj7);
        projectService.save(proj8);
        projectService.save(proj9);
        projectService.save(proj10);
        projectService.save(proj11);
        projectService.save(proj12);
        projectService.save(proj13);
    }
}
