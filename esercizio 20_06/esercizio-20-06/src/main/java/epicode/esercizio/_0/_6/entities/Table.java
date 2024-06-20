package epicode.esercizio._0._6.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Table {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numTable;
	private int numMaxCoperti;
	private double costoCoperto;

	public Table(int numTable, int numMaxCoperti, TableState occupato, double costoCoperto) {
		this.numTable = numTable;
		this.numMaxCoperti = numMaxCoperti;
		this.costoCoperto = costoCoperto;
	}

	public int getNumMaxCoperti() {
		return numMaxCoperti;
	}

	public int getNumTable() {
		return numTable;
	}

	public double getCostoCoperto() {
		return costoCoperto;
	}


}
