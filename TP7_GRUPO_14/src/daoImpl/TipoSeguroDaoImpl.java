package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.TipoSeguroDao;
import dominio.TipoSeguro;

public class TipoSeguroDaoImpl implements TipoSeguroDao {

	private static final String listar = "SELECT * FROM tiposeguros";
	private static final String busquedaIndividual = "SELECT * FROM tiposeguros where idTipo = ?";
	
	@Override
	public List<TipoSeguro> listar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		ArrayList<TipoSeguro> listaTiposSeguros = new ArrayList<TipoSeguro>();
		PreparedStatement pst;
		ResultSet rs;
		Connection cn = Conexion.getConexion().getSQLConexion();
		try {
			pst = cn.prepareStatement(listar);
			rs = pst.executeQuery();
			while(rs.next()) {
				TipoSeguro ts = new TipoSeguro();
				ts.setIdTipo(rs.getInt(1));
				ts.setDescripcion(rs.getString(2));
				listaTiposSeguros.add(ts);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listaTiposSeguros;
	}

	@Override
	public TipoSeguro buscarTipoSeguro(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pst;
		ResultSet rs;
		Connection cn = Conexion.getConexion().getSQLConexion();
		TipoSeguro ts = new TipoSeguro();
		try {
			pst = cn.prepareStatement(busquedaIndividual);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				ts.setIdTipo(rs.getInt(1));
				ts.setDescripcion(rs.getString(2));
			}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ts;
	}

}
