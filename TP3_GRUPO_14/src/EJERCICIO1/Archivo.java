package EJERCICIO1;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.TreeSet;
import java.util.Iterator;

public class Archivo extends Persona{
	private String ruta;
	
	public Archivo() {}
	
	public Archivo(String ruta) {this.ruta = ruta;}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	public boolean existe() {
		File archivo = new File(ruta);
		if(archivo.exists()) {return true;}
		return false;
	}
	
	public boolean crearArchivo() {
		FileWriter escritura;
		try {
			escritura = new FileWriter(ruta, true);
			escritura.write("");
			escritura.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public TreeSet<Persona> leerLineas() {		
		TreeSet<Persona> listaP = new TreeSet<Persona>();		
		try {
			
			FileReader entrada = new FileReader(ruta);
			BufferedReader buffer = new BufferedReader(entrada);
			
			String leyendo = "";
			while(leyendo != null) {
				leyendo = leyendo.trim();
				if(!(leyendo.isEmpty()))
			{
			    String persona = leyendo;
			    String partes[] = persona.split("-");
			    Persona p = new Persona();
			    p.setNombre(partes[0]);
			    p.setApellido(partes[1]);
			    p.setDni(partes[2]);
			    try {
					Persona.verificarDniInvalido(p.getDni());
					listaP.add(p);
				} catch (DniInvalido e) {
					System.out.println(e.getMessage());
				}
			}
				leyendo = buffer.readLine();
			}
			entrada.close();
			buffer.close();
		} catch(IOException e){
			e.printStackTrace();
			System.out.println("No se encuentra el archivo que se quiere leer!");
		}
		return listaP;
	}
	
	public void escribirArchivo (TreeSet<Persona> linea) {
		try {
		FileWriter entrada = new FileWriter(ruta, true);
		BufferedWriter buffer = new BufferedWriter(entrada);
		Iterator<Persona> iterator = linea.iterator();
		while(iterator.hasNext()) {
			Persona p = iterator.next();
			buffer.write(p.toString() + "\n");
		}
		buffer.close();
		entrada.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
