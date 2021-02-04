<html>
<head>
<!-- agregamos css de boostrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>
</head>

<body>
	<%@include file="/jsp/navbar.jsp" %>
	
	<%@include file="/jsp/alerta.jsp"%>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12 col-lg-9 col-xl-6">
				<form action="<%=request.getContextPath()%>/NuevoProductoServlet" method="post">

					<div class="form-group">
						<label for="codigo">Código</label> <input name="codigo"
							type="text" class="form-control" id="codigo">
					</div>

					<div class="form-group">
						<label for="titulo">Título</label> <input name="titulo"
							type="text" class="form-control" id="titulo" placeholder="Título">
					</div>

					<div class="form-group">
						<label for="precio">Precio</label> <input name="precio"
							type="text" class="form-control" id="precio" placeholder="Precio">
					</div>
					<%-- ctr+shift+f --%>
					<div class="form-group">
						<label for="tipoProducto">Tipo Producto</label> <select
							name="tipoProducto" class="form-control" id="tipoProducto">
							<option value="1">Herramientas</option>
							<option value="2">Electrodomesticos</option>
						</select>
					</div>

					<button type="submit" class="btn btn-primary">Grabar</button>
				</form>
			</div>
		</div>
	</div>
</body>


</html>