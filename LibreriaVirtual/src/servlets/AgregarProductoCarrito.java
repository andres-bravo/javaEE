package servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Venta;

/**
 * Servlet implementation class AgregarProductoCarrito
 */
@WebServlet("/AgregarProductoCarrito")
public class AgregarProductoCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//obtenemos/creamos HttpSession
		HttpSession s=request.getSession();
		//Recogemos los parametros del formulario
		Venta v=new Venta(0,(Integer)s.getAttribute("clientesession"),Integer.parseInt(request.getParameter("idLibro")),
				LocalDateTime.now(),request.getParameter("libro"),request.getParameter("autor"),
				Double.parseDouble(request.getParameter("precio")));

		//Comprobamos si est� establecido el par�metro de session del carrito
		ArrayList<Venta> carrito = (ArrayList<Venta>)s.getAttribute("carrito");
		//Si el carrito estaba vacio lo creo nuevo
		if (carrito==null){
			carrito = new ArrayList();
		}
		//A�ado articulo al carrito
		carrito.add(v);
		//Actualizo la session con el carrito
		s.setAttribute("carrito", carrito);
		//Hago un forward al MostrarLibros
		//request.getRequestDispatcher("Controller?op=doMostrarLibros?selectTemas=2");
		request.getRequestDispatcher("RecuperarLibrosAction?selectTemas="+Integer.parseInt(request.getParameter("selectTemas"))).forward(request, response);
	}
}
