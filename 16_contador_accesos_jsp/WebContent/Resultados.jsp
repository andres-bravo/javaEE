<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ver Resultados</title>
</head>
<body>
	<%int valor=0;
	  if (session.getAttribute("contador")!=null){
		valor=(Integer)session.getAttribute("contador");
	  }
	%>
	<h1>Has entrado <%=valor%></h1>
	<br/><br/><a href='inicio.html'>Volver</a>
</body>
</html>