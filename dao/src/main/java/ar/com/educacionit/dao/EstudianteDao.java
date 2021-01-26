package ar.com.educacionit.dao;

import java.util.Collection;

import ar.com.educacionit.domain.Estudiantes;
import ar.com.educacionit.exceptions.GenericException;

public interface EstudianteDao {

	//read
	public Estudiantes getOne(Long id) throws GenericException;
	
	public Collection<Estudiantes> findAll() throws GenericException;
}
