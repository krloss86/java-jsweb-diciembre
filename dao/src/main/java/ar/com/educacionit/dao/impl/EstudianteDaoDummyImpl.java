package ar.com.educacionit.dao.impl;

import java.util.Arrays;
import java.util.Collection;

import ar.com.educacionit.dao.EstudianteDao;
import ar.com.educacionit.domain.Estudiantes;
import ar.com.educacionit.exceptions.GenericException;

public class EstudianteDaoDummyImpl implements EstudianteDao {

	@Override
	public Estudiantes getOne(Long id) throws GenericException {
		
		Estudiantes dummy = new Estudiantes(id.intValue(), "pepe", "pepe");
		
		return dummy;
	}

	@Override
	public Collection<Estudiantes> findAll() throws GenericException {
		Estudiantes dummy1 = new Estudiantes(1, "pepe", "pepe");
		Estudiantes dummy2 = new Estudiantes(2, "pepe", "pepe");
		
		return Arrays.asList(new Estudiantes[] {dummy1, dummy2});
	}

}
