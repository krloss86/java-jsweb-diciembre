package ar.com.educacionit.servlets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.clase10.CSVFileParser;
import ar.com.educacionit.clase10.FileConverter;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.main.clase9.Parseable;

@WebServlet("/GenerarArchivoErrorServlet")
public class GenerarArchivoErrorServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		String formatoSalida = req.getParameter("formato");
		
		String filename = "listado-producto-error";
		
		String fileOutput = "c:" + File.separator + "desarrollo" + File.separator + "clase13" + File.separator
				+ filename + "."+ formatoSalida;
		
		File outputFile = new File(fileOutput);
		
		if(!outputFile.exists()) {
			//creamos
			Files.createFile(outputFile.toPath());
		}
		
		FileWriter fr = new FileWriter(outputFile);
		
		//bajar la coleccion desde la sesion
		Collection<Producto> productosFailEnSesion = (Collection<Producto>)req.getSession().getAttribute("listadoFail");
		
		//asumir siempre CSV
		Parseable<Collection<Producto>> parseable = new CSVFileParser(filename, ";");
		FileConverter<List<String>> converter =  (FileConverter<List<String>>)(CSVFileParser)parseable;
		List<String> lineas = converter.convert(productosFailEnSesion);
		//1;codigo;titulo;precio;tipo
		for(String linea : lineas ) {
			fr.write(linea);
		}
		
		fr.close();
		
		// logica para descargar el file

		resp.setContentType("text/csv");
		resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "." + formatoSalida + "\" ");
		// escribir el contenido en el response
		try {
			OutputStream outputStream = resp.getOutputStream();

			byte[] byteDelArchivoGenerado = Files.readAllBytes(outputFile.toPath());
			outputStream.write(byteDelArchivoGenerado);

			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			resp.getWriter().print("No se ha podido generar el archivo, por favor reintente");
		}
	}
}
