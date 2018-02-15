<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%int totalvotos=1,votosSi=0, votosNo=0;
	  if (application.getAttribute("totalvotos")!=null){
		totalvotos=(Integer)application.getAttribute("totalvotos");
	  }
	  if (application.getAttribute("votosSi")!=null){
		votosSi=(Integer)application.getAttribute("votosSi");
	  }
	  if (application.getAttribute("votosNo")!=null){
		votosSi=(Integer)application.getAttribute("votosNo");
	  }
	%>
	<h1>Si<%=(100*votosSi)/totalvotos %></h1>
	<h1>No<%=(100*votosNo)/totalvotos %></h1>
	
	
	<h1>Total votos <%=totalvotos%> veces</h1>
	<h1>Total votos Si<%=votosSi %></h1>
	<h1>Total votos No<%=votosNo %></h1>
	<br/><br/><a href='votar.html'>Volver</a>
</body>
</html>