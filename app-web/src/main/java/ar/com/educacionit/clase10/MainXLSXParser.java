package ar.com.educacionit.clase10;

import java.util.Collection;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.main.clase9.Parseable;

public class MainXLSXParser {

	public static void main(String[] args) {
		
		String nombreArchivo = "c:/carpeta/file.xlsx";
		
		Parseable<Collection<Producto>> parseable = new XLSXFileParser(nombreArchivo);

		Collection<Producto> productos = parseable.parsear();
		
		System.out.println(productos);
	}

}
