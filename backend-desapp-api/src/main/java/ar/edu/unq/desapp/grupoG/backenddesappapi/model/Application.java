package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    private ArrayList<Reward> rewards = new ArrayList<Reward>();

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
    public void donate(int idUser, int idProject, double amount, String comment){
        
        User userFinded = findUser(idUser);   
        Project projectFinded = findProject(idProject);
        
       //Usuario crea la donacion. El metodo nos devuelve una donacion
        Donation donationByUser = userFinded.donate(idProject, amount, comment);

        // Agregamos la donacion de dicho usuario al projecto encontrado.
        projectFinded.addDonation(donationByUser);
        
        // SISTEMA DE PUNTOS
        int pointsUser = 0;
        
        // Si colabora en 1 proyecto con más de 1000 pesos, obtendrá la misma cantidad de puntos que pesos invertidos.
        if (amount >= 1000.0 && (findProject(idProject).getLocation().getPopulation() >= 2000) && findProject(idProject).alreadyDonate(idUser) ) {
        	pointsUser = (int) (pointsUser + amount) + 500;
        } else if (amount >= 1000.0 && (findProject(idProject).getLocation().getPopulation() >= 2000)) {
        	pointsUser = (int) (pointsUser + amount);
        }
        
        //Si colabora en 1 proyecto de una localidad de menos de 2000 habitantes, la cantidad de puntos será el doble de los pesos invertidos.
        if ((findProject(idProject).getLocation().getPopulation() < 2000) && findProject(idProject).alreadyDonate(idUser)) {
        	pointsUser = (int) ((pointsUser + amount) * 2 + 500);
        	
        } else if (findProject(idProject).getLocation().getPopulation() < 2000) {
        	pointsUser = (int) ((pointsUser + amount) * 2);
        }

        if ((findProject(idProject).getLocation().getPopulation() >= 2000) && amount < 1000.0 && findProject(idProject).alreadyDonate(idUser)) {
        	pointsUser = 100 + 500;
        	
        } else if ((findProject(idProject).getLocation().getPopulation() >= 2000) && amount < 1000.0) {
        	pointsUser = 100;
        }
        
        userFinded.setPoints(pointsUser);
                        
        // SISTEMA DE PUNTOS        
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

    public ArrayList<Reward> getRewards(){
        return this.rewards;
    }

    public void setProjects(ArrayList<Project> projects){
        this.projects = projects;
    }
    
    public void setUsers(ArrayList<User> users){
        this.users = users;
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
    
    //Precond. : Existe el usuario en la aplicacion.
    public User findUser(int idUser) {
        User userFinded = null;
        for (User i : this.users) {
            if (i.getIdUser() == idUser) {
                userFinded = i;
            }
        }
        return userFinded;
    }

    public void addReward(Reward reward){
        this.rewards.add(reward);
    }

    public void exchange(int idUser, Reward reward){
        User userFinded = findUser(idUser);
        if(canExchange(userFinded.getPoints(), reward.getPoints())){
            userFinded.addReward(reward);
            this.removePoints(userFinded, reward.getPoints());
        }
    }

    public boolean canExchange(int userPoints, int rewardPoints){
        return userPoints >= rewardPoints;
    }

    public void removePoints(User user, int amount){
        user.setPoints(user.getPoints() - amount);
    }

}
