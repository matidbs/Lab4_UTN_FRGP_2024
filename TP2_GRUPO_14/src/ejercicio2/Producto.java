package ejercicio2;

import java.time.LocalDate;

public class Producto {

	private LocalDate fechaCaducidad;
	private int numeroLote;
	
	public Producto() {
		
	}
	
	public Producto(LocalDate fechaCaducidad, int numeroLote) {
		this.fechaCaducidad = fechaCaducidad;
		this.numeroLote = numeroLote;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public int getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(int numeroLote) {
		this.numeroLote = numeroLote;
	}

	@Override
	public String toString() {
		return "Fecha de Caducidad: " + fechaCaducidad + ", Numero de Lote:" + numeroLote;
	}
	
}
