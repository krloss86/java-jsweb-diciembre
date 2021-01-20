package ar.com.educacionit.clase8;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;

public class Create extends CrudBase implements ICrud {

	@Override
	public void execute() {
		
		System.out.println("Ingrese código");
		String codigo = teclado.next();
		
		System.out.println("Ingrese Título");
		String titulo = teclado.next();
		
		System.out.println("Ingrese Percio");
		Float precio = teclado.nextFloat();
		
		System.out.println("Ingrese Tipo Producto");
		Long tipoProducto = teclado.nextLong();
		
		Producto producto = new Producto(titulo, precio, codigo, tipoProducto);
		
		//grabar?
		try {
			Producto productoCreado = this.ps.crearProducto(producto);
			System.out.println("Se ha creado el producto ID:" + producto.getId());
		} catch (ServiceException e) {
			System.err.println("No se ha podido crear el producto:"+ e.getMessage());
		}
	}

}
