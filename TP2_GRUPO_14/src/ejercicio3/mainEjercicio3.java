package ejercicio3;

import java.util.ArrayList;
import java.util.ListIterator;

public class mainEjercicio3 {

	public static void main(String[] args) {
		ArrayList<Edificio> lista = new ArrayList<Edificio>();
		
		lista.add(new Polideportivo("Polideportivo Mariano Moreno", 15000));
		lista.add(new Polideportivo("Polideportivo Islas Malvinas", 10000));
		lista.add(new Polideportivo("Polideportivo General Belgrano", 13200));
		lista.add(new EdificioOficinas(10000,50));
		lista.add(new EdificioOficinas(3500,30));
		
		ListIterator<Edificio> iterador = lista.listIterator();
		while(iterador.hasNext()) {
			Edificio x = iterador.next();
		}

	}

}
