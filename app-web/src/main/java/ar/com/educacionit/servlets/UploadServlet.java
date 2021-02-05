package ar.com.educacionit.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.clase10.CSVFileParser;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.enums.PantallasEnum;
import ar.com.educacionit.main.clase9.ClaveEnum;
import ar.com.educacionit.main.clase9.FileBuilder;
import ar.com.educacionit.main.clase9.Parseable;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
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
}
