package ejercicio3;

public class Polideportivo extends Edificio implements I_InstalacionDeportiva{
	private String nombre;
	
	public Polideportivo(){
		super();
	}
	
	public Polideportivo(String nombre, double superficie){
		super(superficie);
		this.nombre = nombre;
	}

	@Override
	public int getTipoDeInstalacion() {
		return 1;
	}

	@Override
	public String toString() {
		return "Polideportivo =  " + super.toString() + "\nNombre del Polideportivo: " + nombre;
	}

	
	
}
