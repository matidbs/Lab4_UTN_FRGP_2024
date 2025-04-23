package EJERCICIO1;

public class Principal {

	public static void main(String[] args) {
		
		Empleado e1 = new Empleado("Horacio", 33);
		System.out.println("Proximo ID: " + e1.devuelveProximoID());
		Empleado e2 = new Empleado ("Martin", 25);
		System.out.println("Proximo ID: " + e2.devuelveProximoID());
		Empleado e3 = new Empleado();
		System.out.println("Proximo ID: " + e3.devuelveProximoID());
		Empleado e4 = new Empleado();
		System.out.println("Proximo ID: " + e4.devuelveProximoID());
		Empleado e5 = new Empleado();
		System.out.println("Proximo ID: " + e5.devuelveProximoID());
		
		e3.setNombre("Ximena");
		e3.setEdad(41);
		e4.setNombre("Joaquin");
		e4.setEdad(21);
		e5.setNombre("Camila");
		e5.setEdad(23);
		
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		System.out.println(e3.toString());
		System.out.println(e4.toString());
		System.out.println(e5.toString());
		
		

	}

}
