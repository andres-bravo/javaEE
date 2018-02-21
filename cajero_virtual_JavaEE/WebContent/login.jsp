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
		var numerocuenta=document.getElementById("numerocuenta");
		//comprueba si nuúmero de cuenta vacío.
		if(numerocuenta.value==""){
			alert("Debe introducir un número de cuenta");
			return false;
		}else{
			return true;
		}
		
	}
</script>
</head>
<body>
	<center>
		<H1>Cajero Virtual Gestión de Acceso</H1>
		<form action="Controller?op=doLogin" onsubmit="return comprobar();" method="POST">
			Numero de Cuenta:<input type="text" id="numerocuenta" name="numerocuenta" /><br/>
			<br/>
			<input type="submit" value="Enviar"/><br/>
		</form>
	</center>
${requestScope.mensaje}
</body>
</html>