package dao;

import java.util.ArrayList;

import dominio.Seguro;
import dominio.TipoSeguro;

public interface segurosDao {

	public boolean agregarSeguro(Seguro seg);
	public int proximoID();
	public ArrayList<Seguro> obtenerSeguros();
	public ArrayList<Seguro> listarPorTipo(TipoSeguro ts);
	
}
