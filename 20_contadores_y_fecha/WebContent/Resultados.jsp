<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ver Resultados</title>
</head>
<body>
	<%
	//recogida de la cookie
	String fecha="";
	//Miramos si hay Cookies sino daría un fallo
	Cookie[] todascookies=request.getCookies();
	if (todascookies!=null){
		for(Cookie ck:todascookies){
			if (ck.getName().equals("visita")){
				fecha=ck.getValue();
			}
		}
	}
	int valor=0,global=0;
	if (session.getAttribute("contador")!=null){
		valor=(Integer)session.getAttribute("contador");
	}
	if (application.getAttribute("global")!=null){
		global=(Integer)application.getAttribute("global");
	}
	%>
	<h1>Has entrado <%=valor%> veces</h1>
	<h1>Total entradas <%=global%> veces</h1>
	<h1>Fecha última visita: <%=fecha%></h1>
	<br/><br/><a href='inicio.html'>Volver</a>
</body>
</html>