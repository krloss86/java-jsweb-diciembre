package ar.com.educacionit.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.enums.PantallasEnum;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.impl.ProductoServiceImpl;

@WebServlet("/ActualizarProductoServlet")
public class ActualizarProductoServlet extends HttpServlet {

	private ProductoService ps = new ProductoServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//tomar los datos desde editar.jsp
		String id = req.getParameter("id");
		String codigo = req.getParameter("codigo");
		String titulo = req.getParameter("titulo");
		Float precio = Float.parseFloat(req.getParameter("precio"));
		Long tipo = Long.parseLong(req.getParameter("tipoProducto"));
		
		//validaciones!!!
		
		Long idL = Long.parseLong(id);
		
		Producto productoAActualizar = new Producto(titulo, idL, precio, codigo, tipo);
		
		String target = "/jsp/listado.jsp";
		try {
			this.ps.updateProducto(productoAActualizar);
			
			req.setAttribute("exito", "Se ha actualizado exitorsamente el producto id:" + id);
			
			//recargo la lista de productos!
			Collection<Producto> productos = this.ps.obtenerProductos();
			
			req.setAttribute(PantallasEnum.LISTADO.getPantalla(), productos);
		} catch (ServiceException e) {
			req.setAttribute("error", e.getCause().getMessage());
			req.setAttribute("producto", productoAActualizar);
			target = "/jsp/editar.jsp";
		}
		
		//redireccionar!
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
		rd.forward(req, resp);

	}
}
