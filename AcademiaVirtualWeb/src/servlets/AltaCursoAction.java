package servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestionCursos;

/**
 * Servlet implementation class AltaCursoAction
 */
@WebServlet("/AltaCursoAction")
public class AltaCursoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionCursos gcursos=new GestionCursos();
		gcursos.grabarCurso(request.getParameter("nombre"),
				LocalDate.parse(request.getParameter("fecha_inicio")),
				LocalDate.parse(request.getParameter("fecha_inicio")));		
		request.getRequestDispatcher("menuAdmin.html").forward(request, response);
	}

}
