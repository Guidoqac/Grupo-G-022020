package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

public class Donation {

	private Integer id;
    
    private Integer idUser;
    
    private Integer idLocation;
    
    private Float quantity; //cantidad

    public Donation(Integer id, Integer idUser, Integer idLocation, Float quantity){
        this.id = id;
        this.idUser = idUser;
        this.idLocation = idLocation;
        this.quantity = quantity;
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

	public Float getQuantity() {
		return quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

}
