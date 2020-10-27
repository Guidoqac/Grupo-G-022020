package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String nick;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private int points;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<Reward> rewards;

    public User(){

    }

    public User(int idUser, String name, String surname, String nick, String password, String email){
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.nick = nick;
        this.password = password;
        this.email = email;
        this.rewards = new ArrayList<Reward>();
    }

    public User(String name, String surname, String nick, String password, String email){
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

    public List<Reward> getRewards() {
        return rewards;
    }

}
