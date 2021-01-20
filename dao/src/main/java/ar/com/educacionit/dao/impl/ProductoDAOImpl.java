package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
import ar.com.educacionit.exceptions.NonExistsExceptions;

public class ProductoDAOImpl implements ProductoDAO {

	private Connection connection;
	
	public ProductoDAOImpl() {
		this.connection = new ConnectionUtils("MYSQL","root","root").getConnection();
	}
	
	@Override
	public Producto insert(Producto producto) throws DuplicatedExceptions, GenericException {
		
		try (java.sql.Connection connection = AdministradorDeConexiones.obtenerConexion()) {

			//sql grabar productos
												// string   float	string 	long	             1  2  3  4
			String  sql = "INSERT INTO productos (titulo, precio, codigo, tipo_producto) VALUES (? , ? , ? , ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			//seteo EN ORDEN los parametros asociados
			statement.setString(1, producto.getTitulo());
			statement.setFloat(2, producto.getPrecio());
			statement.setString(3, producto.getCodigo());
			statement.setLong(4, producto.getTipoProducto());
			
			statement.execute();
			ResultSet resultSet = statement.getGeneratedKeys();
			
			if(resultSet.next()) {
				Long idGeneradoEnLaDB = resultSet.getLong(1);
				
				producto.setId(idGeneradoEnLaDB);
			}
			
			//connection.commit();
			
			return producto;			
		} catch (SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException) {
				throw new GenericException("No se ha podido crear el producto, producto duplicado", e);	
			}
			throw new GenericException("No se ha podido crear el producto", e);
		}		
		
	}

	@Override
	public ArrayList<Producto> findAll() throws GenericException {
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		//try-catch with resources
		try (java.sql.Connection con = AdministradorDeConexiones.obtenerConexion()) {
						
			//sql
			PreparedStatement st = con.prepareStatement("SELECT * FROM productos");
			
			//obtengo los resultados
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Long id = rs.getLong(1);
				String titulo = rs.getString(2);
				Float precio = rs.getFloat(3);
				String codigo = rs.getString(4);
				Long tipoProductgo = rs.getLong(5);
				
				Producto producto = new Producto(titulo, id, precio, codigo, tipoProductgo);
				productos.add(producto);
				//agregar a una lista o vector!!!
			}			
		}catch (Exception e) {
			throw new GenericException("No se ha podido obtener la lista de productos", e);
		}
		
		return productos;
	}

	@Override
	public Producto update(Producto producto) throws DuplicatedExceptions, GenericException {
		String sql = "UPDATE productos SET titulo='"+producto.getTitulo()+"', precio='"+producto.getPrecio()+"', tipo_producto='"+producto.getTipoProducto()+"' WHERE  id="+producto.getId()+"";
		
		try (java.sql.Connection con = AdministradorDeConexiones.obtenerConexion()) {
			
			//sql
			Statement st = con.createStatement();
					
			st.executeUpdate(sql);
			
		}catch (Exception e) {
			throw new GenericException("No se ha podido obtener la lista de productos", e);
		}
		
		return producto;
	}

	@Override
	public Producto getByCodigo(String codigo) throws NonExistsExceptions, GenericException {
		Producto producto;
		
		//try-catch with resources
		try (java.sql.Connection con = AdministradorDeConexiones.obtenerConexion()) {
						
			//sql
			Statement st = con.createStatement();
			
			//obtengo los resultados
			ResultSet rs = st.executeQuery("SELECT * FROM productos where codigo = '" + codigo + "'");
			
			if(rs.next()) {
				Long id = rs.getLong(1);
				String titulo = rs.getString(2);
				Float precio = rs.getFloat(3);
				String codigoAux = rs.getString(4);
				Long tipoProducto = rs.getLong(5);
				
				producto = new Producto(titulo, id, precio, codigoAux, tipoProducto);
			}else {
				throw new NonExistsExceptions("EL producto codigo:" + codigo + " No existe");
			}
		}catch (Exception e) {
			throw new GenericException("No se ha podido obtener la lista de productos", e);
		}
		
		return producto;
	}

	@Override
	public Producto delete(String codigo) throws NonExistsExceptions, GenericException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
