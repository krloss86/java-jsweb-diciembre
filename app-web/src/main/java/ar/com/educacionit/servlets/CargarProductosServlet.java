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
import ar.com.educacionit.enums.PantallasEnum;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.impl.ProductoServiceImpl;

@WebServlet("/CargarProductosServlet")
public class CargarProductosServlet extends HttpServlet {

	private ProductoService ps = new ProductoServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//tomar desde la sesion los datos parseados!!
		
		Collection<Producto> productosEnSesion = (Collection<Producto>)req.getSession().getAttribute(PantallasEnum.LISTADO.getPantalla());
		
		Collection<Producto> productosOK = new ArrayList<Producto>();
		Collection<Producto> productosFail = new ArrayList<Producto>();
		
		for(Producto producto : productosEnSesion) {
			try {
				this.ps.crearProducto(producto);
				productosOK.add(producto);
			} catch (ServiceException e) {
				productosFail.add(producto);
			}
		}
		
		//request OK
		req.setAttribute("listadoOK", productosOK);
		
		//sesion FAIL
		req.getSession().setAttribute("listadoFail", productosFail);
		
		//redirect
		//redireccionar!
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/listadoGeneral.jsp");
		rd.forward(req, resp);

	}
}
