<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,beans.Tema"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="Controller?op=doMostrarLibros" method="POST">		
	<c:set var="temas" value="${requestScope.temas}"/>
	<c:choose>
		<c:when test="${empty temas}">
			<jsp:forward page="sintemas.jsp"/>
		</c:when>
		<c:otherwise>
			<select name="selectTemas">
				<c:forEach var="tema" items="${temas}" varStatus="i">
    			<option value="${tema.getIdTema()}">${tema.getTema()}</option>
    			</c:forEach>
    			<option value=-1>Todos</option>
			</select>
			<input type="submit" value="Enviar"/><br/>
		</form>
		<br/>
		</c:otherwise>
		
	</c:choose>
	</center>

</body>
</html>