<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,beans.Contacto, modelo.GestionContactos"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%GestionContactos gcontactos=new GestionContactos();
	List<Contacto> contactos=gcontactos.recuperarTodos();
	if(contactos==null||contactos.size()==0){%>
		<jsp:forward page="sincontactos.jsp"/>
	<%}else{%>
		<table border="1">
			<tr>
				<th>Nombre</th><th>Email</th><th>Teléfono</th>
			</tr>
			<%for(Contacto c:contactos){ %>
				<tr>
					
					<td><%=c.getNombre() %></td>
					<td><%=c.getEmail() %></td>
					<td><%=c.getTelefono() %></td>
				</tr>
			
			<%} %>
		
		</table>
			
	<%}%>
	<br/>
	<a href="inicio.html">Volver</a>
</body>
</html>