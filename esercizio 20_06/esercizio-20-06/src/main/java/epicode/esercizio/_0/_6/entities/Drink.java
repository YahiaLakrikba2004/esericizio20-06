package epicode.esercizio._0._6.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Drink extends Item {
	@Id
	private String name;

	public Drink(int calories, double price, String name) {
		super(calories, price);
		this.name = name;
	}

	@Override
	public String toString() {
		return "Drink{" +
				"name='" + name + '\'' +
				", calories=" + getCalories() +
				", price=" + getPrice() +
				'}';
	}
}
