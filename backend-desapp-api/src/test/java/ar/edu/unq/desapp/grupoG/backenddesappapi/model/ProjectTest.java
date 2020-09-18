package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProjectTest {

    private Project projectToninas;

    private Project projectDefaultFactor;

    private LocalDate closeProjectDate;

    private LocalDate startProjectDate;

    private ArrayList<Donation> donations;

    private Donation donMock5;

    @BeforeEach
    void setUp() {
        closeProjectDate = LocalDate.now();
        startProjectDate = LocalDate.now();

        Location locationToninas= mock(Location.class);
        donations = new ArrayList<Donation>();
        Donation donMock1 = mock(Donation.class);
        Donation donMock2 = mock(Donation.class);
        Donation donMock3 = mock(Donation.class);
        Donation donMock4 = mock(Donation.class);
        donMock5 = mock(Donation.class);

        donations.add(donMock1);
        donations.add(donMock2);
        donations.add(donMock3);
        donations.add(donMock4);

        when(locationToninas.getId()).thenReturn(5);
        when(locationToninas.getPopulation()).thenReturn(1000);
        when(donMock1.getAmount()).thenReturn(500000.0);
        when(donMock2.getAmount()).thenReturn(500000.0);
        when(donMock3.getAmount()).thenReturn(500000.0);
        when(donMock4.getAmount()).thenReturn(500000.0);

        projectToninas = new Project(0, locationToninas, 2000, 50.0, "Salvemos a Las Toninas", closeProjectDate, startProjectDate);
        projectDefaultFactor = new Project(1, locationToninas, 50.0, "Salvemos a Las Toninas 2", closeProjectDate, startProjectDate);
    }

    @Test
    void defaultFactorTest(){
        int factorExpected = 1000;
        assertEquals(factorExpected, projectDefaultFactor.getFactor());
    }

	@Test
	void testBudgetProject() {
        assertEquals(2000000, projectToninas.calculateBudget());
	}
	
	@Test
	void testCalculateMinPercentage() {
        assertEquals(1000000, projectToninas.calculateMinPercentage());
	}

    @Test
    void getIdProjectTest() {
        int expectedIdProject = 0;
        assertEquals(expectedIdProject, projectToninas.getIdProject());
    }

    @Test
    void getLocationTest() {
       int expectedIdLocation = 5;
       assertEquals(expectedIdLocation, projectToninas.getLocation().getId());
    }

    @Test
    void getFactorTest() {
        int expectedFactor = 2000;
        assertEquals(expectedFactor, projectToninas.getFactor());
    }

    @Test
    void getMinPercentProjectClosureTest() {
    	Double expectedPercent = 50.0;
        assertEquals(expectedPercent, projectToninas.getMinPercentProjectClosure());
    }

    @Test
    void getProjectFantasyNameTest() {
        String expectedFantasyName = "Salvemos a Las Toninas";
        assertEquals(expectedFantasyName, projectToninas.getProjectFantasyName());
    }

    @Test
    void getCloseProjectDateTest() {
        LocalDate expectedCloseDate = closeProjectDate;
        assertEquals(expectedCloseDate, projectToninas.getCloseProjectDate());
    }

    @Test
    void getStartProjectDateTest() {
        LocalDate expectedStartDate = startProjectDate;
        assertEquals(expectedStartDate, projectToninas.getStartProjectDate());
    }

    @Test
    void IsMinimumCollectedFalseTest(){
        assertFalse(projectToninas.isMinimumCollected());
    }

    @Test
    void IsMinimumCollectedTrueTest(){
        projectToninas.SetDonations(donations);
        assertTrue(projectToninas.isMinimumCollected());
    }

    @Test
    void IsOpenTest(){
        assertFalse(projectToninas.isOpen());
    }

    @Test
    void CloseProjectTest(){
        projectToninas.CloseProject();
        assertTrue(projectToninas.isOpen());
    }

    @Test
    void GetDonationsTest(){
        projectToninas.SetDonations(donations);
        assertEquals(donations, projectToninas.getDonations());
    }

    @Test
    void ActualBudgetCollected(){
        double budgetExpected = 0;
        assertEquals(budgetExpected, projectToninas.actualBudgetCollected());
    }

    @Test
    void addDonation(){
        projectToninas.addDonation(donMock5);
        int donationsAmountExpected = 1;
        assertEquals(donationsAmountExpected, projectToninas.getDonations().size());
    }
}