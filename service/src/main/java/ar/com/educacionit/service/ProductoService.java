package ar.com.educacionit.service;

import java.util.ArrayList;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;

public interface ProductoService {

	public Producto crearProducto(Producto producto) throws ServiceException;
	
	public ArrayList<Producto> obtenerProductos() throws ServiceException;
}
