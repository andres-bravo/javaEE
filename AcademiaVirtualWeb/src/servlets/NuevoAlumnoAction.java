package servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestionAlumnos;

/**
 * Servlet implementation class AltaCursoAction
 */
@WebServlet("/NuevoAlumnoAction")
public class NuevoAlumnoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionAlumnos galumnos = new GestionAlumnos();
		int idalumno = 0;
		idalumno = galumnos.grabarAlumno(request.getParameter("nombre"), request.getParameter("dni"), 
				Integer.parseInt(request.getParameter("telefono")), false,request.getParameter("password"));
		if (idalumno!=0) {
			galumnos.grabarAlumnoCurso(idalumno, Integer.parseInt(request.getParameter("selectCurso")));
		}	
		request.getRequestDispatcher("menuAdmin.html").forward(request, response);
	}
}
