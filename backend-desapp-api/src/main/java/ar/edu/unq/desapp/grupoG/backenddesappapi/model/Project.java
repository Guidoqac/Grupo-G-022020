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

    public Project(int idProject, int idLocation, int factor, float minPercentProjectClosure, String projectFantasyName, LocalDate closeProjectDate, LocalDate startProjectDate){
        this.idProject = idProject;
        this.idLocation = idLocation;
        this.factor = factor;
        this.minPercentProjectClosure = minPercentProjectClosure;
        this.projectFantasyName = projectFantasyName;
        this.closeProjectDate = closeProjectDate;
        this.startProjectDate = startProjectDate;
    }

    public int getIdProject(){ return this.idProject; }

    public int getIdLocation(){ return this.idLocation; }

    public int getFactor(){ return this.factor; }

    public float getMinPercentProjectClosure(){ return this.minPercentProjectClosure; }

    public String getProjectFantasyName(){ return this.projectFantasyName; }

    public LocalDate getCloseProjectDate(){ return this.closeProjectDate; }

    public LocalDate getStartProjectDate(){ return this.startProjectDate; }
}
