package TP5;

public class Genero implements Comparable<Genero>{
	private String nombre;
	
	public Genero(){
		
	}
	
	public Genero(String n){
		this.nombre = n;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}

	@Override
	public int compareTo(Genero o) {
		// TODO Auto-generated method stub
		return this.nombre.compareTo(o.nombre);
	}
	
	
	
}
