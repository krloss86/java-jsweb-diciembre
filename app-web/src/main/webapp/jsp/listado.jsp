<%@page import="ar.com.educacionit.domain.Producto"%>
<%@page import="java.util.Collection"%>
<%@page import="ar.com.educacionit.enums.PantallasEnum"%>

<html>

	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		
		<script type="text/javascript">
			//codigo java script
			function eliminarProducto(codigo) {
				let confirma = confirm("¿Desea eliminar el producto codigo="+ codigo);
				if(confirma) {
					window.location = '<%=request.getContextPath()%>/EliminarProductoServlet?codigo=' + codigo;
				}
				return false;
			}			
		</script>
		
	</head>
	
	<body>
		<%@include file="/jsp/navbar.jsp" %>
		
		<%@include file="/jsp/alerta.jsp"%>
		
		<div class="container-fluid">
		
			<div class="row">
			
				<div class="col-12">
					<table class="table">
					  <thead>
					    <tr>
					      <th scope="col">ID</th>
					      <th scope="col">Código</th>
					      <th scope="col">Título</th>
					      <th scope="col">Precio</th>
					      <th scope="col">Tipo Producto</th>
					      <th> &nbsp;</th>
					    </tr>
					  </thead>
					  <tbody>
					  <% Collection<Producto> listado = (Collection<Producto>)request.getAttribute(PantallasEnum.LISTADO.getPantalla()); %>
					    <%for(Producto producto : listado) {%>
						    <tr>
						      <th scope="row"> <%=producto.getId()%> </th>
						      <td> <% out.print(producto.getCodigo()); %> </td>
						      <td> <% out.print(producto.getTitulo()); %> </td>
						      <td> <%= producto.getPrecio() %> </td>
						      <td> <%=producto.getTipoProducto() %></td>
						      <td> 
									<a href="<%=request.getContextPath() %>/CargarParaEditarProductoServlet?codigo=<%=producto.getCodigo() %>" class="btn btn-primary btn-md active" role="button" aria-pressed="true">Editar</a>
									<button onclick="eliminarProducto('<%=producto.getCodigo()%>')" type="button" class="btn btn-danger">Eliminar</button>
						      </td>
						    </tr>
					    <%} %>
					  </tbody>
					  <tfoot>
					  	<tr>
					  		<td colspan="3">&nbsp;</td>
					  		<td><%=request.getAttribute("sumaTotal") %> </td>					  		
					  	</tr>
					  </tfoot>
					</table>						
				</div>
			</div>
		</div>
	</body>
</html>