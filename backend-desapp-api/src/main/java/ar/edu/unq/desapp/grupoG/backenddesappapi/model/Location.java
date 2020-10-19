package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

import javax.persistence.*;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
    private String name;

	@Column
	private String province;

	@Column
    private Integer population;

	@Column
    private String connectivityStatus;

	public Location(){

	}

	public Location(String name, String province, Integer population, String status) {
		this.name = name;
		this.province = province;
		this.population = population;
		this.connectivityStatus = status;
	}

	public Location(Integer id, String name, String province, Integer population, String status) {
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

	@Override
	public String toString() {
		return "Location{" +
				"id=" + id +
				", name='" + name + '\'' +
				", province='" + province + '\'' +
				", population=" + population +
				", connectivityStatus='" + connectivityStatus + '\'' +
				'}';
	}


}
