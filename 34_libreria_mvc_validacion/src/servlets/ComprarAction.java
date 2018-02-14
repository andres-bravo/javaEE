package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabeans.Cliente;
import javabeans.Libro;
import modelo.GestionVentas;

/**
 * Servlet implementation class ComprarAction
 */
@WebServlet("/ComprarAction")
public class ComprarAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionVentas gventas=new GestionVentas();
		//obtenemos el carrito que esta como atributo de sesión
		List<Libro> carrito=(List<Libro>)request.getSession().getAttribute("carrito");
		//obtenemos el cliente que está como atributo de sesión, este objeto
		//se creó cuando el cliente se autenticó
		Cliente cliente=(Cliente)request.getSession().getAttribute("cliente");
		//registramos la venta
		gventas.registrarVenta(carrito, cliente.getIdCliente());
		//opcion a
		/*request.getSession().invalidate();
		request.getRequestDispatcher("login.jsp").forward(request, response);
		*/
		//opcion b
		carrito.clear();
		request.getRequestDispatcher("LibrosAction").forward(request, response);
		
	}

	

}
