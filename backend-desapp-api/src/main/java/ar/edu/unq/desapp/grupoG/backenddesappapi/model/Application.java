package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    private ArrayList<User> users = new ArrayList<User>();

    private ArrayList<Project> projects = new ArrayList<Project>();

    private int nextIdUser = 0;

    private int nextIdProject = 0;

    private int nextIdDonation = 0;

    public void register(String name, String surname, String email, String password, String nick){
        User newUser = new User(this.nextIdUser, name, surname, nick, password, email);
        this.nextIdUser++;
        users.add(newUser);
    }

    public void addProject(Location location, int factor, Double minPercentProjectClosure, String projectFantasyName, LocalDate startProjectDate){
        Project newProject = new Project(this.nextIdProject, location, factor, minPercentProjectClosure, projectFantasyName, null, startProjectDate);
        this.nextIdProject++;
        projects.add(newProject);
    }

    public List<Project> getOpenProjects(){
        return projects.stream().filter(p -> p.isOpen()).collect(Collectors.toList());
    }

    //Precond. : Existe el proyecto en la aplicacion.
    public void donate(int idUser, int idProject, double amount){
        Donation newDonation = new Donation(this.nextIdDonation, idUser, idProject, amount);
        Project projectFinded = findProject(idProject);
        projectFinded.addDonation(newDonation);
    }

    public int countDonationsByProject(int idProject) {
        return this.findProject(idProject).getDonations().size();
    }

    public int countUsers(){
        return this.users.size();
    }

    public int countProjects(){
        return this.projects.size();
    }

    public void setProjects(ArrayList<Project> projects){
        this.projects = projects;
    }

    public List<Project> getNextProjectToEnd() {
        return projects.stream().filter(p -> {
            LocalDate actualDate = LocalDate.now();
            return p.getCloseProjectDate().getMonth() == actualDate.getMonth() && p.getCloseProjectDate().getYear() == actualDate.getYear();
        }).collect(Collectors.toList());
    }

    //Precond. : Existe el proyecto en la aplicacion.
    public Project findProject(int idProject){
        Project projectFinded = null;
        for (Project i : this.projects) {
            if(i.getIdProject() == idProject){
                projectFinded = i;
            }
        }
        return projectFinded;
    }
}
