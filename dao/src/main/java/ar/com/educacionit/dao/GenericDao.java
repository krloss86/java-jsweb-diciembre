package ar.com.educacionit.dao;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ar.com.educacionit.exceptions.GenericException;

public class GenericDao<T extends Object> {

	protected Class<T> clazz;
	
	public GenericDao(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public T getOne(Long id) throws GenericException {
	
		Object tipo;

		try {

			Connection con = AdministradorDeConexiones.obtenerConexion();
			
			//API REFLECTION!
			tipo = clazz.newInstance();
			
			String tabla = tipo.getClass().getSimpleName().toUpperCase(); //ESTUDIANTES
			
			String sql = "SELECT * FROM " + tabla;
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			//https://www.javatpoint.com/java-reflection
			if(rs.next()) {//ctrl+shit+i
				for(int i = 0; i< rs.getMetaData().getColumnCount();i++) {
					String column = rs.getMetaData().getColumnName(i+1);					
					Object dato = rs.getObject(i+1);
					String set = "set"+column.substring(0,1).toUpperCase()+column.substring(1,column.length()).toLowerCase();
					tipo.getClass().getDeclaredMethod(set,dato.getClass()).invoke(tipo, dato);
				}
			}
			
			return (T) tipo;
		} catch (Exception e) {			
			throw new GenericException(e.getMessage(),e);
		}
		
	}
}
 