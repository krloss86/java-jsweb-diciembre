package ar.com.educacionit.clase8.queue;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.impl.ProductoServiceImpl;

public class MainQueue {

	
	public static void main(String[] args) {
		
		ProductoService ps = new ProductoServiceImpl();
		
		Queue<Producto> cola = new LinkedList<>(); 
		
		try {
			Collection<Producto> producos = ps.obtenerProductos();
			
			//CARGAR EN COLA DE PROCESO
						
			//procesar ()
			
		} catch (ServiceException e) {
			//procesar en txt
			e.printStackTrace();
		}
		
		
	}

}
