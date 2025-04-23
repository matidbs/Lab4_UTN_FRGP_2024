package EJERCICIO1;

public class Empleado {
	private final int ID;
	private String nombre;
	private int edad;
	
	private static int contador = 999;
	
	public Empleado() {
		contador++;
		this.ID = contador;
		this.nombre = "Sin nombre";
		this.edad = 99;
	}
	
	public Empleado (String nombre, int edad) {
		contador++;
		this.ID = contador;
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getID() {
		return ID;
	}
	
	public static int devuelveProximoID() {
		return contador + 1;
	}
	
	@Override
	public String toString() {
		return "Empleado: Id = " + ID + ", Nombre = " + nombre + ", Edad = " + edad;
	}
	
}
