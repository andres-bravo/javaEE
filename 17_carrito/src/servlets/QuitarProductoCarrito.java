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
 * Servlet implementation class QuitarProductoCarrito
 */
@WebServlet("/QuitarProductoCarrito")
public class QuitarProductoCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtenemos/creamos HttpSession
		HttpSession s=request.getSession();
		//Comprobamos si está establecido el parámetro de session del carrito
		ArrayList<Producto> carrito = (ArrayList<Producto>)s.getAttribute("carrito");
		//Si el no está vacio intento borrar.
		if (carrito!=null){
			carrito = new ArrayList();
			int pos=Integer.parseInt(request.getParameter("numarticulo"));
			//eliminamos el producto
			carrito.remove(pos);
			//No tengo que hacer un set de la variable carrito en la session porque estoy tocando el
			//objeto original.
		}
		request.getRequestDispatcher("Vercarrito.jsp").forward(request, response);
		
		
	}

}
