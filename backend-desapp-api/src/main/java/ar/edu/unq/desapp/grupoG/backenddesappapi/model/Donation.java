package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

public class Donation {

	private Integer id;
    
    private Integer idUser;
    
    private Integer idLocation;
    
    private Double amount; //cantidad

    public Donation(Integer id, Integer idUser, Integer idLocation, Double amount){
        this.id = id;
        this.idUser = idUser;
        this.idLocation = idLocation;
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

	public Integer getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(Integer idLocation) {
		this.idLocation = idLocation;
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
