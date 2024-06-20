package epicode.esercizio._0._6.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Topping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private int calories;
	private double price;

	public Topping() {

	}

	public Topping(String name, int calories, double price) {
		this.name = name;
		this.calories = calories;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Topping{" +
				"id=" + id +
				", name='" + name + '\'' +
				", calories=" + calories +
				", price=" + price +
				'}';
	}
}
