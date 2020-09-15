package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

import java.time.LocalDate;

public class Project {

    private int idProject;
    private int idLocation;
    private int factor;
    private float minPercentProjectClosure;
    private String projectFantasyName;
    private LocalDate closeProjectDate;
    private LocalDate startProjectDate;
    private boolean isClosed;

    public Project(int idProject, int idLocation, int factor, float minPercentProjectClosure, String projectFantasyName, LocalDate closeProjectDate, LocalDate startProjectDate) {
        this.idProject = idProject;
        this.idLocation = idLocation;
        this.factor = factor;
        this.minPercentProjectClosure = minPercentProjectClosure;
        this.projectFantasyName = projectFantasyName;
        this.closeProjectDate = closeProjectDate;
        this.startProjectDate = startProjectDate;
    }

    public Project(int idProject, int idLocation, float minPercentProjectClosure, String projectFantasyName, LocalDate closeProjectDate, LocalDate startProjectDate) {
        this.idProject = idProject;
        this.idLocation = idLocation;
        this.factor = 1000;
        this.minPercentProjectClosure = minPercentProjectClosure;
        this.projectFantasyName = projectFantasyName;
        this.closeProjectDate = closeProjectDate;
        this.startProjectDate = startProjectDate;
    }

    public int getIdProject() {
        return this.idProject;
    }

    public int getIdLocation() {
        return this.idLocation;
    }

    public int getFactor() {
        return this.factor;
    }

    public float getMinPercentProjectClosure() {
        return this.minPercentProjectClosure;
    }

    public String getProjectFantasyName() {
        return this.projectFantasyName;
    }

    public LocalDate getCloseProjectDate() {
        return this.closeProjectDate;
    }

    public LocalDate getStartProjectDate() {
        return this.startProjectDate;
    }

    /*
    public double calculateBudget() {
        int population = 0; //consulta a la db que trae la cantidad de poblacion de locate a travez del idLocation
        int budget = population * this.factor;
        return budget;
    }

    public double calculateMinPercentage(){
        return this.calculateBudget() * this.minPercentProjectClosure;
    }

    public boolean minimumCollected(){
        int collected = 0; //Obtener desde la db a travez de idProject todas las donaciones y sacar la sumatoria de todas sus cantidades de donacion
        return collected >= this.calculateMinPercentage();
    }
    */
}
