package ejercicio2;

import java.time.LocalDate;

public class ProductoCongelado extends Producto {
	private int tempCongelacionReco;

	ProductoCongelado(){
		
	}
	
	ProductoCongelado(LocalDate fechaCaducidad, int numLote, int tempCongR){
		super(fechaCaducidad,numLote);
		this.tempCongelacionReco = tempCongR;
	}
	
	public int getTempCongelacionReco() {
		return tempCongelacionReco;
	}

	public void setTempCongelacionReco(int tempCongelacionReco) {
		this.tempCongelacionReco = tempCongelacionReco;
	}

	@Override
	public String toString() {
		return "Producto Congelado = " + super.toString() + ", Temperatura de congelación recomendada: " + tempCongelacionReco + "°C";
	}
	
	
}
