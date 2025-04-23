package ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ListIterator;

public class mainEjercicio2 {

	public static void main(String[] args) {
		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
		
		listaProductos.add(new ProductoFresco(LocalDate.of(2024, 9, 27),222,LocalDate.of(2024, 8, 19),"Argentina"));
		listaProductos.add(new ProductoCongelado(LocalDate.of(2024, 10, 12),112313,-10));
		listaProductos.add(new ProductoRefrigerado(LocalDate.of(2024, 11, 13),53123,"CE1231/12"));
		
		ListIterator<Producto> iterador = listaProductos.listIterator();
		
		while(iterador.hasNext()) {
			Producto producto = iterador.next();
			System.out.println(producto.toString());
		}
	}
}
