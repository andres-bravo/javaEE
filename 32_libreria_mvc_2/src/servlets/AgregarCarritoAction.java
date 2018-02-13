package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabeans.Libro;
import modelo.GestionLibros;

@WebServlet("/AgregarCarritoAction")
public class AgregarCarritoAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession();
		//recuperamos carrito que tenemos en un atributo de sesión
		List<Libro> carrito=(List<Libro>)s.getAttribute("carrito");
		//recogemos el parametro con el isbn del libro a añadir
		int isbn=Integer.parseInt(request.getParameter("isbn"));
		GestionLibros glibros=new GestionLibros();
		//Añadimos libro obtenido al carrito
		carrito.add(glibros.recuperarLibroPorIsbn(isbn));
		request.getRequestDispatcher("LibrosAction").forward(request, response);
	}

}
