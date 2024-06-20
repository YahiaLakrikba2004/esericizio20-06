package epicode.esercizio._0._6.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableJpaRepositories(basePackages = "epicode.esercizio._0._6.repositories")
public class AppConfig {

	@Bean(name = "toppingTomato")
	public Topping toppingTomatoBean() {
		return new Topping("Tomato", 0, 0);
	}

	@Bean(name = "toppingCheese")
	public Topping toppingCheeseBean() {
		return new Topping("Cheese", 92, 0.69);
	}

	@Bean(name = "toppingHam")
	public Topping toppingHamBean() {
		return new Topping("Ham", 35, 0.99);
	}

	@Bean(name = "toppingPineapple")
	public Topping toppingPineappleBean() {
		return new Topping("Pineapple", 24, 0.79);
	}

	@Bean(name = "toppingSalami")
	public Topping toppingSalamiBean() {
		return new Topping("Salami", 86, 0.99);
	}

	@Bean(name = "pizzaMargherita")
	public Pizza pizzaMargheritaBean() {
		List<Topping> toppings = new ArrayList<>();
		toppings.add(toppingTomatoBean());
		toppings.add(toppingCheeseBean());
		return new Pizza("Pizza Margherita", toppings, false);
	}

	@Bean(name = "hawaiianPizza")
	public Pizza pizzaHawaiianBean() {
		List<Topping> toppings = new ArrayList<>();
		toppings.add(toppingTomatoBean());
		toppings.add(toppingCheeseBean());
		toppings.add(toppingHamBean());
		toppings.add(toppingPineappleBean());
		return new Pizza("Hawaiian Pizza", toppings, false);
	}

	@Bean(name = "salamiPizza")
	public Pizza pizzaSalamiBean() {
		List<Topping> toppings = new ArrayList<>();
		toppings.add(toppingTomatoBean());
		toppings.add(toppingCheeseBean());
		toppings.add(toppingSalamiBean());
		return new Pizza("Salami Pizza", toppings, false);
	}

	@Bean(name = "salamiPizzaXL")
	public Pizza pizzaSalamiXlBean() {
		List<Topping> toppings = new ArrayList<>();
		toppings.add(toppingTomatoBean());
		toppings.add(toppingCheeseBean());
		toppings.add(toppingSalamiBean());
		return new Pizza("Salami Pizza XL", toppings, true);
	}

	@Bean(name = "lemonade")
	public Drink lemonadeBean() {
		return new Drink(0, 1.29, "Lemonade");
	}

	@Bean(name = "water")
	public Drink waterBean() {
		return new Drink(0, 1.29, "Water");
	}

	@Bean(name = "wine")
	public Drink wineBean() {
		return new Drink(607, 7.49, "Wine");
	}

	@Bean(name = "pizzas")
	public List<Pizza> pizzaList() {
		List<Pizza> pizzas = new ArrayList<>();
		pizzas.add(pizzaMargheritaBean());
		pizzas.add(pizzaHawaiianBean());
		pizzas.add(pizzaSalamiBean());
		pizzas.add(pizzaSalamiXlBean());
		return pizzas;
	}

	@Bean(name = "drinks")
	public List<Drink> drinksList() {
		List<Drink> drinks = new ArrayList<>();
		drinks.add(lemonadeBean());
		drinks.add(waterBean());
		drinks.add(wineBean());
		return drinks;
	}

	@Bean(name = "toppings")
	public List<Topping> toppingsList() {
		List<Topping> toppings = new ArrayList<>();
		toppings.add(toppingTomatoBean());
		toppings.add(toppingCheeseBean());
		toppings.add(toppingSalamiBean());
		toppings.add(toppingHamBean());
		toppings.add(toppingPineappleBean());
		return toppings;
	}

	@Bean(name = "table1")
	public Table table1(@Value("${seat.price}") double seatPrice) {
		return new Table(1, 5, TableState.OCCUPATO, seatPrice);
	}

	@Bean(name = "table2")
	public Table table2(@Value("${seat.price}") double seatPrice) {
		return new Table(2, 4, TableState.LIBERO, seatPrice);
	}

	@Bean(name = "table3")
	public Table table3(@Value("${seat.price}") double seatPrice) {
		return new Table(3, 8, TableState.LIBERO, seatPrice);
	}
}
