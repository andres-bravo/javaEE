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
		<h1>ALUMNO NO ENCONTRADO ALTA DE NUEVOALUMNO</h1>		
		<c:set var="lcursos" value="${requestScope.lcursos}"/>
		<c:choose>
			<c:when test="${empty lcursos}">
				<p>No hay cursos para asignar al alumno cree primero cursos.</p>
				<a href="menuAdmin.html">Menú Principal</a><br/><br/>
			</c:when>
			<c:otherwise>
				<form action="Controller?op=doNuevoAlumno" method="POST">
				Nombre :<input type="text" name="nombre"/></br>
				Dni:<input type="text" name="dni"/></br>
				telefono :<input type="text" name="telefono"/></br>
				password :<input type="text" name="password"/></br>				
				Curso: <select id="selectCurso" name="selectCurso">
				<c:forEach var="curso" items="${lcursos}" varStatus="i">
    					<option value="${curso.getIdcurso()}">${curso.getCurso()}+${curso.getIdcurso()}</option>
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