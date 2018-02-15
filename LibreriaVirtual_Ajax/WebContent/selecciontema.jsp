<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,beans.Tema"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function lanzarPeticionLibros(){
		//Para ver el JSON
		//$.get("Controller",{op:"doMostrarLibros", selectTemas: $("#selectTemas").val()});
		//Lanzo peticion http desde javascript url, json(Con parametros)
		$.get("Controller",{op:"doMostrarLibros", selectTemas: $("#selectTemas").val()}, function(resultado){manipularRespuestaLibros(resultado)});
	}
	function eliminarPeticion(idContacto){
		//Lanzo peticion http desde javascript url, json(Con parametros)
		$.get("Controller",{op:"doEliminar",idContacto:idContacto}, function(resultado){manipularRespuesta(resultado)});
	}
	
	function manipularRespuestaLibros(resultado){
		//construimos una tabla HTML con los datos
		//del array JSON recibido en resultado
		//primero parseamos el JSON
		var res=$.parseJSON(resultado);
		var tabla="<table border='1'><tr><th>Titulo</th><th>Autor</th><th>Precio</th><th></th></tr>";
		for (var i=0;i<res.length;i++){
			tabla+="<tr>";
			//tabla+="<td><a href='javascript:eliminarPeticion("+res[i].idContacto+")'>Eliminar</a></td>"
			tabla+="<td>"+res[i].titulo+"</td>";
			tabla+="<td>"+res[i].autor+"</td>";
			tabla+="<td>"+res[i].precio+"</td>";
			tabla+="<td><a href='javascript:lanzarPeticionAgregarCarrito("+res[i].idLibro+")'>Comprar</a></td>";
			tabla+="</tr>"
		}
		tabla+="</table>"
		//La volcamos dentro de la divisi�n div con la propiedad html
		$("#libros").html(tabla)
	}
	
	function lanzarPeticionAgregarCarrito(idLibro){
		$.get("Controller",{op:"doAgregarCarrito", idLibro: idLibro}, function(resultado){manipularRespuestaCarrito(resultado)});	
	}
	function lanzarPeticionQuitarCarrito(numarticulo){
		$.get("Controller",{op:"doQuitarProductoCarrito", numarticulo: numarticulo}, function(resultado){manipularRespuestaCarrito(resultado)});	
	}
	function manipularRespuestaCarrito(resultado){
		//construimos una tabla HTML con los datos
		//del array JSON recibido en resultado
		//primero parseamos el JSON
		var res=$.parseJSON(resultado);
		if (res.length>0){
			var tabla="<table border='1'><tr><th>Titulo</th><th>Autor</th><th>Precio</th><th></th></tr>";
			for (var i=0;i<res.length;i++){
				tabla+="<tr>";
				//tabla+="<td><a href='javascript:eliminarPeticion("+res[i].idContacto+")'>Eliminar</a></td>"
				tabla+="<td>"+res[i].titulo+"</td>";
				tabla+="<td>"+res[i].autor+"</td>";
				tabla+="<td>"+res[i].precio+"</td>";
				tabla+="<td><a href='javascript:lanzarPeticionQuitarCarrito("+i+")'>Comprar</a></td>";
				tabla+="</tr>"
			}
			tabla+="</table>";
			//Enlace realizar compra
			//Hacerlo con Json
			//tabla+="<a href="Controller?op=doRealizarCompra">Realizar Compra</a>""
			
		}else{
			tabla="<h1>Carrito vacio</h1>";			
		}
		//La volcamos dentro de la divisi�n div con la propiedad html
		$("#carrito").html(tabla);
	}
</script>
</head>
<body>
	<center>
		<form action="javascript:lanzarPeticionLibros()" method="POST">		
	<c:set var="temas" value="${requestScope.temas}"/>
	<c:choose>
		<c:when test="${empty temas}">
			<jsp:forward page="sintemas.jsp"/>
		</c:when>
		<c:otherwise>
			<select id="selectTemas" name="selectTemas">
				<c:forEach var="tema" items="${temas}" varStatus="i">
    			<option value="${tema.getIdTema()}">${tema.getTema()}</option>
    			</c:forEach>
    			<option value=-1>Todos</option>
			</select>
			<input type="submit" value="Enviar"/><br/>
		</form>
		<br/>
		</c:otherwise>
		
	</c:choose>
	</center>
	<br/><br/><br/>
	<div id="libros">
	<center>
	</center>
	</div>
	<br/><br/><br/>
	<div id="carrito">
		<h1>Carrito vacio</h1>
	</div>
	

</body>
</html>