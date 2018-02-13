package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Producto;

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
		Producto p=new Producto(request.getParameter("nombre"), 
				Double.parseDouble(request.getParameter("precio")), 
				request.getParameter("categoria"));
		//Comprobamos si está establecido el parámetro de session del carrito
		ArrayList<Producto> carrito = (ArrayList<Producto>)s.getAttribute("carrito");
		//Si el carrito estaba vacio lo creo nuevo
		if (carrito==null){
			carrito = new ArrayList();
		}
		//Añado articulo al carrito
		carrito.add(p);
		//Actualizo la session con el carrito
		s.setAttribute("carrito", carrito);
		//Hago un forward al Menu de Inicio
		request.getRequestDispatcher("menuinicio.html").forward(request, response);
	}

}
