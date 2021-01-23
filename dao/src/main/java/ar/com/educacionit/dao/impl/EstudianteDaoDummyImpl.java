package ar.com.educacionit.dao.impl;

import java.util.Arrays;
import java.util.Collection;

import ar.com.educacionit.dao.EstudianteDao;
import ar.com.educacionit.domain.Estudiante;
import ar.com.educacionit.exceptions.GenericException;

public class EstudianteDaoDummyImpl implements EstudianteDao {

	@Override
	public Estudiante getOne(Long id) throws GenericException {
		
		Estudiante dummy = new Estudiante(id, "pepe", "pepe");
		
		return dummy;
	}

	@Override
	public Collection<Estudiante> findAll() throws GenericException {
		Estudiante dummy1 = new Estudiante(1l, "pepe", "pepe");
		Estudiante dummy2 = new Estudiante(2l, "pepe", "pepe");
		
		return Arrays.asList(new Estudiante[] {dummy1, dummy2});
	}

}
