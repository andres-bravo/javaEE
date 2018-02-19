package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Alumno;
import beans.Curso;
import modelo.GestionAlumnos;
import modelo.GestionCursos;

/**
 * Servlet implementation class AltaCursoAction
 */
@WebServlet("/MostrarCursosExamenAction")
public class MostrarCursosExamenAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=((HttpServletRequest)request).getSession();
		Alumno al = (Alumno)s.getAttribute("alumno");
		GestionCursos gcursos= new GestionCursos();
		List<Curso> lcursos = gcursos.cursosExamenPendiente(al.getId_alumno());
		request.setAttribute("lcursos", lcursos);
		request.getRequestDispatcher("seleccionarCursoExamen.jsp").forward(request, response);		
	}

}
