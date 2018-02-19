<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,beans.Curso"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>SELECCIONAR EL CURSO PARA REALIZAR EL EXAMEN</h1>		
		<c:set var="lcursos" value="${requestScope.lcursos}"/>
		<c:set var="alumno" value="${sessionScope.alumno}"/>
		<c:choose>
			<c:when test="${empty lcursos}">
				<p>No hay cursos para realizar el examen matrículese en un nuevo curso.</p>
				<a href="menuAlumno.html">Menú Principal</a><br/><br/>
			</c:when>
			<c:otherwise>
				<form action="Controller?op=doMostrarExamen" method="POST"></br>							
				Curso: <select id="selectCurso" name="selectCurso">
				<c:forEach var="curso" items="${lcursos}" varStatus="i">
    					<option value="${curso.getIdcurso()}">${curso.getCurso()}</option>
    				</c:forEach>
				</select></br>
				<input type="submit" value="RealizarExamen"/>
				</form>
				<br/>
			</c:otherwise>	
		</c:choose>
	</center>
</body>
</html>