package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    private Application app;
    
    private User userGuido;
    
    private User userGonza;

    private User userMock;
    
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

    @BeforeEach
    void setUp() {

    	userGuido = new User(0, "Guido", "Mon", "guidito", "Python", "guido@gmail.com");
    	userGonza = new User(1, "Gonza", "veron", "gonzy", "JS", "gonza@gmail.com");
    	
    	userMock = mock(User.class);
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
        
        when(userMock.getPoints()).thenReturn(2000);
        

        
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

    @Test
    void getNextProjectToEndTest(){
        app.setProjects(projects);
        int expectedProjects = 3;
        assertEquals(expectedProjects, app.getNextProjectToEnd().size());
    }

    @Test
    void donateTest(){
    	app.setUsers(users);
        app.setProjects(projects);
        app.donate(0, 2, 100000.0);
        app.donate(1, 2, 10.0);
        int donationsExpected = 2;
        assertEquals(donationsExpected, app.countDonationsByProject(2));
    }
    
    @Test
    void donateTest1(){
    	app.setUsers(users);
        app.setProjects(projects);
        app.donate(0, 2, 1000.0);
        int pointsExpected = 1000;
        assertEquals(pointsExpected, userGuido.getPoints());
    }
    
    @Test
    void donateTest1b(){
    	app.setUsers(users);
        app.setProjects(projects);
        app.donate(0, 3, 1000.0);
        int pointsExpected = 1500;
        assertEquals(pointsExpected, userGuido.getPoints());
    }
    
    @Test
    void donateTest2(){
    	app.setUsers(users);
        app.setProjects(projects);
        app.donate(0, 1, 1000.0);
        int pointsExpected = 2000;
        assertEquals(pointsExpected, userGuido.getPoints());
    }
    
    @Test
    void donateTest2b(){
    	app.setUsers(users);
        app.setProjects(projects);
        app.donate(0, 4, 1000.0);
        int pointsExpected = 2500;
        assertEquals(pointsExpected, userGuido.getPoints());
    }
    
    @Test
    void donateTest3(){
    	app.setUsers(users);
        app.setProjects(projects);
        app.donate(0, 5, 500.0);
        int pointsExpected = 100;
        assertEquals(pointsExpected, userGuido.getPoints());
    }
    
    @Test
    void donateTest3b(){
    	app.setUsers(users);
        app.setProjects(projects);
        app.donate(0, 3, 500.0);
        int pointsExpected = 600;
        assertEquals(pointsExpected, userGuido.getPoints());
    }

}