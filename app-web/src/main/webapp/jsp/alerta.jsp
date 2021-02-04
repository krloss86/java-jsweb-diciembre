<% if(request.getAttribute("error") != null) {%>
	<div class="row">
		<div class="col-12">
			<div class="alert alert-danger" role="alert">
		  		<%=request.getAttribute("error") %>
			</div>
		</div></div>
	</div>
<% }%>
<% if(request.getAttribute("exito") != null) {%>
	<div class="row">
		<div class="col-12">
			<div class="alert alert-success" role="alert">
		  		<%=request.getAttribute("exito") %>
			</div>
		</div></div>
	</div>
<% }%>