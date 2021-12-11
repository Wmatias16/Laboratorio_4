package negocioImpl;

import java.util.ArrayList;

import dao.IMateriaDao;
import daoImpl.MateriaDaoImpl;
import dominio.Materia;
import negocio.IMateriaNegocio;

public class MateriaNegocioImpl implements IMateriaNegocio{
	private IMateriaDao mDao = new MateriaDaoImpl();

	@Override
	public ArrayList<Materia> listarMaterias() {
		return mDao.getMaterias();
	}
	
	
}
