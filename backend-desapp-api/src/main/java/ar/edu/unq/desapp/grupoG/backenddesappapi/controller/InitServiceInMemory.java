package ar.edu.unq.desapp.grupoG.backenddesappapi.controller;

import javax.annotation.PostConstruct;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Donation;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.User;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.DonationService;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.LocationService;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.ProjectService;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Controller
@Transactional
public class InitServiceInMemory {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private DonationService donationService;

    @PostConstruct
    public void initialize() throws Exception {
        fireInitialData();
    }

    private void fireInitialData() throws Exception {
        User user1 = new User("Gonza", "veron", "Spore", "asdasdas", "gonveron96@gmail.com");
        User user2 = new User("Guido", "Montorfano", "Quilmes", "12345", "guidomontorfano78@gmail.com");
        
        user1.setAdmin(true);
        user2.setAdmin(true);
        
        userService.save(user1);
        userService.save(user2);

        Donation don1 = new Donation(1, 1, 500.0 , "Buenisimo1");
        Donation don2 = new Donation(1, 1, 1500.0, "Buenisimo2");
        Donation don3 = new Donation(1, 1, 3500.0, "Buenisimo3");
        Donation don4 = new Donation(1, 8, 4500.0, "Buenisimo4");
        Donation don5 = new Donation(2, 8, 5500.0, "Buenisimo5");
        Donation don6 = new Donation(2, 9, 6500.0, "Buenisimo6");
        Donation don7 = new Donation(2, 3, 7500.0, "Buenisimo7");
        Donation don8 = new Donation(2, 3, 8500.0, "Buenisimo8");
        Donation don9 = new Donation(2, 1, 9500.0, "Buenisimo9");
        Donation don10 = new Donation(1, 1, 10500.0, "Buenisimo10");
        Donation don11 = new Donation(1, 5, 11500.0, "Buenisimo11");
        Donation don12 = new Donation(2, 2, 12500.0, "Buenisimo12");
        Donation don13 = new Donation(2, 3, 13500.0, "Buenisimo13");
        Donation don14 = new Donation(1, 5, 14500.0, "Buenisimo14");
        Donation don15 = new Donation(1, 10, 15500.0, "Buenisimo15");
        Donation don16 = new Donation(2, 5, 16500.0, "Buenisimo16");
        Donation don17 = new Donation(2, 13, 17500.0, "Buenisimo17");
        Donation don18 = new Donation(1, 8, 18500.0, "Buenisimo18");
        Donation don19 = new Donation(1, 8, 19500.0, "Buenisimo19");
        Donation don20 = new Donation(2, 10, 20500.0, "Buenisimo20");
        Donation don21 = new Donation(2, 1, 21500.0, "Buenisimo21");
        Donation don22 = new Donation(1, 11, 22500.0, "Buenisimo22");
        Donation don23 = new Donation(1, 10, 23500.0, "Buenisimo23");
        Donation don24 = new Donation(2, 6, 24500.0, "Buenisimo24");
        Donation don25 = new Donation(2, 2, 25500.0, "Buenisimo25");
        Donation don26 = new Donation(1, 2, 26500.0, "Buenisimo26");
        Donation don27 = new Donation(1, 10, 27500.0, "Buenisimo27");
        Donation don28 = new Donation(2, 9, 28500.0, "Buenisimo28");

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

        loc5.setLastDonationDate(LocalDate.of(1996, 4, 13));
        loc12.setLastDonationDate(LocalDate.of(2005, 8, 20));
        loc8.setLastDonationDate(LocalDate.of(2012, 12, 12));


        System.out.println(loc1);

        locationService.save(loc1);
        locationService.save(loc2);
        locationService.save(loc3);
        locationService.save(loc4);
        locationService.save(loc5);
        locationService.save(loc6);
        locationService.save(loc7);
        locationService.save(loc8);
        locationService.save(loc9);
        locationService.save(loc10);
        locationService.save(loc11);
        locationService.save(loc12);
        locationService.save(loc13);


        Project proj1 = new Project(loc1, 10.0, "Proj1", LocalDate.now(), LocalDate.now());
        Project proj2 = new Project(loc2, 10.0, "Proj2", LocalDate.now(), LocalDate.now());
        Project proj3 = new Project(loc3, 10.0, "Proj3", LocalDate.of(2020, 7, 22), LocalDate.now());
        Project proj4 = new Project(loc4, 10.0, "Proj4", LocalDate.now(), LocalDate.now());
        Project proj5 = new Project(loc5, 10.0, "Proj5", LocalDate.now(), LocalDate.now());
        Project proj6 = new Project(loc6, 10.0, "Proj6", LocalDate.now(), LocalDate.now());
        Project proj7 = new Project(loc7, 10.0, "Proj7", LocalDate.of(2020, 7, 22), LocalDate.now());
        Project proj8 = new Project(loc8, 10.0, "Proj8", LocalDate.of(2020, 7, 22), LocalDate.now());
        Project proj9 = new Project(loc9, 10.0, "Proj9", LocalDate.of(2020, 7, 22), LocalDate.now());
        Project proj10 = new Project(loc10, 10.0, "Proj10", LocalDate.now(), LocalDate.now());
        Project proj11 = new Project(loc11, 10.0, "Proj11", LocalDate.now(), LocalDate.now());
        Project proj12 = new Project(loc12, 10.0, "Proj12", LocalDate.now(), LocalDate.now());
        Project proj13 = new Project(loc13, 10.0, "Proj13", LocalDate.of(2020, 7, 22), LocalDate.now());

//        proj7.closeProject();

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

        donationService.save(don1);
        donationService.save(don2);
        donationService.save(don3);
        donationService.save(don4);
        donationService.save(don5);
        donationService.save(don6);
        donationService.save(don7);
        donationService.save(don8);
        donationService.save(don9);
        donationService.save(don10);
        donationService.save(don11);
        donationService.save(don12);
        donationService.save(don13);
        donationService.save(don14);
        donationService.save(don15);
        donationService.save(don16);
        donationService.save(don17);
        donationService.save(don18);
        donationService.save(don19);
        donationService.save(don20);
        donationService.save(don21);
        donationService.save(don22);
        donationService.save(don23);
        donationService.save(don24);
        donationService.save(don25);
        donationService.save(don26);
        donationService.save(don27);
        donationService.save(don28);

        donationService.donate(don1);
        donationService.donate(don2);
        donationService.donate(don3);
        donationService.donate(don4);
        donationService.donate(don5);
        donationService.donate(don6);
        donationService.donate(don7);
        donationService.donate(don8);
        donationService.donate(don9);
        donationService.donate(don10);
        donationService.donate(don11);
        donationService.donate(don12);
        donationService.donate(don13);
        donationService.donate(don14);
        donationService.donate(don15);
        donationService.donate(don16);
        donationService.donate(don17);
        donationService.donate(don18);
        donationService.donate(don19);
        donationService.donate(don20);
        donationService.donate(don21);
        donationService.donate(don22);
        donationService.donate(don23);
        donationService.donate(don24);
        donationService.donate(don25);
        donationService.donate(don26);
        donationService.donate(don27);
        donationService.donate(don28);


    }

}
