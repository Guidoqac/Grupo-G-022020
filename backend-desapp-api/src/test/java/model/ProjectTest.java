package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Donation;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Project;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
//CHECKSTYLE:OFF
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProjectTest {

    private Project projectToninas;

    private LocalDate closeProjectDate;

    private LocalDate startProjectDate;

    @BeforeEach
    void setUp() {
        closeProjectDate = LocalDate.now();
        startProjectDate = LocalDate.now();
        
        Location locationToninas= mock(Location.class);
        when(locationToninas.getPopulation()).thenReturn(1000);

        
        projectToninas = new Project(0, locationToninas, 2000, 50.0, "Salvemos a Las Toninas", closeProjectDate, startProjectDate);
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

//    @Test
//    void getIdLocationTest() {
//        int expectedIdLocation = 5;
//        assertEquals(expectedIdLocation, projectToninas.getIdLocation());
//    }

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
    
}