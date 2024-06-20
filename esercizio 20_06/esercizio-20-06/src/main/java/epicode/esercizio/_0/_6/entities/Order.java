package epicode.esercizio._0._6.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalTime;
import java.util.List;


@Getter
@ToString
@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int numeroCoperti;
	private LocalTime oraAcquisizione;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private List<Pizza> pizzas;

	@ManyToOne
	@JoinColumn(name = "table_id")
	private Table table;

	public Order() {

	}

	public Order(int numeroCoperti, Table table) {
		this.numeroCoperti = numeroCoperti;
		this.table = table;
		this.oraAcquisizione = LocalTime.now();
	}

	public double getTotale() {
		double totalePizze = pizzas.stream().mapToDouble(Pizza::getPrice).sum();
		double totaleCoperti = numeroCoperti * table.getCostoCoperto();
		return totalePizze + totaleCoperti;
	}

	public void addItem(Pizza pizza) {
		pizzas.add(pizza);
	}

	public void print() {
		System.out.println("Ordine:");
		System.out.println("Numero coperti: " + numeroCoperti);
		System.out.println("Ora acquisizione: " + oraAcquisizione);
		System.out.println("Pizze ordinate: ");
		pizzas.forEach(System.out::println);
		System.out.println("Tavolo: " + table);
	}
}
