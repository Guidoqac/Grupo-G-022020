package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

import java.time.LocalDate;

public class Project {

    private int idProject;
    private Location location;
    private int factor;
    private Double minPercentProjectClosure;
    private String projectFantasyName;
    private LocalDate closeProjectDate;
    private LocalDate startProjectDate;
    private boolean isClosed;

    public Project(int idProject, Location location, int factor, Double minPercentProjectClosure, String projectFantasyName, LocalDate closeProjectDate, LocalDate startProjectDate) {
        this.idProject = idProject;
        this.location = location;
        this.factor = factor;
        this.minPercentProjectClosure = minPercentProjectClosure;
        this.projectFantasyName = projectFantasyName;
        this.closeProjectDate = closeProjectDate;
        this.startProjectDate = startProjectDate;
    }

    public Project(int idProject, Location location, Double minPercentProjectClosure, String projectFantasyName, LocalDate closeProjectDate, LocalDate startProjectDate) {
        this.idProject = idProject;
        this.location = location;
        this.factor = 1000;
        this.minPercentProjectClosure = minPercentProjectClosure;
        this.projectFantasyName = projectFantasyName;
        this.closeProjectDate = closeProjectDate;
        this.startProjectDate = startProjectDate;
    }

    public int getIdProject() {
        return this.idProject;
    }

    public Location getLocation() {
        return this.location;
    }

    public int getFactor() {
        return this.factor;
    }

    public Double getMinPercentProjectClosure() {
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


    public double calculateBudget() {
        int population = this.location.getPopulation(); //consulta a la db que trae la cantidad de poblacion de locate a travez del idLocation
        int budget = population * this.factor;
        return budget;
    }
    

    public double calculateMinPercentage(){
        return this.calculateBudget() * this.minPercentProjectClosure / 100;
    }
    
    
//    public boolean minimumCollected(){
//		int collected = 0; esta variable obtiene el valor a travs de un pedido a la bd, donde recorre todas las donaciones con mi ID projecto
//        //Obtener desde la db a travez de idProject todas las donaciones y sacar la sumatoria de todas sus cantidades de donacion
//        return collected >= this.calculateMinPercentage();
//    }
    
}
