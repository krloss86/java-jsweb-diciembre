package ar.com.educacionit.clase10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainFile3 {

	public static void main(String[] args) throws IOException {
		//c:/carpeta
		
		File file = new File("c:/carpeta/imagen.png");
		File fileDestino = new File("c:/carpeta/imagenCopia.png");
		
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(file);
			os = new FileOutputStream(fileDestino);
			
			byte[] buffer = new byte[1024];
			
			int lengh;
			
			while((lengh = is.read(buffer)) > 0) {
				os.write(buffer,0, lengh);			
			}
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			is.close();
			os.close();
		}
	
	}

}
