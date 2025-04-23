package EJERCICIO1;

import java.util.Iterator;
import java.util.TreeSet;

public class Principal {

	public static void main(String[] args) {
		
		Archivo a = new Archivo("Personas.txt");

		if(a.existe()) {
			System.out.println("El archivo ya existe");
		} else {
			System.out.println("No existe el archivo, entonces lo creamos");
			a.crearArchivo();
		}
		
		TreeSet<Persona> registros = new TreeSet<>();
		registros = a.leerLineas();
		
		Archivo archivo = new Archivo();
		archivo.setRuta("Resultado.txt");

		if(archivo.existe()) {
			System.out.println("El archivo ya existe");
		} else {
			System.out.println("No existe el archivo, entonces lo creamos");
			archivo.crearArchivo();
			archivo.escribirArchivo(registros);
		}
		
		
	}

}
