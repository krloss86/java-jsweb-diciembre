package ar.com.educacionit.service;

import java.util.Collection;

import ar.com.educacionit.domain.Estudiantes;
import ar.com.educacionit.exceptions.ServiceException;

public interface EstudianteService {

	public Estudiantes obtenerEstudiante(Long id) throws ServiceException;
	
	public Collection<Estudiantes> obtenerEstudiantes() throws ServiceException;
}
