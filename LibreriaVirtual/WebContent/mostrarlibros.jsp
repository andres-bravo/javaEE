<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,beans.Libro"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="libros" value="${requestScope.libros}"/>
	<c:choose>
		<c:when test="${empty libros}">
			<jsp:forward page="sinlibros.jsp"/>
		</c:when>
		<c:otherwise>
			<table border="1">
				<tr>
					<th>Titulo</th><th>Autor</th><th>Precio</th><th>Comprar</th>
				</tr>
				<c:forEach var="lib" items="${libros}" varStatus="i">			
					<tr>
						<td>${lib.getTitulo()}</td>
						<td>${lib.getAutor()}</td>
						<td>${lib.getPrecio()}</td>
						<td><a href="Controller?op=doAgregarCarrito&idLibro=${lib.getIsbn()}">Comprar</a>
					</tr>			
				</c:forEach>			
			</table>		
		</c:otherwise>		
	</c:choose>
	<br/>
	<c:set var="ventas" value="${sessionScope.carrito}"/>
	<c:choose>
		<c:when test="${empty carrito}">
			<h1>Carrito vacio</h1>
		</c:when>
		<c:otherwise>
			<table border="1">
				<tr>
				<th>Libro</th>
				</tr>
				<c:forEach var="ven" items="${ventas}" varStatus="i">			
					<tr>
						<td>${ven.getIdlibro()}</td>
					</tr>			
				</c:forEach>			
			</table>		
		</c:otherwise>		
	</c:choose>	
	<br/>
	<a href="Controller?op=doRecuperarTemas">Otro Tema</a>
</body>
</html>