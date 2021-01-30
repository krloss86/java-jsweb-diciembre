package ar.com.educacionit.clase11;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.impl.ProductoServiceImpl;

@WebServlet("/ProductoController")
public class ProductoController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		String titulo = request.getParameter("titulo");
		Float precio = Float.parseFloat(request.getParameter("precio"));
		Long tipo = Long.parseLong(request.getParameter("tipo"));
		
		ProductoService ps = new ProductoServiceImpl();
		Producto p = new Producto(titulo,precio,codigo,tipo);
		
		try {
			Producto pcreado = ps.crearProducto(p);
			//guardo el dato a mostrar luego en "la otra jsp"
			request.setAttribute("pcreado",pcreado);
			
			getServletContext()
				.getRequestDispatcher("/jsp/altaok.jsp")
				.forward(request, response);		
		}catch(ServiceException e) {
			getServletContext()
			.getRequestDispatcher("/jsp/error.jsp")
			.forward(request, response);
		}	
	}
}
