package modelo;

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
import beans.PreguntaRespuestas;

/**
 * Servlet implementation class MostrarExamenAction
 */
@WebServlet("/MostrarExamenAction")
public class MostrarExamenAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=((HttpServletRequest)request).getSession();
		Alumno al = (Alumno)s.getAttribute("alumno");
		GestionExamen gexamen = new GestionExamen();
		List<PreguntaRespuestas> lpreResp = gexamen.DameExamenCurso(Integer.parseInt(request.getParameter("selectCurso")));
		request.setAttribute("lexamen", lpreResp);
		request.getRequestDispatcher("examen.jsp").forward(request, response);	
	}

}
