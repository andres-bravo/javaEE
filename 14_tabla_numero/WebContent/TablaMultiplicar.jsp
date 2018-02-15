<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
	<%int n=Integer.parseInt(request.getParameter("num"));%>
	<table border="1">
	<h1>Tabla del <%=n%></h1>
	<%for(int i=1;i<=10;i++){%>
		<tr>
			<td>
				<%=n%>x<%=i%>
			</td>
			<td>
				<%=n*i%>
			</td>
		</tr>
	<%}%>
	</table>
	</center>
</body>
</html>