package ar.com.educacionit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.dao.AdministradorDeConexiones;
import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.DuplicatedExceptions;
import ar.com.educacionit.exceptions.GenericException;
import ar.com.educacionit.exceptions.NonExistsExceptions;

public class ProductoDAOImpl implements ProductoDAO {
	
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
		
		Producto producto = this.getByCodigo(codigo);
		if(producto == null) {
			throw new NonExistsExceptions("No se ha encontrado el producto con codigi:" + codigo);
		}
		
		String sql = "delete from productos where codigo = ?";
		
		java.sql.Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, codigo);
		} catch (SQLException e) {
			throw new GenericException("No se ha podido crear el Statement", e);
		}
		
		try {
			int resultado = statement.executeUpdate();
			if(resultado < 0) {
				throw new GenericException("No se ha podido eliminar el producto codigo:" + codigo,null);
			}			
		} catch (SQLException e) {
			throw new GenericException("No se ha podido eliminar el producto id:" + codigo, e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("NO se pudo cerrar la conexion, verfique en la DB las conexiones", e);
			}
		}
		
		return producto;
	}

	@Override
	public Collection<Producto> buscar(String claveBusqueda) throws GenericException {
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sql ="SELECT * FROM productos where upper(titulo) like '%"+claveBusqueda.toUpperCase()+"%'";
		
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			throw new GenericException("No se ha podido crear el Statement", e);
		}

		try {
			ResultSet resultSet = statement.executeQuery();
			
			Collection<Producto> productos = new ArrayList<Producto>();
				
			while(resultSet.next()) {
				Producto producto = this.productoDesdeResultSet(resultSet);
				productos.add(producto);
			}

			return productos;
			
		} catch (SQLException e) {
			throw new GenericException("No se han podido obtener los productos", e);
		} 
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("NO se pudo cerrar la conexion, verfique en la DB las conexiones", e);
			}
		}
	}

	private Producto productoDesdeResultSet(ResultSet resultSet) throws SQLException {
		Producto producto;
		Long id = resultSet.getLong(1);
		String titulo = resultSet.getString(2);
		Float precio = resultSet.getFloat(3);
		String codigoDB = resultSet.getString(4);
		Long tipoProducto = resultSet.getLong(5); 
		
		producto = new Producto(titulo, id, precio, codigoDB, tipoProducto);
		return producto;
	}

	

}
