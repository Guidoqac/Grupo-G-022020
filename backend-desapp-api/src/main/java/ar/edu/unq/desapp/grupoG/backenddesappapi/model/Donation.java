package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

import java.time.LocalDate;

public class Donation {

	private Integer id;
    
    private Integer idUser;
    
    private Integer idProject;
    
    private double amount;
    
    private LocalDate donationDate;

	private String comment;

    public Donation(Integer id, Integer idUser, Integer idProject, Double amount, String comment, LocalDate donationDate){
    	this.comment = comment;
        this.id = id;
        this.idUser = idUser;
        this.idProject = idProject;
        this.amount = amount;
        this.donationDate = donationDate;
    }

    public Donation(Integer idUser, Integer idProject, Double amount, String comment, LocalDate donationDate){
    	this.comment = comment;
        this.idUser = idUser;
        this.idProject = idProject;
        this.amount = amount;
		this.donationDate = donationDate;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdProject() {
		return idProject;
	}

	public void setIdProject(Integer idProject) {
		this.idProject = idProject;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDonationDate() {
		return donationDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
