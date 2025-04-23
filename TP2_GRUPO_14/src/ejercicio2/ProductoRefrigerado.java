package ejercicio2;

import java.time.LocalDate;

public class ProductoRefrigerado extends Producto{
	private String codSupervision;
	
	ProductoRefrigerado(){
		
	}
	
	ProductoRefrigerado(LocalDate fechaCaducidad, int numeroLote, String codSupervision){
		super(fechaCaducidad, numeroLote);
		this.codSupervision = codSupervision;
	}

	public String getCodSupervision() {
		return codSupervision;
	}

	public void setCodSupervision(String codSupervision) {
		this.codSupervision = codSupervision;
	}

	@Override
	public String toString() {
		return "Producto Refrigerado = " + super.toString() + ", Codigo organismo de supervision alimentaria: " + codSupervision;
	}
	
	
}
