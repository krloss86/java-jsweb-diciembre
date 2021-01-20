package ar.com.educacionit.clase8;

import java.util.Collection;
import java.util.Iterator;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;

public class List extends CrudBase implements ICrud {

	@Override
	public void execute() {
		
		System.out.println("Consultando productos...");
		
		try {
			Collection<Producto> productos = ps.obtenerProductos();
			for (Producto producto : productos) {
				System.out.println(producto);
			}
		} catch (ServiceException e) {
			System.err.println(e);
		}

	}

}
