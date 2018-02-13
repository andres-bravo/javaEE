<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList,beans.Producto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%ArrayList<Producto> carrito=null;
	  if (session.getAttribute("contador")!=null){
		carrito=(ArrayList<Producto>)session.getAttribute("carrito");%>
		<table border="1">
		<tr>
			<th></th><th>Nombre</th><th>Precio</th><th>Categoría</th>
		</tr>
		<%for(int i=0;i<carrito.size();i++){ %>
			<tr>
				<td><a href="Borrar?numarticulo=<%=i%>">Eliminar</a></td>
				<td><%carrito.get(i).getNombre();%></td>
				<td><%carrito.get(i);%></td>
				<td><%carrito.get(i).getNombre();%></td>
			</tr>
		<%}%>
	   </table>
	   <%}
	   else{%><h1>No hay carrito</h1><%}%>
</body>
</html>