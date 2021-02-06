package ar.com.educacionit.clase10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.Part;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.main.clase9.Parseable;

public class CSVFileParser extends FileBase implements Parseable<Collection<Producto>>, FileConverter<List<String>> {
	
	/**
	 * @param type
	 * @param filePart
	 */
	public CSVFileParser(String type, Part filePart, String delimitador) {
		super(type, filePart);
		this.delimitador = delimitador;
	}

	public CSVFileParser(String nombreArchivo, String delimitador) {
		super(nombreArchivo, delimitador);
	}

	@Override
	public Collection<Producto> parsear() {
		
		Collection<Producto> productosParseados = null;
		
		BufferedReader br = null;
		try {
			if(super.filePart !=null) {
			InputStream fileContent;
				fileContent = filePart.getInputStream();
				br = new BufferedReader(new InputStreamReader(fileContent));
		}else {
			
			File file = new File(this.nombreArchivo);
			
			if(file.exists()) {
				
				FileReader fr;
				
				fr = new FileReader(file);
					
				br = new BufferedReader(fr);	
			}
		}
		} catch (IOException e) {
			productosParseados = new ArrayList<Producto>();
		}
		
		if(br != null) {
			try {
				productosParseados = buildProductos(br);
			} catch (IOException e) {
				productosParseados = new ArrayList<Producto>();
			}
		}			
				
		return productosParseados;
	}

	private Collection<Producto> buildProductos(BufferedReader br) throws IOException {
		
		Collection<Producto> productosParseados = new ArrayList<Producto>();
		
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
				Long id;
				if(split[0]!=null && !split[0].trim().equals("")) {
					id = Long.parseLong(split[0]);
				}else {
					id = null;
				}
				
				String titulo = split[1];
				String codigo = split[2];
				Float precio = Float.parseFloat(split[3]);
				Long tipoProducto = Long.parseLong(split[4]);
				
				Producto producto = new Producto(titulo, id,precio,codigo,tipoProducto);
				
				productosParseados.add(producto);
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
