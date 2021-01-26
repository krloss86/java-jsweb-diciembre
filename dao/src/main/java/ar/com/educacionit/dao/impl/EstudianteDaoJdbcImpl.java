package ar.com.educacionit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.dao.AdministradorDeConexiones;
import ar.com.educacionit.dao.EstudianteDao;
import ar.com.educacionit.dao.GenericDao;
import ar.com.educacionit.domain.Estudiantes;
import ar.com.educacionit.exceptions.GenericException;

public class EstudianteDaoJdbcImpl extends GenericDao<Estudiantes> implements EstudianteDao {

	public EstudianteDaoJdbcImpl() {
		super(Estudiantes.class);
	}
	/*
	@Override
	public Estudiante getOne(Long id) throws GenericException {
		
		Estudiante estudiante = null;
		
		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {
		
			PreparedStatement pst = con.prepareStatement("SELECT * FROM ESTUDIANTES WHERE ID = ?");
			
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				//alt+shit+m
				estudiante = buildEstudiante(rs);
			}
		}catch (Exception e) {
			throw new GenericException("Error obteniendo el id:" + id, e);
		}
		
		return estudiante;
	}
	 */
	
	@Override
	public Collection<Estudiantes> findAll() throws GenericException {
		
		Collection<Estudiantes> estudiantes = new ArrayList<Estudiantes>();
		
		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {
		
			PreparedStatement pst = con.prepareStatement("SELECT * FROM ESTUDIANTES");
						
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				estudiantes.add(buildEstudiante(rs));
			}
		}catch (Exception e) {
			throw new GenericException("Error obteniendo los estudiantes", e);
		}
		
		return estudiantes;
	}

	private Estudiantes buildEstudiante(ResultSet rs) throws SQLException {
		Estudiantes estudiante;
		Integer _id = rs.getInt(1);
		Integer dni = rs.getInt(2);
		String nombre = rs.getString(3);
		String apellido = rs.getString(4);
		
		estudiante = new Estudiantes(_id, nombre, apellido, dni);
		return estudiante;
	}
}
