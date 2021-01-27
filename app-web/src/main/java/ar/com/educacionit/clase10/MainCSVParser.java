package ar.com.educacionit.clase10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.main.clase9.Parseable;

public class MainCSVParser {

	public static void main(String[] args) {
		
		String nombreArchivo = "c:/carpeta/file.csv";
		
		Parseable<Collection<Producto>> parseable = new CSVFileParser(nombreArchivo, ";");

		Collection<Producto> productos = parseable.parsear();
		
		System.out.println(productos);
		
		FileConverter<List<String>> converter =  (FileConverter<List<String>>)(CSVFileParser)parseable;

		List<String> lineas = converter.convert(productos);
		
		//grabar en file las lineas de la coleccion de productos
		
		File target = new File("c:/carpeta/fileCopiado.csv"); 
		
		//escribe en texto
		try {
			
			if(!target.exists()) {
				Files.createFile(target.toPath());
			}
			
			FileWriter fw = new FileWriter(target);
			
			for(String linea : lineas) {
				fw.write(linea);
			}
			
			fw.close();
		} catch (IOException e) {
			System.err.println(e);
		}
		
		
		
	}

}
