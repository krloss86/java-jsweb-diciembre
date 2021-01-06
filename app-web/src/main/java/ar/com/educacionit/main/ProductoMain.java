package ar.com.educacionit.main;

import ar.com.educacionit.clase4.interfaces.FileSystemLogger;
import ar.com.educacionit.clase4.interfaces.ILogger;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.impl.ProductoServiceImpl;

public class ProductoMain {

	public static void main(String[] args) {
		
		System.out.println("Ingrese los datos para crear un producto");
		
		//html, peticion, etc!
		String titulo = "mate listo";
		Long id = new Long(1);
		String codigo = "abc1234";
		Float precio = new Float(1500);
		
		//preparo el objeto que voy a grabar!
		Producto producto = new Producto(titulo,precio, codigo);
		
		//por medio de un servicio!
		ProductoService ps = new ProductoServiceImpl();
		
		//"mando" a grabar!        //ctrl+t
		
		int reintentos = 3;
		try {
			for(int i=0; i < reintentos; i++) {
				Producto productoCreado;
				try {
					productoCreado = ps.crearProducto(producto);
					//proceso el resultado
					System.out.println("Id generado" + productoCreado.getId());
				} catch (ServiceException e) {
					e.printStackTrace();
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			//ILogger logger  = new FileSystemLogger();
			//logger.log(e);
		}
		System.out.println("Fin");
	}		

}
