package negocioImpl;

import java.util.List;

import entidad.Persona;
import negocio.IPersonaNegocio;

public class PersonaNegocioImpl implements IPersonaNegocio{

	
	public boolean insert(Persona persona) {
		
		Boolean estado = false;
		
		if(persona.getNombre().length() != 0 && persona.getApellido().length() != 0 && persona.getDni().length() != 0)
		{
			
		}
		
		return estado;
	}


	public boolean delete(Persona persona) {
		return false;
	}


	public boolean update(Persona persona) {
		return false;
	}

	public List<Persona> getAll() {
		return null;
	}

}
