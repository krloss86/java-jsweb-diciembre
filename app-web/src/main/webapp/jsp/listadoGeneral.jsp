<%@page import="java.util.Collection"%>
<%@page import="ar.com.educacionit.domain.Producto"%>
<%@page import="java.util.List"%>
<html>

<head>
	<!-- boostrap -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>

<body>
	<%@include file="navbar.jsp" %>
	<div class="container">
		<div class="row">
			<div class="alert alert-success">Productos Dados de alta</div>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">TÍTULO</th>
						<th scope="col">PRECIO</th>
						<th scope="col">CODIGO</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<%
						Collection<Producto> productos = (Collection<Producto>)request.getAttribute("listadoOK");
					%>
					
					<% for(Producto producto : productos) {%>
						<tr>
							<th scope="row"><%out.print(producto.getId());%></th>
							<th scope="row"><%out.print(producto.getTitulo());%></th>
							<th scope="row"><%out.print(producto.getPrecio());%></th>
							<th scope="row"><%out.print(producto.getCodigo());%></th>
							<th>
								<button type="button" class="btn btn-outline-primary">Editar</button>
								<button type="button" class="btn btn-outline-secondary">Eliminar</button>
							</th>
						</tr>
					<%} %>
					<tr>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="row">
			<div class="alert alert-danger">Productos Con errores</div>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">DESCRIPCIÓN</th>
						<th scope="col">PRECIO</th>
						<th scope="col">CODIGO</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<%
						Collection<Producto> productosFail = (Collection<Producto>)session.getAttribute("listadoFail");
					%>
					
					<% for(Producto producto : productosFail) {%>
						<tr>
							<th scope="row"><%out.print(producto.getId());%></th>
							<th scope="row"><%out.print(producto.getTitulo());%></th>
							<th scope="row"><%out.print(producto.getPrecio());%></th>
							<th scope="row"><%out.print(producto.getCodigo());%></th>
							<th>
								<button type="button" class="btn btn-outline-primary">Editar</button>
								<button type="button" class="btn btn-outline-secondary">Eliminar</button>
							</th>
						</tr>
					<%} %>
					<tr>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="row">
			<div class="col-6">
				<form class="form-inline" action="<%=request.getContextPath()%>/GenerarArchivoErrorServlet" method="post" target="_new">
					<select class="form-control" name="formato">
					  <option value="csv">CSV</option>
					  <option value="xls">XSL</option>
					</select>
				  	<button type="submit" class="btn btn-primary">Generar Listado De Error</button>
				</form>
			</div>
		</div>
		</div>
	</body>
</html>