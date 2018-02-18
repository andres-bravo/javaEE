package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Alumno;
import beans.Curso;
import modelo.GestionAlumnos;
import modelo.GestionCursos;

/**
 * Servlet implementation class AltaCursoAction
 */
@WebServlet("/BuscarAlumnoAction")
public class BuscarAlumnoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionAlumnos galumnos=new GestionAlumnos();
		GestionCursos gcursos= new GestionCursos();
		Alumno al = galumnos.buscarAlumnoDni(request.getParameter("dni"));
		if (al!=null) {
			//Asignar curso a alumno
			//Mando los temas pendientes del alumno y los datos del alumno
			List<Curso> lcursos = gcursos.cursosAlumnoNoMatriculado(al.getId_alumno());
			request.setAttribute("lcursos", lcursos);
			request.setAttribute("alumno", al);
			request.getRequestDispatcher("asignarCursoAlumno.jsp").forward(request, response);		
		}else {
			//Alta alumno
			//Envio lista de todos los cursos para ser seleccionados
			List<Curso> lcursos = gcursos.todosCursos();
			request.setAttribute("lcursos", lcursos);
			request.getRequestDispatcher("altaAlumno.jsp").forward(request, response);
		}
	}

}
