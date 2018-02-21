package servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cuenta;
import modelo.GestionBancaBd;


/**
 * Servlet implementation class AltaCursoAction
 */
@WebServlet("/ExtraerAction")
public class ExtraerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=((HttpServletRequest)request).getSession();
		Cuenta c = (Cuenta)s.getAttribute("cuenta");
		GestionBancaBd gbancabd = new GestionBancaBd();
		gbancabd.extraer(c.getNumeroCuenta(), Double.parseDouble(request.getParameter("cantidadextraer")));	
		request.getRequestDispatcher("menuprincipal.html").forward(request, response);
	}

}
