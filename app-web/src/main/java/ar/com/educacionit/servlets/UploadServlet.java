package ar.com.educacionit.servlets;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ar.com.educacionit.clase10.CSVFileParser;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.enums.PantallasEnum;
import ar.com.educacionit.main.clase9.ClaveEnum;
import ar.com.educacionit.main.clase9.FileBuilder;
import ar.com.educacionit.main.clase9.Parseable;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

	/*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String fileName = "C:\\Users\\CX PC\\Desktop\\clase13.csv";
		
		String target = "/jsp/listado.jsp";
		
		int idx = fileName.lastIndexOf(".");
		String name = fileName.substring(0, idx);
		String type = fileName.substring(idx+1, fileName.length());
		
		//ClaveEnum claveEnum = ClaveEnum.getEnumByClave(type);
		
		//Parseable<Collection<Producto>> parseable2 = FileBuilder.getParseable(claveEnum);
		
		Parseable<Collection<Producto>> parseable = new CSVFileParser(fileName, ";");

		Collection<Producto> productos = parseable.parsear();
		
		req.setAttribute(PantallasEnum.LISTADO.getPantalla(), productos);
		
		//redirect
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
		rd.forward(req, resp);
	}
	*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Part filePart = req.getPart("file");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
				
		int idx = fileName.lastIndexOf(".");
		String name = fileName.substring(0, idx);
		String type = fileName.substring(idx+1, fileName.length());
		
		ClaveEnum claveEnum = ClaveEnum.getEnumByClave(type);
		
		Parseable<Collection<Producto>> parseable = new CSVFileParser(type, filePart, ";");
		
		Collection<Producto> productos = parseable.parsear();
		
		//guardamos en sesion los datos parseados
		//req.setAttribute(PantallasEnum.LISTADO.getPantalla(), productos);
		req.getSession().setAttribute(PantallasEnum.LISTADO.getPantalla(), productos);
		
		String target = "/jsp/preview.jsp";
		
		//redirect
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
		rd.forward(req, resp);
	}
}
