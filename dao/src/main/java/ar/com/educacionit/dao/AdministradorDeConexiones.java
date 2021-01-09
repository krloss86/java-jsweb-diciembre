package ar.com.educacionit.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import ar.com.educacionit.exceptions.GenericException;

public class AdministradorDeConexiones {

	public static Connection obtenerConexion() throws GenericException {
		
		//driver
		String driver = "com.mysql.jdbc.Driver";
		
		String dbConnectionString = "jdbc:mysql://127.0.1:3306/jsweb-diciembre?serverTimezone=UTC";
		
		//username
		String username = "root";
		
		//password
		String password = "root";
		
		//establer la conexion!
		
		try {
			Class.forName(driver).newInstance();
			
			//crear la conexion
			Connection connection = DriverManager.getConnection(dbConnectionString, username, password);
			
			return connection;
		}catch (Throwable e) {
			throw new GenericException("No se ha podido obtener conexion: "+ dbConnectionString + " username:" + username + ", passqword:"+ password, e);
		}
	}
}
