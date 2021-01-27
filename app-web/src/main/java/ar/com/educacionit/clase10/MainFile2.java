package ar.com.educacionit.clase10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainFile2 {

	public static void main(String[] args) {
		//c:/carpeta
		
		File file = new File("c:/carpeta/texto.txt");
		
		//si existe
		boolean existeCarpeta = file.exists();
		
		try {
			FileReader fr = new FileReader(file);
			int valor;
			while((valor = fr.read()) != -1) {
				System.out.print((char)valor);
			}
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
