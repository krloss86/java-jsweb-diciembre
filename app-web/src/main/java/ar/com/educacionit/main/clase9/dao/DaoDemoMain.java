package ar.com.educacionit.main.clase9.dao;

import ar.com.educacionit.domain.Estudiantes;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.service.EstudianteService;
import ar.com.educacionit.service.EstudianteServiceImpl;

public class DaoDemoMain {

	//ctrl+shit+o
	public static void main(String[] args) throws ServiceException {
		
		//obtener un estudiante dado su id
		Long idEstudiante = 1l;
		
		EstudianteService dao = new EstudianteServiceImpl();

		Estudiantes e = dao.obtenerEstudiante(idEstudiante);
		
		System.out.println(e);
	}

}
