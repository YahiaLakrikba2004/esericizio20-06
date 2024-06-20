package epicode.esercizio._0._6.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
public class Pizza extends Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ManyToMany
	private List<Topping> toppingList;

	private boolean isXl;

	public Pizza() {
	}

	public Pizza(String name, List<Topping> toppingList, boolean isXl) {
		super(1012, 4.3);
		this.name = name;
		this.toppingList = toppingList;
		this.isXl = isXl;
		this.calories = calculateCalories(toppingList, isXl);
		this.price = calculatePrice(toppingList, isXl);
	}

	private int calculateCalories(List<Topping> toppingList, boolean isXl) {
		int totalCalories = 1012;
		if (toppingList != null) {
			for (Topping topping : toppingList) {
				totalCalories += topping.getCalories();
			}
		}
		if (isXl) {
			totalCalories += (totalCalories * 5) / 100;
		}
		return totalCalories;
	}

	private double calculatePrice(List<Topping> toppingList, boolean isXl) {
		double totalPrice = 4.30;
		if (toppingList != null) {
			for (Topping topping : toppingList) {
				totalPrice += topping.getPrice();
			}
		}
		if (isXl) {
			totalPrice += (totalPrice * 10) / 100;
		}
		return totalPrice;
	}

	@Override
	public String toString() {
		return "Pizza{" +
				"id=" + id +
				", name='" + name + '\'' +
				", calories=" + calories +
				", price=" + price +
				", toppingList=" + toppingList +
				", isXl=" + isXl +
				'}';
	}
}
