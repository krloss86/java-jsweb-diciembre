package ar.com.educacionit.clase8;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;

public class Read extends CrudBase implements ICrud {

	@Override
	public void execute() {
		
		System.out.println("Ingrese codigo a buscar:");
		String codigo = teclado.next();
		
		try {
			Producto productoBuscado = ps.obtenerProducto(codigo);
			System.out.println(productoBuscado);
		} catch (ServiceException e) {
			System.err.println(e.getCause());
		}
	}

}
