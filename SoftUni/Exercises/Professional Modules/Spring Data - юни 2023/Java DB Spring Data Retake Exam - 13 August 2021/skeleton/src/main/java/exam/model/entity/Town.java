package exam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity {

	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(nullable = false)
	private int population;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String travelGuide;
	
	public Town(String name, int population, String travelGuide) {
		this.name = name;
		this.population = population;
		this.travelGuide = travelGuide;
	}

	public Town() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getTravelGuide() {
		return travelGuide;
	}

	public void setTravelGuide(String travelGuide) {
		this.travelGuide = travelGuide;
	}



}
