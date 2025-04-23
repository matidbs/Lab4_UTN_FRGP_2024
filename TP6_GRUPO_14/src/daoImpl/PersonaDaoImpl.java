package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao {

	private static final String insert = "INSERT INTO personas(Dni, Nombre, Apellido) VALUES(?,?,?)";
	private static final String update = "UPDATE personas SET Nombre = ?, Apellido = ? WHERE Dni = ?";
	private static final String delete = "DELETE from personas WHERE Dni = ?";
	private static final String listar = "SELECT * FROM personas";
	private static final String busquedaEspecifica ="select * from personas where dni =?";

	public boolean insert(Persona persona) {
		PreparedStatement pst;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean agregado = false;
		try {
			pst = conexion.prepareStatement(insert);
			pst.setString(1, persona.getDni());
			pst.setString(2, persona.getNombre());
			pst.setString(3, persona.getApellido());
			int filas = pst.executeUpdate();
			if(filas > 0) {
			agregado = true;
			conexion.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return agregado;
	}


	public boolean update(Persona persona) {
		PreparedStatement pst;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean actualizado = false;
		try {
			pst = conexion.prepareStatement(update);
			pst.setString(1, persona.getNombre());
			pst.setString(2, persona.getApellido());
			pst.setString(3, persona.getDni());
			int filas = pst.executeUpdate();
			if(filas > 0) {
				actualizado = true;
				conexion.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return actualizado;
	}

	public boolean delete(Persona persona) {
		PreparedStatement pst;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean eliminado = false;
		try {
			pst = conexion.prepareStatement(delete);
			pst.setString(1, persona.getDni());
			if(pst.executeUpdate() > 0) {
				eliminado = true;
				conexion.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return eliminado;
	}

	@Override
	public List<Persona> listar() {
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		PreparedStatement pst;
		ResultSet rs;
		Connection cn = Conexion.getConexion().getSQLConexion();
		try {
			pst = cn.prepareStatement(listar);
			rs = pst.executeQuery();
			while(rs.next()) {
				//Carga el objeto y lo agrega
				Persona p = new Persona();
				p.setDni(rs.getString("Dni"));
				p.setNombre(rs.getString("Nombre"));
				p.setApellido(rs.getString("Apellido"));
				listaPersonas.add(p);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listaPersonas;
	}


	@Override
	public boolean ExistePersona(Persona persona) {
		boolean existe = false;
		PreparedStatement pst;
		Connection cn = Conexion.getConexion().getSQLConexion();
		ResultSet rs;
		try {
			pst = cn.prepareStatement(busquedaEspecifica);
			pst.setString(1, persona.getDni());
			rs = pst.executeQuery();
			
			if(rs.isBeforeFirst()) existe = true; //si es true, es porque contiene filas. Es decir, existe un registro con ese dni		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existe;
		
		
	}

}
