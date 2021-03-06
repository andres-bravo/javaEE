package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//front controller
		String op=request.getParameter("op");
		String url="";
		switch(op) {
			case "toDatosCliente":
				url="datoscliente.html";
				break;
			case "doAltaCliente":
				url="AltaClienteAction";
				break;
			case "doRecuperarTemas":
				url="RecuperarTemasAction";
				break;
			case "doMostrarLibros":
				url="RecuperarLibrosAction";
				break;
			case "doLogin":
				url="LoginAction";
				break;
			case "doAgregarCarrito":
				//url="AgregarProductoCarrito?idLibro="+request.getParameter("idLibro");
				url="AgregarProductoCarrito";
				break;
			case "doQuitarProductoCarrito":
				//url="QuitarProductoCarrito?numarticulo="+request.getParameter("numarticulo")+"&selectTemas="+request.getParameter("selectTemas");
				url="QuitarProductoCarrito";
				break;
			case "doRealizarCompra":
				url="RealizarCompraAction";
				break;
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
