package ar.com.educacionit.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ar.com.educacionit.dao.EstudianteDao;
import ar.com.educacionit.dao.impl.EstudianteDaoJdbcImpl;
import ar.com.educacionit.domain.Estudiantes;
import ar.com.educacionit.exceptions.GenericException;
import ar.com.educacionit.exceptions.ServiceException;

public class EstudianteServiceImpl implements EstudianteService {

	private EstudianteDao estudianteDao;
	
	public EstudianteServiceImpl() {
		//seleccionamos que implementacin usar!´
		this.estudianteDao = new EstudianteDaoJdbcImpl();
	}
	
	@Override
	public Estudiantes obtenerEstudiante(Long id) throws ServiceException {
		
		try {
			return this.estudianteDao.getOne(id);
		} catch (GenericException e) {
			throw new ServiceException("Error consultando el id:" + id, e);
		}
	}

	@Override
	public Collection<Estudiantes> obtenerEstudiantes() throws ServiceException {
		try {
			return this.estudianteDao.findAll();
		} catch (GenericException e) {
			throw new ServiceException("Error consultando estudiante", e);
		}
	}

}
