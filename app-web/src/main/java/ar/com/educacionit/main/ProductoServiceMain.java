package ar.com.educacionit.main;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.impl.ProductoServiceImpl;

public class ProductoServiceMain {

	public static void main(String[] args) throws ServiceException {
		
		ProductoService ps = new ProductoServiceImpl();
		
		for(Producto aux :  ps.obtenerProductos()) {
			System.out.println(aux);
		}

	}

}
