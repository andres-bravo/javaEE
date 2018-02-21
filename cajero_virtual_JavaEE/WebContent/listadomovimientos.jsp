<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,beans.Movimiento"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
	<c:set var="lmovimientos" value="${requestScope.lmovimientos}"/>
	<c:choose>
		<c:when test="${empty lmovimientos}">
			<jsp:forward page="sinmovimientos.jsp"/>
		</c:when>
		<c:otherwise>
			<H1>Listado de Movimientos</H1>
			<table border="1">
				<tr>
					<th>Cuenta</th><th>Cantidad</th><th>Fecha</th><th>Operacion</th>
				</tr>
				<c:forEach var="mov" items="${lmovimientos}" varStatus="i">			
					<tr>
						<td>${mov.getIdCuenta()}</td>
						<td>${mov.getCantidad()}</td>
						<td>${mov.getFecha().toString()}</td>
						<td>${mov.getOperacion()}</td>
					</tr>			
				</c:forEach>			
			</table>		
		</c:otherwise>		
	</c:choose>
	<br/>
	<br/>
		
	<a href="menuprincipal.html">Menú Principal</a>
	</center>
</body>
</html>