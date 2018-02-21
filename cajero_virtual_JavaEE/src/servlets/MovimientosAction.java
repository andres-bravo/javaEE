package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cuenta;
import beans.Movimiento;
import modelo.GestionBancaBd;

/**
 * Servlet implementation class AltaCursoAction
 */
@WebServlet("/MovimientosAction")
public class MovimientosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=((HttpServletRequest)request).getSession();
		Cuenta c = (Cuenta)s.getAttribute("cuenta");
		GestionBancaBd gbancabd = new GestionBancaBd();

		List<Movimiento> lmovimientos = gbancabd.ultimosMovimientos(c.getNumeroCuenta());
		request.setAttribute("lmovimientos", lmovimientos);
		request.getRequestDispatcher("listadomovimientos.jsp").forward(request, response);		
	}

}
