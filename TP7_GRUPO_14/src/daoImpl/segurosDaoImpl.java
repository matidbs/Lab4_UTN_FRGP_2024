package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.TipoSeguroDao;
import dao.segurosDao;
import dominio.Seguro;
import dominio.TipoSeguro;

public class segurosDaoImpl implements segurosDao{
	
	public static final String listarSeguros = "SELECT * FROM seguros";
	public static final String listarSegurosPorTipo = "SELECT * FROM seguros WHERE idTipo = ?";
	private static final String insert = "INSERT INTO seguros(descripcion,idTipo,costoContratacion,costoAsegurado) VALUES (?,?,?,?)";


	public segurosDaoImpl() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public int proximoID() {
		Connection cn = Conexion.getConexion().getSQLConexion();
		PreparedStatement pst;
		ResultSet rs;
		int id = 1;
		try {
			pst = cn.prepareStatement(listarSeguros);
			rs = pst.executeQuery();
			while(rs.next()) {
				id++;
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		
		return id;
	}

	@Override
	public boolean agregarSeguro(Seguro seg) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		PreparedStatement pst;
		Connection cn = Conexion.getConexion().getSQLConexion();
		boolean resultado = false;
		try {
			pst = cn.prepareStatement(insert);
			pst.setString(1, seg.getDescripcion());
			pst.setInt(2, seg.getIdTipo().getIdTipo());
			pst.setFloat(3, seg.getCostoContratacion());
			pst.setFloat(4, seg.getCostoAsegurado());
			if(pst.executeUpdate() > 0) {
				resultado = true;
				cn.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public ArrayList<Seguro>obtenerSeguros(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Seguro> lista = new ArrayList<Seguro>();
		PreparedStatement pst;
		ResultSet rs;
		Connection cn = Conexion.getConexion().getSQLConexion();
		try {
			pst = cn.prepareStatement(listarSeguros);
			rs = pst.executeQuery();
			while(rs.next()) {
				Seguro s = new Seguro();
				s.setIdSeguro(rs.getInt("idSeguro"));
				s.setDescripcion(rs.getString("descripcion"));
				
				TipoSeguroDao tiposeguroDao = new TipoSeguroDaoImpl();
				TipoSeguro ts = tiposeguroDao.buscarTipoSeguro(rs.getInt("idTipo"));
				
				s.setIdTipo(ts);
				s.setCostoContratacion(rs.getFloat("costoContratacion"));
				s.setCostoAsegurado(rs.getFloat("costoAsegurado"));
				lista.add(s);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public ArrayList<Seguro> listarPorTipo(TipoSeguro ts) {
		
		ArrayList<Seguro> listaSegurosPorTipo = new ArrayList<Seguro>();
		Connection cn = Conexion.getConexion().getSQLConexion();
		PreparedStatement pst;
		ResultSet rs;
		try {
			
			pst = cn.prepareStatement(listarSegurosPorTipo);
			pst.setInt(1, ts.getIdTipo());
			rs = pst.executeQuery();
			while(rs.next()) {
				Seguro s = new Seguro();
				
				s.setIdSeguro(rs.getInt("idSeguro"));
				s.setDescripcion(rs.getString("descripcion"));
				
				TipoSeguroDao tiposeguroDao = new TipoSeguroDaoImpl();
				TipoSeguro tipo = tiposeguroDao.buscarTipoSeguro(rs.getInt("idTipo"));
				
				s.setIdTipo(tipo);
				s.setCostoContratacion(rs.getFloat("costoContratacion"));
				s.setCostoAsegurado(rs.getFloat("costoAsegurado"));
				listaSegurosPorTipo.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaSegurosPorTipo;
	}
	
	

}
