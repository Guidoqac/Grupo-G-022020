package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

import java.util.ArrayList;

public class User {

    private int idUser;
    private String name;
    private String surname;
    private String nick;
    private String password;
    private String email;
    private int points;
    private ArrayList<Reward> rewards;

    public User(int idUser, String name, String surname, String nick, String password, String email){
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.nick = nick;
        this.password = password;
        this.email = email;
        this.rewards = new ArrayList<Reward>();
    }

    public int getIdUser(){ return this.idUser; }

    public String getName(){ return this.name; }

    public String getSurname(){
        return this.surname;
    }

    public String getNick(){
        return this.nick;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword() { return this.password; }

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public Donation donate(int idProject, double amount, String comment) {
        Donation newDonation = new Donation(this.getIdUser(), idProject, amount, comment);
        return newDonation;
	}

	public void addReward(Reward reward){
        this.rewards.add(reward);
    }

    public ArrayList<Reward> getRewards() {
        return rewards;
    }

}
