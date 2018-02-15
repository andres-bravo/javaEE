package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bienvenida
 */
@WebServlet("/Bienvenida")
public class Bienvenida extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");	
		PrintWriter out=response.getWriter();
		String user=request.getParameter("user");
		out.println("<html><body><h1>Bienvenido a mi servlet sr./a "+user+"</h1>");
		out.println("<br/><br/><a href='login.html'>Volver</a>");
		out.println("</body></html>");
		out.close();
	}

}
