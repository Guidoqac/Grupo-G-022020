package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

public class Donation {

	private Integer id;
    
    private Integer idUser;
    
    private Integer idProject;
    
    private Double amount; //cantidad

    public Donation(Integer id, Integer idUser, Integer idProject, Double amount){
        this.id = id;
        this.idUser = idUser;
        this.idProject = idProject;
        this.amount = amount;
    }
    
    public Donation(Integer idUser, Integer idProject, Double amount){
        this.idUser = idUser;
        this.idProject = idProject;
        this.amount = amount;
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/*
	DonationService
	public void donate(){
		Donation donation = new Donation();
		calculo los puntos
		lo seteo en la donacion
		donation.save()
	}*/

}
