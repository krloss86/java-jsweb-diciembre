package ar.com.educacionit.service.impl;

import java.util.Collection;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.impl.ProductoDAOImpl;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.DuplicatedExceptions;
import ar.com.educacionit.exceptions.GenericException;
import ar.com.educacionit.exceptions.NonExistsExceptions;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.service.ProductoService;

public class ProductoServiceImpl implements ProductoService {

	private ProductoDAO productoDao;
	
	//contructor (I.O.C o CDI)
	public ProductoServiceImpl() {
		this.productoDao = new ProductoDAOImpl();
		//this.productoDao = new ProductoAWSImpl();
	}
	
	@Override
	public Producto crearProducto(Producto producto) throws ServiceException {
		
		//acá va la exception!
		try {
			return this.productoDao.insert(producto);
		} catch (DuplicatedExceptions | GenericException de) {
			throw new ServiceException("No se ha podido crear el producto", de);
		}
	}

	@Override
	public Collection<Producto> obtenerProductos() throws ServiceException {
		try {
			return this.productoDao.findAll();
		} catch (GenericException e) {
			throw new ServiceException("No se ha obtener el listado de productos", e);
		}
	}

	@Override
	public Producto deleteProducto(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto updateProducto(Producto producto) throws ServiceException {		
		try {
			return this.productoDao.update(producto);
		} catch (DuplicatedExceptions | GenericException e) {
			throw new ServiceException("No se ha obtener el listado de productos", e);
		}
	}

	@Override
	public Producto obtenerProducto(String codigo) throws ServiceException {		
		try {
			return this.productoDao.getByCodigo(codigo);
		} catch (NonExistsExceptions | GenericException e) {
			throw new ServiceException("No se ha obtener el listado de productos", e);
		}
	}

}
