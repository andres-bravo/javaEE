<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<%-- 
	<c:set var="valor" value="0"/>
	<c:set var="global" value="0"/>
	<c:if test="${!empty sessionScope.contador}">
		<c:set var="valor" value="${sessionScope.contador}"/>
	</c:if>
	<c:if test="${!empty applicationScope.global}">
		<c:set var="global" value="${applicationScope.global}"/>
	</c:if>
	--%>
	<h1>Has entrado ${sessionScope.contador} veces</h1>
	<h1>Total de entradas ${applicationScope.global} veces</h1>
	<h1>Fecha última visita: ${cookie.visita.value }</h1>
	<br/>
	<a href="inicio.html">Inicio</a>
</body>
</html>