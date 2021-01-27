package ar.com.educacionit.clase10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.main.clase9.Parseable;

public class CSVFileParser extends FileBase implements Parseable<Collection<Producto>>, FileConverter<List<String>> {

	public CSVFileParser(String nombreArchivo, String delimitador) {
		super(nombreArchivo, delimitador);
	}

	@Override
	public Collection<Producto> parsear() {
		
		Collection<Producto> productosParseados = new ArrayList<Producto>();
		
		File file = new File(this.nombreArchivo);
		
		if(file.exists()) {
			
			FileReader fr;
			
			try {
				
				fr = new FileReader(file);
			
				BufferedReader br = new BufferedReader(fr);
				
				String lineaLeida;
				
				//lectura de las columnas
				lineaLeida = br.readLine();
				
				while(lineaLeida != null) {
					
					//leo un registro
					lineaLeida = br.readLine();
					
					if(lineaLeida !=null) {
						
						// 1;titulo;100;1
						String[] split = lineaLeida.split(this.delimitador);
						//0 > id
						//1 > titulo
						//2 > codigo
						//3 > precio
						//4 > tipo
						Long id = Long.parseLong(split[0]);
						String titulo = split[1];
						String codigo = split[2];
						Float precio = Float.parseFloat(split[3]);
						Long tipoProducto = Long.parseLong(split[4]);
						
						Producto producto = new Producto(titulo, id,precio,codigo,tipoProducto);
						
						productosParseados.add(producto);
					}
				}
				
				fr.close();
			} catch (IOException e) {
				System.err.println(e);
			}
		}	
		
		return productosParseados;
	}

	@Override
	public List<String> convert(Collection<Producto> productos) {
		
		List<String> lineas = new ArrayList<String>();
		//id;titulo;codigo;precio;tipo_producto
		lineas.add("id;titulo;codigo;precio;tipo_producto");
		
		//producto.getId();produc...
		if(!productos.isEmpty()) {
			
			for(Producto producto : productos) {
				StringBuffer linea = new StringBuffer("\n");
				
				linea.append(producto.getId()).append(";");
				linea.append(producto.getTitulo()).append(";");
				linea.append(producto.getCodigo()).append(";");
				linea.append(producto.getPrecio()).append(";");
				linea.append(producto.getTipoProducto());
				
				lineas.add(linea.toString());
			}			
		}
		
		return lineas;
	}

}
