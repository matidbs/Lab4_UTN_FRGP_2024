package ejercicio3;

public class EdificioOficinas extends Edificio {
	private int numeroDeOficinas;
	
	EdificioOficinas(){
		super();
	}
	
	EdificioOficinas(double superficie, int numOficinas){
		super(superficie);
		this.numeroDeOficinas = numOficinas;
	}

	public int getNumeroDeOficinas() {
		return numeroDeOficinas;
	}

	public void setNumeroDeOficinas(int numeroDeOficinas) {
		this.numeroDeOficinas = numeroDeOficinas;
	}

	@Override
	public String toString() {
		return "Edificio de Oficinas = "+super.toString() + "\nCantidad de oficinas en el edificio: " + numeroDeOficinas;
	}
	
	
}
