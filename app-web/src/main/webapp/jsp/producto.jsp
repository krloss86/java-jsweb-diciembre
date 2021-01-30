<html>
	<head>
	
	</head>
	<body>
		<form action="<%=request.getContextPath()%>/ProductoController" method="post">
			<table>
				<tr>
					<td>Codigo</td>
					<td><input type="text" name="codigo"></td>
				<tr>
				<tr>
					<td>Título</td>
					<td><input type="text" name="titulo"></td>
				<tr>
				<tr>
					<td>Precio</td>
					<td><input type="text" name="precio"></td>
				<tr>
				<tr>
					<td>Tipo Producto</td>
					<td>
						<select name="tipo">
							<option value="1">Celulares</option>
							<option value="2">Heladeras</option>
						</select>
					</td>
				<tr>
				<tr>
					<td><input type="submit" value="Grabar"></td>
				<tr>
			</table>			
		</form>
	</body>
</html>