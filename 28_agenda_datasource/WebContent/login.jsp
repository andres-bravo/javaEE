<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="Controller?op=doLogin" method="POST">		
			Usuario:<input type="text" name="user"/><br/>
			Contraseņa:<input type="password" name="pwd"/><br/>
			<input type="submit" value="Enviar"/><br/>
		</form>
		<br/>
		<%if(request.getAttribute("mensaje")!=null){ %>
			<%=request.getAttribute("mensaje")%>
		<%} %>
	
	</center>

</body>
</html>