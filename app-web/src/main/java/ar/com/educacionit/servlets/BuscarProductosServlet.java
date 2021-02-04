package ar.com.educacionit.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.impl.ProductoServiceImpl;

@WebServlet("/BuscarProductosServlet")
public class BuscarProductosServlet extends HttpServlet {

	private ProductoService ps = new ProductoServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String claveBusqueda = req.getParameter("claveBusqueda");
		
		//validaciones!!!
		
		try {
			Collection<Producto> listado = this.ps.buscarProducto(claveBusqueda);
			req.setAttribute("listado", listado);
		} catch (ServiceException e) {
			req.setAttribute("error", e.getCause().getMessage());
			req.setAttribute("listado", new ArrayList<>());
		}
		
		//redirect!
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/listado.jsp");
		rd.forward(req, resp);
	}
}
