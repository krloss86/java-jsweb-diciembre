package ar.com.educacionit.main.ejclase7;

import java.util.Collection;
import java.util.Scanner;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.impl.ProductoServiceImpl;

public class ActualizarProductoMain {

	public static void main(String[] args) {
		
		//interface i = new clase();
		ProductoService ps = new ProductoServiceImpl();
		
		Scanner teclado = new Scanner(System.in);
		System.out.print("Ingrese codigo de producto:");
		String codigoBuscado = teclado.next();
		
		try {
			Producto producto = ps.obtenerProducto(codigoBuscado);			
			System.out.println(producto);
			
			float incremento = 1.1f;
			
			double nuevoPrecio = producto.getPrecio() * incremento; 
			producto.setPrecio((float)nuevoPrecio);
			
			//llamar al update!
			ps.updateProducto(producto);
			
			producto = ps.obtenerProducto(codigoBuscado);
			System.err.println(producto);
		} catch (ServiceException e) {			
			e.printStackTrace();
		} finally {
			teclado.close();
		}
		System.exit(1);
	}

}
