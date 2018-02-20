<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,beans.Curso,beans.PreguntaRespuestas"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Realizar Examen</h1>		
		<c:set var="lexamen" value="${requestScope.lexamen}"/>
		<c:set var="alumno" value="${sessionScope.alumno}"/>
		<c:choose>
			<c:when test="${empty lexamen}">
				<p>No hay preguntas para realizar el examen contacte con el Administrador</p>
				<a href="menuAlumno.html">Menú Principal</a><br/><br/>
			</c:when>
			<c:otherwise>
				<form action="Controller?op=doCorregirExamen&idcurso=${param.selectCurso}" method="POST"></br>							
				<c:forEach var="preguntaRespuestas" items="${lexamen}" varStatus="i">
    					<H1>Pregunta ${i.getCount()} : ${preguntaRespuestas.getPregunta().getPregunta()}</H1></br>
    					<p>select:${param.selectCurso}</p>
    					<c:forEach var="respuesta" items="${preguntaRespuestas.getLrespuestas()}" varStatus="j">
    						<p>Respuesta ${i.getCount()}.${j.getCount()} ${respuesta.getRespuesta()}</p></br>   						
    					</c:forEach>
    					<p>SeleccionarRespuesta:</p> <select id="selectRespuesta${i.getCount()}" name="selectRespuesta${i.getCount()}">
    						<c:forEach var="respuesta" items="${preguntaRespuestas.getLrespuestas()}" varStatus="k">
    							<option value="${respuesta.getIdrespuesta()}">${i.getCount()}.${k.getCount()}</option>						
    						</c:forEach>
    					</select></br>
    				</c:forEach>
    				</br>
				<input type="submit" value="RealizarExamen"/>
				</form>
				<br/>
			</c:otherwise>	
		</c:choose>
	</center>
</body>
</html>