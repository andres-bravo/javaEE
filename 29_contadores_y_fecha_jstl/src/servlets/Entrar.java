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
		//creación de la cookie
		Cookie ck=new Cookie("visita",LocalTime.now().toString());
		//asignar tiempo de vida a la cookie
		ck.setMaxAge(100000);
		//añadir cookie a cabecera de la respuesta
		response.addCookie(ck);
		
		//obtenemos/creamos HttpSession
		HttpSession s=request.getSession();
		//obtener ServletContext
		ServletContext ctx=request.getServletContext();
		//variables contadores
		int valor=0;
		int global=0;
		//comprobamos si tenemos ya el atributo
		//y si es así lo recogemos
		if(s.getAttribute("contador")!=null) {
			valor=(Integer)s.getAttribute("contador");
		}
		
		if(ctx.getAttribute("global")!=null) {
			global=(Integer)ctx.getAttribute("global");
		}
		
		//incrementamos la variable y la guardamos
		valor++;
		global++;
		s.setAttribute("contador", valor);
		ctx.setAttribute("global", global);
		//transferimos petición a la página de inicio
		RequestDispatcher rd=request.getRequestDispatcher("inicio.html");
		rd.forward(request, response);
		
	}

}
