package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Tema;
import modelo.GestionTemas;

/**
 * Servlet implementation class RecuperarAction
 */
@WebServlet("/RecuperarTemasAction")
public class RecuperarTemasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionTemas gtemas=new GestionTemas();
		List<Tema> temas=gtemas.recuperarTemas();
		request.setAttribute("temas", temas);
		request.getRequestDispatcher("selecciontema.jsp").forward(request, response);
	}

}
