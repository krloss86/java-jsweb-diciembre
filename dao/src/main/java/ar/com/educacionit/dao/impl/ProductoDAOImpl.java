package ar.com.educacionit.dao.impl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ar.com.educacionit.dao.AdministradorDeConexiones;
import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.connection.Connection;
import ar.com.educacionit.dao.connection.ConnectionUtils;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.DuplicatedExceptions;
import ar.com.educacionit.exceptions.GenericException;
import ar.com.educacionit.exceptions.MISQLException;

public class ProductoDAOImpl implements ProductoDAO {

	private Connection connection;
	
	public ProductoDAOImpl() {
		this.connection = new ConnectionUtils("MYSQL","root","root").getConnection();
	}
	
	@Override
	public Producto insert(Producto producto) throws DuplicatedExceptions, GenericException {
		
		//generic
		if(producto == null) {
			throw new GenericException("EL producto es nulo, no se puede crear en db", null);
		}
		
		//INVENTANDO UN CASO PARA LANZAR UNA DUPLICATED
		if(producto.getCodigo().equals("abc123")) {
			throw new DuplicatedExceptions("El codigo abc123 ya existe",null);
		}
		
		//sql insert into productos ....
		
		try {
			connection.abrir();
			
			connection.ejecutarSql("insert into producto ");
			
			Producto productoNuevo = new Producto(producto.getTitulo(), 
					new Long(1), 
					producto.getPrecio(), 
					producto.getCodigo());
			
			return productoNuevo;
		}catch (MISQLException mie) {
			throw new GenericException("Error en proceso de crecion", mie);
		} finally {
			try {
				//jdbc
				connection.cerrar();
			} catch (MISQLException mie) {
				throw new RuntimeException(mie.getMessage()); 
			}			
		}
		
	}

	@Override
	public ArrayList<Producto> findAll() throws GenericException {
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		//try-catch with resources
		try (java.sql.Connection con = AdministradorDeConexiones.obtenerConexion()) {
						
			//sql
			Statement st = con.createStatement();
			
			//obtengo los resultados
			ResultSet rs = st.executeQuery("SELECT * FROM productos");
			
			while(rs.next()) {
				Long id = rs.getLong(1);
				String titulo = rs.getString(2);
				Float precio = rs.getFloat(3);
				String codigo = rs.getString(4);
				Long tipoProductgo = rs.getLong(5);
				
				Producto producto = new Producto(titulo, id, precio, codigo);
				productos.add(producto);
				//agregar a una lista o vector!!!
			}			
		}catch (Exception e) {
			throw new GenericException("No se ha podido obtener la lista de productos", e);
		}
		
		return productos;
	}

	

}
