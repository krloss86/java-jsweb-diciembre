package ar.com.educacionit.main.ejclase7;

import java.util.Collection;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.impl.ProductoServiceImpl;

public class CRUDMainProducto {

	public static void main(String[] args) {
		
		//interface i = new clase();
		ProductoService ps = new ProductoServiceImpl();
		
		//obtener todos los productos
				
		//upgrade de precio: 10%
		try {
			Collection<Producto> productos = ps.obtenerProductos();
			System.out.println(productos);
			
			float incremento = 1.1f;
			
			for(Producto producto : productos) {// SI PUEDO USAR UN FOREACH PORQUE SOLO VOY A CAMBIAR ATRIBUTOS
				double nuevoPrecio = producto.getPrecio() * incremento; 
				producto.setPrecio((float)nuevoPrecio);
				
				//llamar al update!
				ps.updateProducto(producto);
			}	
			
			productos = ps.obtenerProductos();
			System.err.println(productos);
		} catch (ServiceException e) {			
			e.printStackTrace();
			System.exit(1);
		}
	}

}
