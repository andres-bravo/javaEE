package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Resultados
 */
@WebServlet("/Resultados")
public class Resultados extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");	
		PrintWriter out=response.getWriter();
		int valor=0;
		//obtenemos el valor del contador
		HttpSession s=request.getSession();
		if(s.getAttribute("contador")!=null) {
			valor=(Integer)s.getAttribute("contador");
		}
		out.println("<html><body>");
		out.println("<h1> Has entrado "+valor+" veces</h1>");
		out.println("<br/><br/><a href='inicio.html'>Volver</a>");
		out.println("</body></html>");
	}

}
