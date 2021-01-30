<%@page import="ar.com.educacionit.domain.Producto"%>

<%
	//obtener el dato que guarda la jsp anterior
	Producto producto = (Producto)request.getAttribute("pcreado");
%>
<html>

	<head>
		
	</head>
	<body>
	
		<table>
			<tr>
				<td>
					Se ha creado exitosamente el producto: id = <%=producto.getId() %>
				</td>
			</tr>
		</table>
	</body>
</html>