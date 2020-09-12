package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Project;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    private Project project;

    private LocalDate closeProjectDate;

    private LocalDate startProjectDate;

    @BeforeEach
    void setUp() {
        closeProjectDate = LocalDate.now();
        startProjectDate = LocalDate.now();
        project = new Project(0, 5, 50000, 47.3f, "Salvemos a Las Toninas", closeProjectDate, startProjectDate);
    }

    @Test
    void getIdProjectTest() {
        int expectedIdProject = 0;
        assertEquals(expectedIdProject, project.getIdProject());
    }

    @Test
    void getIdLocationTest() {
        int expectedIdLocation = 5;
        assertEquals(expectedIdLocation, project.getIdLocation());
    }

    @Test
    void getFactorTest() {
        int expectedFactor = 50000;
        assertEquals(expectedFactor, project.getFactor());
    }

    @Test
    void getMinPercentProjectClosureTest() {
        float expectedPercent = 47.3f;
        assertEquals(expectedPercent, project.getMinPercentProjectClosure());
    }

    @Test
    void getProjectFantasyNameTest() {
        String expectedFantasyName = "Salvemos a Las Toninas";
        assertEquals(expectedFantasyName, project.getProjectFantasyName());
    }

    @Test
    void getCloseProjectDateTest() {
        LocalDate expectedCloseDate = closeProjectDate;
        assertEquals(expectedCloseDate, project.getCloseProjectDate());
    }

    @Test
    void getStartProjectDateTest() {
        LocalDate expectedStartDate = startProjectDate;
        assertEquals(expectedStartDate, project.getStartProjectDate());
    }
    
}