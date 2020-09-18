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

    private Location locationMock;

    private ArrayList<Project> projects;

    private ArrayList<Donation> donations;

    private Project projMock1;

    private Project projMock2;

    private Project projMock3;

    private LocalDate projMock1CloseDate;

    private LocalDate projMock2CloseDate;

    private LocalDate projMock3CloseDate;

    private Donation donMock1;

    private Donation donMock2;

    @BeforeEach
    void setUp() {
        projects = new ArrayList<Project>();
        donations = new ArrayList<Donation>();
        projMock1 = mock(Project.class);
        projMock2 = mock(Project.class);
        projMock3 = mock(Project.class);
        donMock1 = mock(Donation.class);
        donMock2 = mock(Donation.class);
        projMock1CloseDate = LocalDate.of(2020, 8, 27);
        projMock2CloseDate = LocalDate.of(2020, 8, 10);
        projMock3CloseDate = LocalDate.of(2020, 9, 23);

        projects.add(projMock1);
        projects.add(projMock2);
        projects.add(projMock3);

        donations.add(donMock1);
        donations.add(donMock2);

        when(projMock1.isOpen()).thenReturn(true);
        when(projMock2.isOpen()).thenReturn(true);
        when(projMock3.isOpen()).thenReturn(false);
        when(projMock1.getIdProject()).thenReturn(1);
        when(projMock2.getIdProject()).thenReturn(2);
        when(projMock3.getIdProject()).thenReturn(3);
        when(projMock2.getDonations()).thenReturn(donations);
        when(donMock1.getAmount()).thenReturn(100000.0);
        when(donMock2.getAmount()).thenReturn(10.0);
        when(projMock1.getCloseProjectDate()).thenReturn(projMock1CloseDate);
        when(projMock2.getCloseProjectDate()).thenReturn(projMock2CloseDate);
        when(projMock3.getCloseProjectDate()).thenReturn(projMock3CloseDate);

        locationMock = mock(Location.class);
        app = new Application();
    }

    @Test
    void CountUsersTest(){
        int expectedUsers = 0;
        assertEquals(expectedUsers, app.countUsers());
    }

    @Test
    void CountProjectsTest(){
        int expectedProjects = 0;
        assertEquals(expectedProjects, app.countProjects());
    }

    @Test
    void RegisterTest() {
        int expectedUsersInApp = 1;
        app.register("Gonza", " Veron", "algo@gmail.com", "1234", "Spore");
        assertEquals(expectedUsersInApp, app.countUsers());
    }

    @Test
    void AddProjectTest() {
        int expectedProjectsInApp = 1;
        app.addProject(locationMock, 1000, 50.0, "Salvemos las toninas", LocalDate.now());
        assertEquals(expectedProjectsInApp, app.countProjects());
    }

    @Test
    void GetOpenProjectsTest() {
        app.SetProjects(projects);
        int expectedProjects = 2;
        assertEquals(expectedProjects, app.getOpenProjects().size());
    }

    @Test
    void GetNextProjectToEndTest(){
        app.SetProjects(projects);
        int expectedProjects = 1;
        assertEquals(expectedProjects, app.getNextProjectToEnd().size());
    }

    @Test
    void DonateTest(){
        app.SetProjects(projects);
        app.Donate(0, 2, 100000.0);
        app.Donate(1, 2, 10.0);
        int donationsExpected = 2;
        assertEquals(donationsExpected, app.countDonationsByProject(2));
    }

}