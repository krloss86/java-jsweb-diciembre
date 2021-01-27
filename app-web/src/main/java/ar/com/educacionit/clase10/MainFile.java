package ar.com.educacionit.clase10;

import java.io.File;

public class MainFile {

	public static void main(String[] args) {
		//c:/carpeta
		
		File carpeta = new File("c:/carpeta");
		
		//si existe
		boolean existeCarpeta = carpeta.exists();
		
		if(!existeCarpeta) {
			//crear la carpeta
			carpeta.mkdir();
		}
		
		
		boolean esCarpeta = carpeta.isDirectory();
		boolean esFile = carpeta.isFile();
	}

}
