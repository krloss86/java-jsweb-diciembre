package ar.com.educacionit.service;

import java.util.Collection;

import ar.com.educacionit.domain.Estudiante;
import ar.com.educacionit.exceptions.ServiceException;

public interface EstudianteService {

	public Estudiante obtenerEstudiante(Long id) throws ServiceException;
	
	public Collection<Estudiante> obtenerEstudiantes() throws ServiceException;
}
