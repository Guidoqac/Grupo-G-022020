package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

public class Location {

	private Integer id;
    
    private String name;
    
	private String province;
    
    private Integer population;

    private String connectivityStatus;
	
	public Location(Integer id, String name, String province, Integer population, String status) {
		super();
		this.id = id;
		this.name = name;
		this.province = province;
		this.population = population;
		this.connectivityStatus = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public String getStatus() {
		return connectivityStatus;
	}

	public void setStatus(String status) {
		this.connectivityStatus = status;
	}
    
}
