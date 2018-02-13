
<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>libros</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
    
<c:set var="libros" value="${requestScope.libros}"/>
<c:choose>
	<c:when test="${!empty libros}">
		<table border="1">
		    <tr><th>Titulo</th><th>Autor</th><th>Precio</th><th></th></tr>		    	
		    	<c:forEach var="lib" items="${libros}">
		    		<tr>
		    			<td>${lib.titulo}</td>
						<td>${lib.autor}</td>
						<td>${lib.precio}</td>
						<td><a href="Controller?op=doAgregarCarrito&tema=${param.tema}&isbn=${lib.isbn}">Agregar</a></td>
					</tr>		    	
		    	</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h2>No hay libros</h2>
	</c:otherwise>
</c:choose>
<br/><br/>
<a href="Controller?op=doTemas">Otro Tema</a>
<br/><br/>
<c:if test="${! empty sessionScope.carrito}">
<h1>Carrito</h1>
<table border="1">
    <tr><th>Titulo</th><th>Autor</th><th>Precio</th><th></th></tr>
    <c:set var="libs" value="${sessionScope.carrito}"/>
            <c:forEach var="l" items="${libs}">
            	<td>${l.titulo}</td>
				<td>${l.autor}</td>
				<td>${l.precio}</td>
				<td><a href="Controller?op=doEliminarCarrito&tema=${param.tema}&isbn=${l.isbn}">Eliminar</a></td></tr>
            </c:forEach>
</table>
<br/><br/>


	<a href="Controller?op=doComprar&tema=${param.tema}">Realizar compra</a>
</c:if>
</body>
</html>