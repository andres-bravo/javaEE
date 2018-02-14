<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	function comprobar(){
		//obtenemos referencia a los objetos etiqueta de texto
		var caja1=document.getElementById("us");
		var caja2=document.getElementById("pw");
		//comprueba si alguna caja está vacía
		if(caja1.value==""||caja2.value==""){
			alert("Debe introducir un valor");
			return false;
		}else{
			return true;
		}
		
	}

</script>
</head>
<body>
	<center>
		<form action="Controller?op=doLogin" onsubmit="return comprobar();" method="POST">
			Usuario:<input id="us" type="text" name="user" /><br/>
			Contraseña:<input id="pw" type="password" name="pwd"/><br/>			
			<br/>
			<input type="submit" value="Enviar"/><br/>
		</form>
		<br/>
		<a href="Controller?op=toRegistro">Registrese</a>
	</center>
${requestScope.mensaje}
</body>
</html>