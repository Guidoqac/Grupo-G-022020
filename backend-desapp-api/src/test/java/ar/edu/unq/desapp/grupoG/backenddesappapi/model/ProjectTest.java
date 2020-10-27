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
    
    private Donation donMock4;


    @BeforeEach
    void setUp() {
        closeProjectDate = LocalDate.now();
        startProjectDate = LocalDate.now();

        Location locationToninas= mock(Location.class);
        donations = new ArrayList<Donation>();
        Donation donMock1 = mock(Donation.class);
        Donation donMock2 = mock(Donation.class);
        Donation donMock3 = mock(Donation.class);
        donMock4 = mock(Donation.class);
        donMock5 = mock(Donation.class);
        
        User userMock = mock(User.class);

        donations.add(donMock1);
        donations.add(donMock2);
        donations.add(donMock3);
        donations.add(donMock4);
        
        
        when(userMock.getIdUser()).thenReturn(1);

        when(locationToninas.getId()).thenReturn(5);
        when(locationToninas.getPopulation()).thenReturn(1000);
        when(donMock1.getAmount()).thenReturn(500000.0);
        when(donMock2.getAmount()).thenReturn(500000.0);
        when(donMock3.getAmount()).thenReturn(500000.0);
        when(donMock4.getAmount()).thenReturn(500000.0);
        
        when(donMock4.getDonationDate()).thenReturn(LocalDate.now());
        when(donMock4.getIdUser()).thenReturn(1);

        when(donMock5.getDonationDate()).thenReturn(LocalDate.now());
        when(donMock5.getIdUser()).thenReturn(1);

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
    void isMinimumCollectedFalseTest(){
        assertFalse(projectToninas.isMinimumCollected());
    }

    @Test
    void isMinimumCollectedTrueTest(){
        projectToninas.setDonations(donations);
        assertTrue(projectToninas.isMinimumCollected());
    }

    @Test
    void isOpenTest(){
        assertFalse(projectToninas.isOpen());
    }

    @Test
    void closeProjectTest(){
        projectToninas.closeProject();
        assertTrue(projectToninas.isOpen());
    }

    @Test
    void getDonationsTest(){
        projectToninas.setDonations(donations);
        assertEquals(donations, projectToninas.getDonations());
    }

    @Test
    void actualBudgetCollected(){
        double budgetExpected = 0;
        assertEquals(budgetExpected, projectToninas.actualBudgetCollected());
    }

    @Test
    void addDonation(){
        projectToninas.addDonation(donMock5);
        int donationsAmountExpected = 1;
        assertEquals(donationsAmountExpected, projectToninas.getDonations().size());
    }
    
    @Test
    void alreadyDonateTest(){
        projectToninas.addDonation(donMock4);
        assertTrue(projectToninas.alreadyDonate(1));
    }

    @Test
    void getLastDonationDateTest(){
        assertEquals(startProjectDate, projectToninas.getLastDonationDate());
    }

    @Test
    void setLastDonationDateTest(){
        LocalDate newDate = LocalDate.of(1996, 4, 25);
        projectToninas.setLastDonationDate(newDate);
        assertEquals(newDate, projectToninas.getLastDonationDate());
    }

    @Test
    void addParticipantTest(){
        Donation donMock1 = mock(Donation.class);
        Donation donMock2 = mock(Donation.class);
        Donation donMock3 = mock(Donation.class);

        when(donMock1.getIdUser()).thenReturn(1);
        when(donMock1.getAmount()).thenReturn(500.0);
        when(donMock1.getDonationDate()).thenReturn(LocalDate.of(2020, 01, 23));

        when(donMock2.getIdUser()).thenReturn(2);
        when(donMock2.getAmount()).thenReturn(5000.0);
        when(donMock2.getDonationDate()).thenReturn(LocalDate.of(2020, 10, 24));

        when(donMock3.getIdUser()).thenReturn(1);
        when(donMock3.getAmount()).thenReturn(7000.0);
        when(donMock3.getDonationDate()).thenReturn(LocalDate.of(2020, 10, 25));

        projectToninas.addDonation(donMock1);
        projectToninas.addDonation(donMock2);
        projectToninas.addDonation(donMock3);

        int participantsExpected = 2;

        assertEquals(participantsExpected, projectToninas.getParticipants());
    }

    @Test
    void incrementBudgetTest(){
        Donation donMock1 = mock(Donation.class);
        Donation donMock2 = mock(Donation.class);
        Donation donMock3 = mock(Donation.class);

        when(donMock1.getIdUser()).thenReturn(1);
        when(donMock1.getAmount()).thenReturn(500.0);
        when(donMock1.getDonationDate()).thenReturn(LocalDate.of(2020, 01, 23));

        when(donMock2.getIdUser()).thenReturn(2);
        when(donMock2.getAmount()).thenReturn(5000.0);
        when(donMock2.getDonationDate()).thenReturn(LocalDate.of(2020, 10, 24));

        when(donMock3.getIdUser()).thenReturn(1);
        when(donMock3.getAmount()).thenReturn(7000.0);
        when(donMock3.getDonationDate()).thenReturn(LocalDate.of(2020, 10, 25));

        projectToninas.addDonation(donMock1);
        projectToninas.addDonation(donMock2);
        projectToninas.addDonation(donMock3);

        int budgetExpected = 12500;

        assertEquals(budgetExpected, projectToninas.getBudgetCollected());
    }

    @Test
    void incrementPercentageTest(){
        Donation donMock1 = mock(Donation.class);
        Donation donMock2 = mock(Donation.class);
        Donation donMock3 = mock(Donation.class);

        when(donMock1.getIdUser()).thenReturn(1);
        when(donMock1.getAmount()).thenReturn(500.0);
        when(donMock1.getDonationDate()).thenReturn(LocalDate.of(2020, 01, 23));

        when(donMock2.getIdUser()).thenReturn(2);
        when(donMock2.getAmount()).thenReturn(5000.0);
        when(donMock2.getDonationDate()).thenReturn(LocalDate.of(2020, 10, 24));

        when(donMock3.getIdUser()).thenReturn(1);
        when(donMock3.getAmount()).thenReturn(7000.0);
        when(donMock3.getDonationDate()).thenReturn(LocalDate.of(2020, 10, 25));

        projectToninas.addDonation(donMock1);
        projectToninas.addDonation(donMock2);
        projectToninas.addDonation(donMock3);

        double percentExpected = 0.625;

        assertEquals(percentExpected, projectToninas.getPercentCollected());
    }

}