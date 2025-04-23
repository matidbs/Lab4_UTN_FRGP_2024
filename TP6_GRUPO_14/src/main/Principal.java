package main;

import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.controlador.Controlador;
import presentacion.vista.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaPrincipal vp = new VentanaPrincipal();
		PersonaNegocio pn = new PersonaNegocioImpl();
		
		Controlador controlador = new Controlador(vp, pn);
		controlador.inicializar();
	}

}
