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
		<h1>ALUMNO ENCONTRADO ASIGNAR CURSO AL ALUMNO</h1>		
		<c:set var="lcursos" value="${requestScope.lcursos}"/>
		<c:set var="alumno" value="${requestScope.alumno}"/>
		<c:choose>
			<c:when test="${empty lcursos}">
				<p>No hay cursos para asignar al alumno cree primero cursos.</p>
				<a href="menuAdmin.html">Men� Principal</a><br/><br/>
			</c:when>
			<c:otherwise>
				<form action="Controller?op=doAsignarCursoAlumno&idalumno=${alumno.getId_alumno()}" method="POST">
				Nombre :${alumno.getNombre()}</br>
							
				Curso: <select id="selectCurso" name="selectCurso">
				<c:forEach var="curso" items="${lcursos}" varStatus="i">
    					<option value="${curso.getIdcurso()}">${curso.getCurso()}</option>
    				</c:forEach>
				</select></br>
				<input type="submit" value="AltaAlumno"/>
				</form>
				<br/>
			</c:otherwise>	
		</c:choose>
	</center>
</body>
</html>