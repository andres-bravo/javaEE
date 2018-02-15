package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Entrar
 */
@WebServlet("/Entrar")
public class Entrar extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtenemos/creamos HttpSession
		HttpSession s=request.getSession();
		int valor=0;
		//comprobamos si tenemos ya el atributo
		//y si es así lo recogemos
		if(s.getAttribute("contador")!=null) {
			valor=(Integer)s.getAttribute("contador");
		}
		//incrementamos la variable y la guardamos
		valor++;
		s.setAttribute("contador", valor);
		//transferimos petición a la página de inicio
		RequestDispatcher rd=request.getRequestDispatcher("inicio.html");
		rd.forward(request, response);
		
	}

}
