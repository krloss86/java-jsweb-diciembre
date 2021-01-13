package ar.com.educacionit.service;

import java.util.Collection;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;

public interface ProductoService {

	public Producto crearProducto(Producto producto) throws ServiceException;
	
	public Collection<Producto> obtenerProductos() throws ServiceException;
	
	public Producto deleteProducto(Long id) throws ServiceException;
	
	public Producto updateProducto(Producto producto) throws ServiceException;
	
	public Producto obtenerProducto(String codigo) throws ServiceException;
}
