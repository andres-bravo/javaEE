package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Alumno;
import beans.PreguntaRespuestas;
import modelo.GestionExamen;

/**
 * Servlet implementation class CorregirExamenAction
 */
@WebServlet("/CorregirExamenAction")
public class CorregirExamenAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=((HttpServletRequest)request).getSession();
		Alumno al = (Alumno)s.getAttribute("alumno");
		GestionExamen gexamen = new GestionExamen();
		int idcurso = Integer.parseInt(request.getParameter("idcurso"));
		List<Integer> lRespCorrectas = gexamen.RespuestasCorrectasExamen(idcurso);
		List<Integer> lRespuestas = new ArrayList<Integer>();
		for (int i= 0; i<lRespCorrectas.size();i++) {
			lRespuestas.add(Integer.parseInt(request.getParameter("selectRespuesta"+(i+1))));
		}
		Stream st1 = lRespuestas.stream();
		int aciertos = (int)st1.filter(a->lRespCorrectas.contains(a)).count();
		double nota = ((aciertos*10)/lRespCorrectas.size());
		System.out.println("a:"+aciertos+" t:"+lRespCorrectas.size());
		System.out.println((aciertos*10)/lRespCorrectas.size());
		System.out.println("nota:"+nota);
		gexamen.GrabarExamen(idcurso, al.getId_alumno(),nota);
		request.getRequestDispatcher("menuAlumno.html").forward(request, response);
	}

}
