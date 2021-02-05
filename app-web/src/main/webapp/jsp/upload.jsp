<html>
	<head>
		<!-- boostrap -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	</head>
	<body>
		
		<%@include file="navbar.jsp" %>
		
		<div class="container-fluid">
			
			<div class="row">
			
				<div class="col-md-12 col-md-8 col-lg-9 col-xl-6">
					<form action="<%=request.getContextPath() %>/upload" method="post" enctype="multipart/form-data">
					 <div class="form-group">
					    <label for="exampleFormControlFile1">Archivo</label>
					    <input type="file" name="file" class="form-control-file" id="exampleFormControlFile1">
					  </div>
					  <button type="submit" class="btn btn-primary">Subir</button>
					</form>
				</div>
				
			</div>	
		</div>
	</body>
</html>
