package negocioImpl;

import java.util.List;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio{
	PersonaDao pDao = new PersonaDaoImpl();
	
	@Override
	public boolean insert(Persona persona) {
		
				if(!(pDao.ExistePersona(persona))) 
					{
					 	return pDao.insert(persona);	 
					}
				return false;
	}

	@Override
	public boolean update(Persona persona) {
				if(pDao.update(persona))return true;
				else return false;
	}

	@Override
	public boolean delete(Persona persona) {
		boolean resultado = false;
		if(persona.getDni().trim().length() > 0) {
			if(pDao.ExistePersona(persona)) {
				 resultado = pDao.delete(persona);
			}
		}
		return resultado;
	}

	@Override
	public List<Persona> listar() {
		return pDao.listar();
	}
	

}
