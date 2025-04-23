package ejercicio1;

import java.util.Iterator;
import java.util.TreeSet;

public class mainEjercicio1_b {

	public static void main(String[] args) {
		
		TreeSet<Profesor> listaProfesores = new TreeSet<Profesor>();
		listaProfesores.add(new Profesor("Jose Gonzales",32,"Ayudante",2));
		listaProfesores.add(new Profesor("Mario Lopez",55,"Profesor",15));
		listaProfesores.add(new Profesor("Ariel Rodriguez",45,"Profesor",10));
		listaProfesores.add(new Profesor("Maria Perez",34,"Profesor",8));
		listaProfesores.add(new Profesor("Ana Diaz",25,"Ayudante",3));
		
		Iterator<Profesor> it = listaProfesores.iterator();
		
		while(it.hasNext()) {
			Profesor p = (Profesor)it.next();
			System.out.println(p.toString());
			it.remove();
		}
		
		Profesor profeComparar = new Profesor("Ana Diaz",25,"Ayudante",3);
		Profesor profeComparar2 = new Profesor("Ana Diaz",25,"Ayudante",3);
				
		if(profeComparar.equals(profeComparar2)) {
			System.out.println("Es el mismo profesor");
		}
		else 
		{
			System.out.println("No son los mismos profesores");
		}
	}

}
