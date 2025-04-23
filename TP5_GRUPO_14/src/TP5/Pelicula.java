package TP5;

public class Pelicula implements Comparable<Pelicula>{
	private int ID;
	private String nombre;
	private Genero genero;
	private static int contador = 0;
	
	public Pelicula() {}
	
	public Pelicula(String nombre, Genero g) {
		contador++;
		this.ID = contador;
		this.nombre = nombre;
		this.genero = g;
	}

	public int getID() {
		return ID;
	}

	public void setID(int Id) {
		this.ID = Id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre + " - " + genero.getNombre();
	}
	
	public static int getContador() {
		return contador + 1;
	}

	@Override
	public int compareTo(Pelicula o) {
		// TODO Auto-generated method stub
		if(this.nombre.toLowerCase().replace(" ", "").compareTo(o.nombre.toLowerCase().replace(" ", "")) == 0) return this.genero.compareTo(o.genero); 
		return this.nombre.compareTo(o.nombre);
	}
	
	public static void decreaseContador() {
		contador = contador - 1;
	}
}
