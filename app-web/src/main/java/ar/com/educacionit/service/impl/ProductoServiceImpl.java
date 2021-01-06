package ar.com.educacionit.service.impl;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.impl.ProductoDAOImpl;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.DuplicatedExceptions;
import ar.com.educacionit.exceptions.GenericException;
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
		
		//ac� va la exception!
		try {
			return this.productoDao.insert(producto);
		} catch (DuplicatedExceptions | GenericException de) {
			throw new ServiceException("No se ha podido crear el producto", de);
		}
	}

}
