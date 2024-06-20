package epicode.esercizio._0._6;

import epicode.esercizio._0._6.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdersRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		try {
			Menu menu = ctx.getBean(Menu.class);
			menu.printMenu();

			Table table1 = ctx.getBean("Tavolo1", Table.class);

			Order order1 = new Order(4, table1);

			List<Pizza> pizzas = ctx.getBean("pizzas", List.class);
			List<Drink> drinks = ctx.getBean("drinks", List.class);

			order1.addItem(pizzas.get(0));
			order1.addItem(pizzas.get(1));
			order1.addItem(pizzas.get(2));


			System.out.println("DETTAGLI TAVOLO 1:");
			order1.print();

			System.out.println("CONTO TAVOLO 1");
			System.out.println(order1.getTotale());
		} catch (Exception ex) {
			System.err.println("Errore durante l'esecuzione dell'applicazione: " + ex.getMessage());
		} finally {
			ctx.close();
		}
	}
}
