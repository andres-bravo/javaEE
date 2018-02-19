package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//front controller
		String op=request.getParameter("op");
		String url="";
		switch(op) {
			case "toDatosCurso":
				url="datosCurso.html";
				break;
			case "doAltaCurso":
				url="AltaCursoAction";
				break;
			case "doRecuperar":
				url="RecuperarAction";
				break;
			case "doBuscarAlumno":
				url="BuscarAlumnoAction";
				break;
			case "doLogin":
				url="LoginAction";
				break;
			case "doNuevoAlumno":
				url="NuevoAlumnoAction";
				break;
			case "doAsignarCursoAlumno":
				url="AsignarCursoAlumnoAction";
				break;
			case "doMostrarCursosExamen":
				url="MostrarCursosExamenAction";
				break;
			case "doMostrarExamen":
				url="MostrarExamenAction";
				break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
