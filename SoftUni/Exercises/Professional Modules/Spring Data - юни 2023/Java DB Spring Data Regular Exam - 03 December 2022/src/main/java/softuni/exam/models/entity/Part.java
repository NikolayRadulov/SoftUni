package softuni.exam.models.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "parts")
public class Part extends BaseEntity {

	@Column(unique = true, nullable = false, name = "part_name")
	private String partName;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private int quantity;
	
	@OneToMany(mappedBy = "part")
	private Set<Task> tasks;
	
	public Part(String partName, double price, int quantity) {
		this.partName = partName;
		this.price = price;
		this.quantity = quantity;
	}

	public Part() {
		// TODO Auto-generated constructor stub
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

}
