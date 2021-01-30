<%--DIRECTIVAS--%>
<%@page import="ar.com.educacionit.exceptions.ServiceException"%>
<%@page import="ar.com.educacionit.domain.Producto"%>
<%@page import="ar.com.educacionit.service.impl.ProductoServiceImpl"%>
<%@page import="ar.com.educacionit.service.ProductoService"%>

<%	
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
%>
	<%@include file="altaok.jsp" %>
<%
	}catch(ServiceException e) {
%>
	<%@include file="error.jsp" %>
<%
	}
	
%>