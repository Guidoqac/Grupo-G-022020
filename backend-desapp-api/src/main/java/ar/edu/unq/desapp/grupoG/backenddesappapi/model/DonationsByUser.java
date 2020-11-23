package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "donateByUser")
public class DonationsByUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDonateByUser;
    
	@Column
	private Integer idUser;

	@Column
	private String nameProject;
	
	@Column
	private double amount;
	
	@Column
	private LocalDate donationDate;
	
    @Column
    private int points;
    
    public DonationsByUser() {
    }
    
    public DonationsByUser(int idDonateByUser, int idUser, String nameProject, double amount, LocalDate donatinDate, int points) {
    	this.idDonateByUser =idDonateByUser;
    	this.idUser = idUser;
    	this.nameProject = nameProject;
    	this.amount = amount;
    	this.donationDate = donatinDate;
    	this.points = points;
    }
    
    public DonationsByUser(int idUser, String nameProject, double amount, LocalDate donatinDate, int points) {
    	this.idUser = idUser;
    	this.nameProject = nameProject;
    	this.amount = amount;
    	this.donationDate = donatinDate;
    	this.points = points;
    }
    
	public int getIdDonateByUser() {
		return idDonateByUser;
	}

	public void setIdDonateByUser(int idDonateByUser) {
		this.idDonateByUser = idDonateByUser;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getNameProject() {
		return nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(LocalDate donationDate) {
		this.donationDate = donationDate;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
    
	
}
