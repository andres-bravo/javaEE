package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Venta;
import modelo.GestionVentas;
/**
 * Servlet implementation class AltaContacto
 */
@WebServlet("/RealizarCompraAction")
public class RealizarCompraAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionVentas gventas = new GestionVentas();
		HttpSession s=request.getSession();
		//Comprobamos si est� establecido el par�metro de session del carrito
		ArrayList<Venta> carrito = (ArrayList<Venta>)s.getAttribute("carrito");
		System.out.println("Carrito"+carrito.toString());
		gventas.agregarVentas(carrito);
		//Vacio el carrito
		s.removeAttribute("carrito");
		/*gclientes.agregar(request.getParameter("usuario"),request.getParameter("password")
				, request.getParameter("email"), Integer.parseInt(request.getParameter("telefono")));*/
		//request.getRequestDispatcher("Controller?op=doRecuperarTemas").forward(request, response);
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.println("");
	}

}
