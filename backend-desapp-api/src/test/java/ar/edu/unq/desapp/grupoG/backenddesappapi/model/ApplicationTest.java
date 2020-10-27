package ar.edu.unq.desapp.grupoG.backenddesappapi.model;
/*
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
*/
class ApplicationTest {
/*
    private Application app;
    
    private User userGuido;
    
    private User userGonza;
    
    private ArrayList<User> users = new ArrayList<User>();

    private Location locationMock;

    private Location locationMock2;
    
    private ArrayList<Project> projects;

    private ArrayList<Donation> donations;

    private Project projMock1;

    private Project projMock2;

    private Project projMock3;
    
    private Project projMock4;
    
    private Project projMock5;

    private LocalDate projMock1CloseDate;

    private LocalDate projMock2CloseDate;

    private LocalDate projMock3CloseDate;

    private LocalDate projMock4CloseDate;
    
    private LocalDate projMock5CloseDate;
    
    private Donation donMock1;

    private Donation donMock2;

    private String comment;

    private Reward rewardMock1;

    private Reward rewardMock2;

    @BeforeEach
    void setUp() {

        comment = "codacy pls";
    	userGuido = new User(0, "Guido", "Mon", "guidito", "Python", "guido@gmail.com");
    	userGonza = new User(1, "Gonza", "veron", "gonzy", "JS", "gonza@gmail.com");
        userGuido.setPoints(5000);
        userGonza.setPoints(200);

        projects = new ArrayList<Project>();
        donations = new ArrayList<Donation>();
        projMock1 = mock(Project.class);
        projMock2 = mock(Project.class);
        projMock3 = mock(Project.class);
        projMock4 = mock(Project.class);
        projMock5 = mock(Project.class);
        donMock1 = mock(Donation.class);
        donMock2 = mock(Donation.class);
        projMock1CloseDate = LocalDate.of(2020, 8, 27);
        projMock2CloseDate = LocalDate.of(2020, 8, 10);
        projMock3CloseDate = LocalDate.of(2020, 9, 23);
        projMock4CloseDate = LocalDate.of(2020, 9, 23);
        projMock5CloseDate = LocalDate.of(2020, 9, 23);
        
        users.add(userGuido);
        users.add(userGonza);

        projects.add(projMock1);
        projects.add(projMock2);
        projects.add(projMock3);
        projects.add(projMock4);
        projects.add(projMock5);
        
        donations.add(donMock1);
        donations.add(donMock2);

        when(projMock1.isOpen()).thenReturn(true);
        when(projMock2.isOpen()).thenReturn(true);
        when(projMock3.isOpen()).thenReturn(false);
        
        when(projMock1.getIdProject()).thenReturn(1);
        when(projMock2.getIdProject()).thenReturn(2);
        when(projMock3.getIdProject()).thenReturn(3);
        when(projMock4.getIdProject()).thenReturn(4);
        when(projMock5.getIdProject()).thenReturn(5);
        
        when(projMock2.getDonations()).thenReturn(donations);
        
        when(donMock1.getAmount()).thenReturn(100000.0);
        when(donMock2.getAmount()).thenReturn(10.0);
        
        when(projMock1.getCloseProjectDate()).thenReturn(projMock1CloseDate);
        when(projMock2.getCloseProjectDate()).thenReturn(projMock2CloseDate);
        when(projMock3.getCloseProjectDate()).thenReturn(projMock3CloseDate);        
        when(projMock4.getCloseProjectDate()).thenReturn(projMock4CloseDate);        
        when(projMock5.getCloseProjectDate()).thenReturn(projMock5CloseDate);


        locationMock = mock(Location.class);
        locationMock2 = mock(Location.class);
        
        when(locationMock.getPopulation()).thenReturn(2500);
        when(locationMock2.getPopulation()).thenReturn(1000);
        
        when(projMock1.getLocation()).thenReturn(locationMock2);
        when(projMock1.alreadyDonate(0)).thenReturn(false);
        
        when(projMock2.getLocation()).thenReturn(locationMock);
        when(projMock2.alreadyDonate(0)).thenReturn(false);
        
        when(projMock3.getLocation()).thenReturn(locationMock);
        when(projMock3.alreadyDonate(0)).thenReturn(true);
        
        when(projMock4.getLocation()).thenReturn(locationMock2);
        when(projMock4.alreadyDonate(0)).thenReturn(true);
        
        when(projMock5.getLocation()).thenReturn(locationMock);
        when(projMock5.alreadyDonate(0)).thenReturn(false);

        rewardMock1 = mock(Reward.class);
        rewardMock2 = mock(Reward.class);
        when(rewardMock1.getPoints()).thenReturn(500);
        when(rewardMock2.getPoints()).thenReturn(2500);

        app = new Application();
    }

    @Test
    void countUsersTest(){
        int expectedUsers = 0;
        assertEquals(expectedUsers, app.countUsers());
    }

    @Test
    void countProjectsTest(){
        int expectedProjects = 0;
        assertEquals(expectedProjects, app.countProjects());
    }

    @Test
    void registerTest() {
        int expectedUsersInApp = 1;
        app.register("Gonza", " Veron", "algo@gmail.com", "1234", "Spore");
        assertEquals(expectedUsersInApp, app.countUsers());
    }

    @Test
    void addProjectTest() {
        int expectedProjectsInApp = 1;
        app.addProject(locationMock, 1000, 50.0, "Salvemos las toninas", LocalDate.now());
        assertEquals(expectedProjectsInApp, app.countProjects());
    }

    @Test
    void getOpenProjectsTest() {
        app.setProjects(projects);
        int expectedProjects = 2;
        assertEquals(expectedProjects, app.getOpenProjects().size());
    }

//    @Test
//    void getNextProjectToEndTest(){
//        app.setProjects(projects);
//        int expectedProjects = 3;
//        assertEquals(expectedProjects, app.getNextProjectToEnd().size());
//    }

    @Test
    void donateTest(){
    	app.setUsers(users);
        app.setProjects(projects);
        app.donate(0, 2, 100000.0, comment);
        app.donate(1, 2, 10.0, comment);
        int donationsExpected = 2;
        assertEquals(donationsExpected, app.countDonationsByProject(2));
    }
    
    @Test
    void donateTest1(){
    	app.setUsers(users);
        app.setProjects(projects);
        app.donate(0, 2, 1000.0, comment);
        int pointsExpected = 1000;
        assertEquals(pointsExpected, userGuido.getPoints());
    }
    
    @Test
    void donateTest1b(){
    	app.setUsers(users);
        app.setProjects(projects);
        app.donate(0, 3, 1000.0, comment);
        int pointsExpected = 1500;
        assertEquals(pointsExpected, userGuido.getPoints());
    }
    
    @Test
    void donateTest2(){
    	app.setUsers(users);
        app.setProjects(projects);
        app.donate(0, 1, 1000.0, comment);
        int pointsExpected = 2000;
        assertEquals(pointsExpected, userGuido.getPoints());
    }
    
    @Test
    void donateTest2b(){
    	app.setUsers(users);
        app.setProjects(projects);
        app.donate(0, 4, 1000.0, comment);
        int pointsExpected = 2500;
        assertEquals(pointsExpected, userGuido.getPoints());
    }
    
    @Test
    void donateTest3(){
    	app.setUsers(users);
        app.setProjects(projects);
        app.donate(0, 5, 500.0, comment);
        int pointsExpected = 100;
        assertEquals(pointsExpected, userGuido.getPoints());
    }
    
    @Test
    void donateTest3b(){
    	app.setUsers(users);
        app.setProjects(projects);
        app.donate(0, 3, 500.0, comment);
        int pointsExpected = 600;
        assertEquals(pointsExpected, userGuido.getPoints());
    }

    @Test
    void addRewardTest(){
        app.addReward(rewardMock1);
        app.addReward(rewardMock2);
        int amountExpected = 2;
        assertEquals(amountExpected, app.getRewards().size());
    }

    @Test
    void canExchangeTrueTest(){
        assertTrue(app.canExchange(userGuido.getPoints(), rewardMock1.getPoints()));
    }

    @Test
    void canExchangeFalseTest(){
        assertFalse(app.canExchange(userGonza.getPoints(), rewardMock2.getPoints()));
    }

    @Test
    void removePointsTest(){
        app.removePoints(userGuido, rewardMock1.getPoints());
        int pointsExpected = 4500;
        assertEquals(pointsExpected, userGuido.getPoints());
    }

    @Test
    void exchangeTest(){
        app.setUsers(users);
        app.exchange(0, rewardMock1);
        int pointsExpected = 4500;
        assertEquals(pointsExpected, userGuido.getPoints());
    }

    @Test
    void top10DonationsTest(){

        Project proj1 = mock(Project.class);
        Project proj2 = mock(Project.class);
        Project proj3 = mock(Project.class);

        ArrayList<Project> projs = new ArrayList<Project>();
        projs.add(proj1);
        projs.add(proj2);
        projs.add(proj3);

        Donation don1 = mock(Donation.class);
        Donation don2 = mock(Donation.class);
        Donation don3 = mock(Donation.class);
        Donation don4 = mock(Donation.class);
        Donation don5 = mock(Donation.class);
        Donation don6 = mock(Donation.class);
        Donation don7 = mock(Donation.class);
        Donation don8 = mock(Donation.class);

        ArrayList<Donation> donsP1 = new ArrayList<Donation>();
        donsP1.add(don1);
        donsP1.add(don2);
        donsP1.add(don3);

        ArrayList<Donation> donsP2 = new ArrayList<Donation>();
        donsP2.add(don4);
        donsP2.add(don5);
        donsP2.add(don6);

        ArrayList<Donation> donsP3 = new ArrayList<Donation>();
        donsP3.add(don7);
        donsP3.add(don8);

        proj1.setDonations(donsP1);
        proj2.setDonations(donsP2);
        proj3.setDonations(donsP3);

        when(proj1.getDonations()).thenReturn(donsP1);
        when(proj2.getDonations()).thenReturn(donsP2);
        when(proj3.getDonations()).thenReturn(donsP3);

        when(don1.getAmount()).thenReturn(10000.0);
        when(don2.getAmount()).thenReturn(15000.0);
        when(don3.getAmount()).thenReturn(5000.0);
        when(don4.getAmount()).thenReturn(3000.0);
        when(don5.getAmount()).thenReturn(2000.0);
        when(don6.getAmount()).thenReturn(30000.0);
        when(don7.getAmount()).thenReturn(8000.0);
        when(don8.getAmount()).thenReturn(500.0);

        app.setProjects(projs);

        List<Donation> donations = app.top10Donations();

        List<Double> numbersExpected = new ArrayList<>();
        numbersExpected.add(30000.0);
        numbersExpected.add(15000.0);
        numbersExpected.add(10000.0);
        numbersExpected.add(8000.0);
        numbersExpected.add(5000.0);
        numbersExpected.add(3000.0);
        numbersExpected.add(2000.0);
        numbersExpected.add(500.0);

        List<Double> actualNumbers = donations.stream().map(d -> d.getAmount()).collect(Collectors.toList());

        assertIterableEquals(numbersExpected, actualNumbers);
    }

    @Test
    void top10ProjectsWithoutRecentDonationsTest() {

        ArrayList<Project> projs = new ArrayList<Project>();

        Project proj1 = mock(Project.class);
        Project proj2 = mock(Project.class);
        Project proj3 = mock(Project.class);
        Project proj4 = mock(Project.class);
        Project proj5 = mock(Project.class);
        Project proj6 = mock(Project.class);
        Project proj7 = mock(Project.class);
        Project proj8 = mock(Project.class);

        Location loc1 = mock(Location.class);
        Location loc2 = mock(Location.class);
        Location loc3 = mock(Location.class);
        Location loc4 = mock(Location.class);
        Location loc5 = mock(Location.class);
        Location loc6 = mock(Location.class);
        Location loc7 = mock(Location.class);
        Location loc8 = mock(Location.class);

        projs.add(proj1);
        projs.add(proj2);
        projs.add(proj3);
        projs.add(proj4);
        projs.add(proj5);
        projs.add(proj6);
        projs.add(proj7);
        projs.add(proj8);

        when(proj1.getLastDonationDate()).thenReturn(LocalDate.of(2005, 7, 19));
        when(proj2.getLastDonationDate()).thenReturn(LocalDate.of(2019, 2, 27));
        when(proj3.getLastDonationDate()).thenReturn(LocalDate.of(2010, 1, 15));
        when(proj4.getLastDonationDate()).thenReturn(LocalDate.of(1996, 4, 25));
        when(proj5.getLastDonationDate()).thenReturn(LocalDate.of(2007, 11, 30));
        when(proj6.getLastDonationDate()).thenReturn(LocalDate.of(2007, 9, 10));
        when(proj7.getLastDonationDate()).thenReturn(LocalDate.of(2001, 4, 13));
        when(proj8.getLastDonationDate()).thenReturn(LocalDate.of(2005, 3, 12));

        when(proj1.getLocation()).thenReturn(loc1);
        when(proj2.getLocation()).thenReturn(loc2);
        when(proj3.getLocation()).thenReturn(loc3);
        when(proj4.getLocation()).thenReturn(loc4);
        when(proj5.getLocation()).thenReturn(loc5);
        when(proj6.getLocation()).thenReturn(loc6);
        when(proj7.getLocation()).thenReturn(loc7);
        when(proj8.getLocation()).thenReturn(loc8);

        when(loc1.getName()).thenReturn("La Matanza");
        when(loc2.getName()).thenReturn("Lanus");
        when(loc3.getName()).thenReturn("Avellaneda");
        when(loc4.getName()).thenReturn("Florencio Varela");
        when(loc5.getName()).thenReturn("Ezeiza");
        when(loc6.getName()).thenReturn("Dolores");
        when(loc7.getName()).thenReturn("Berazategui");
        when(loc8.getName()).thenReturn("Villa Gesell");

        app.setProjects(projs);

        List<Location> projectos = app.top10ProjectsWithoutRecentDonations();

        List<String> namesExpected = new ArrayList<String>();
        namesExpected.add("Florencio Varela");
        namesExpected.add("Berazategui");
        namesExpected.add("Villa Gesell");
        namesExpected.add("La Matanza");
        namesExpected.add("Dolores");
        namesExpected.add("Ezeiza");
        namesExpected.add("Avellaneda");
        namesExpected.add("Lanus");

        List<String> actual = projectos.stream().map(l -> l.getName()).collect(Collectors.toList());

        assertIterableEquals(namesExpected, actual);
    }
*/
}