package ar.com.educacionit.dao;

import java.util.Collection;

import ar.com.educacionit.domain.Estudiante;
import ar.com.educacionit.exceptions.GenericException;

public interface EstudianteDao {

	//read
	public Estudiante getOne(Long id) throws GenericException;
	
	public Collection<Estudiante> findAll() throws GenericException;
}
