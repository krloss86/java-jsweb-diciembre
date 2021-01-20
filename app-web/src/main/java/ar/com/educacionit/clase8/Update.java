package ar.com.educacionit.clase8;

import ar.com.educacionit.domain.Producto;

public class Update extends CrudBase implements ICrud {

	@Override
	public void execute() {
		
		System.out.println("Ingrese código:");
		String codigo = teclado.next();
		
		Producto productoBuscado;
		try {
			productoBuscado = ps.obtenerProducto(codigo);
			
			System.out.println("Ingrese datos a actualziar");
			
			System.out.println("Nuevo título");
			String titulo = teclado.next();
			
			System.out.println("Nuevo Precio");
			Float precio= teclado.nextFloat();
			
			System.out.println("Nuevo Tipo");
			Long tipoProducto = teclado.nextLong();
			
			productoBuscado.setPrecio(precio);
			productoBuscado.setTitulo(titulo);
			productoBuscado.setTipoProducto(tipoProducto);

			ps.updateProducto(productoBuscado);
			
			System.out.println("Se ha actualizado el producto codigo:" + codigo);
		}catch (Exception e) {
			System.err.println(e);
		}

	}

}
