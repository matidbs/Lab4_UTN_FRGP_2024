package dao;

import java.util.List;

import dominio.TipoSeguro;

public interface TipoSeguroDao {
	public List<TipoSeguro> listar();
	public TipoSeguro buscarTipoSeguro(int id);
}
