package ejercicio1;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + edad;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		/*if (ID != other.ID)
			return false;*/
		if (edad != other.edad)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
}
