<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,beans.Contacto, modelo.GestionContactos"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="contactos" value="${requestScope.contactos}"/>
	<c:choose>
		<c:when test="${empty contactos}">
			<jsp:forward page="sincontactos.jsp"/>
		</c:when>
		<c:otherwise>
			<table border="1">
				<tr>
					<th></th><th>Nombre</th><th>Email</th><th>Teléfono</th>
				</tr>
				<c:forEach var="con" items="${contactos}" varStatus="i">			
					<tr>
						<td><a href="Controller?op=doEliminar&idContacto=${con.idContacto}">Eliminar</a>
						<td>${con.nombre}</td>
						<td>${con.email}</td>
						<td>${con.telefono}</td>
					</tr>
				
				</c:forEach>
			
			</table>
		
		</c:otherwise>
		
	</c:choose>
	<br/>
	<a href="Controller?op=toInicio">Volver</a>
</body>
</html>