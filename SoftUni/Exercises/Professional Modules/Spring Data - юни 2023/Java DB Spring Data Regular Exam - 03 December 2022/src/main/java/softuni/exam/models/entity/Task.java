package softuni.exam.models.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {

	
	@Column(nullable = false)
	private BigDecimal price;
	
	@Column(nullable = false)
	private LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(name = "parts_id")
	private Part part;
	
	@ManyToOne
	@JoinColumn(name = "mechanic_id")
	private Mechanic mechanic;
	
	@ManyToOne
	@JoinColumn(name = "cars_id")
	private Car car;
	
	public Task(BigDecimal price, LocalDateTime date) {
		this.price = price;
		this.date = date;
	}

	public Task() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public Mechanic getMechanic() {
		return mechanic;
	}

	public void setMechanic(Mechanic mechanic) {
		this.mechanic = mechanic;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}
