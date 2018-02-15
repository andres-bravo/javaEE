<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>mostrarresultados</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR"
	content="Rational® Application Developer for WebSphere® Software">
</head>
<body>
	<%int si=(Integer)application.getAttribute("si");
	int no=(Integer)application.getAttribute("no"); 
	if(si==0&&no==0){%>
		<jsp:forward page="sinvotos.jsp"/>
			
	<%} %>
	<h2>Si <%=si*100/(si+no)%> %</h2>
	<h2>No <%=no*100/(si+no)%> %</h2>
	<br/><br/><h3>Total votos <%=(si+no)%></h3>
	
        <br/>
        <a href="votar.html">inicio</a>
</body>
</html>