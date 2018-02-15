package servlets;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		//Creacion de la cookie
		Cookie ck=new Cookie("visita", LocalTime.now().toString());
		//tiempo de vida de la Cookie en segundos
		ck.setMaxAge(100000);
		//A�adir cookie a la cabecera de la respuesta
		response.addCookie(ck);
		
		//obtenemos/creamos HttpSession
		HttpSession s=request.getSession();
		//obtener ServletContext
		ServletContext ctx=request.getServletContext();
		//variables contadores
		int valor=0;
		int global=0;
		//comprobamos si tenemos ya el atributo
		//y si es as� lo recogemos
		if(s.getAttribute("contador")!=null) {
			valor=(Integer)s.getAttribute("contador");
		}
		
		//comprobamos el atributo de aplicaci�n y lo recogemos
		if(ctx.getAttribute("global")!=null) {
			global=(Integer)ctx.getAttribute("global");
		}
		//incrementamos la variable y la guardamos
		valor++;
		s.setAttribute("contador", valor);
		//incrementamos la variable global y la guardamos
		global++;
		ctx.setAttribute("global", global);
		//transferimos petici�n a la p�gina de inicio
		RequestDispatcher rd=request.getRequestDispatcher("inicio.html");
		rd.forward(request, response);
		
	}

}
