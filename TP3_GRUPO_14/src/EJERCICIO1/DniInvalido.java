package EJERCICIO1;

import java.io.IOException;

public class DniInvalido extends IOException{
	
	public DniInvalido() {
		
	}

	@Override
	public String getMessage() {
		return "SOLO NUMEROS, NO LETRAS";
	}
	
	

}
