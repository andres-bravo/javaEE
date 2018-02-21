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
			case "doLogin":
				url="LoginAction";
				break;
			case "doIngresar":
				url="IngresarAction";
				break;
			case "doExtraer":
				url="ExtraerAction";
				break;
			case "doMovimientos":
				url="MovimientosAction";
				break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
