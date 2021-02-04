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

@WebServlet("/EliminarProductoServlet")
public class EliminarProductoServlet extends HttpServlet {

	private ProductoService ps = new ProductoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String codigo = req.getParameter("codigo");
		
		//validacion
		if(codigo == null || codigo.trim().equals("")) {
			//redirect al listado
			resp.sendRedirect(req.getContextPath()+ "/jsp/listado.jsp");
		}
		
		try {
			this.ps.deleteProducto(codigo);
			
			req.setAttribute("exito", "Se ha eliminado el producto id=" + codigo);
		} catch (ServiceException e) {
			
			req.setAttribute("error", e.getCause().getMessage());
		}
		
		try {
			Collection<Producto> listado =  this.ps.obtenerProductos();
			req.setAttribute("listado", listado);
		} catch (ServiceException e) {
			req.setAttribute("error", e.getMessage());
			req.setAttribute("listado", new ArrayList<Producto>());
		}
		
		//redirect 
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/listado.jsp");
		rd.forward(req, resp);
	}
}
