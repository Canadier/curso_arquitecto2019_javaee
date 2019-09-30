<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Producto,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	    List<Producto> cesta = (ArrayList<Producto>) session.getAttribute("cesta");
	    if(cesta==null){%>
		<jsp:forward page="sincarrito.html"/>
		
	<%}else{%>
	
	<div class='container'>
		
		<table class='table table-striped table-bordered'>
			<thead> 
				<tr> 
					<th>Producto</th> 
					<th>Unidades</th> 
					<th>Precio</th> 
				</tr> 
			</thead> 
			<tbody> 
				<%for (int i=0; i<cesta.size();i++ ) {%>
					 <tr>
					 	<td><%=cesta.get(i).getDescripcion()%></td>
					 	<td><%=cesta.get(i).getUnidades()%></td>
					 	<td><%=cesta.get(i).getPrecio()%></td>
					 </tr>
				<%}%>
			</tbody>
		</table>
		
		<a href='opciones.html' class='btn btn-primary' style='width:20%'> Volver </a>
		<a href='Vaciar' class='btn btn-warning' style='width:20%'> Vaciar Carrito</a>
		<a href='Cerrar' class='btn btn-danger' style='width:20%'> Desconectar</a>	
			
	</div>

   <%}%>
   
</body>
</html>