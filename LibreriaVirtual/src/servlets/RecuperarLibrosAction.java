package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;
import modelo.GestionLibros;

/**
 * Servlet implementation class RecuperarAction
 */
@WebServlet("/RecuperarLibrosAction")
public class RecuperarLibrosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionLibros glibros=new GestionLibros();
		List<Libro> libros=glibros.recuperarLibros(Integer.parseInt(request.getParameter("selectTemas")));
		request.setAttribute("libros", libros);
		request.getRequestDispatcher("mostrarlibros.jsp").forward(request, response);
	}

}
