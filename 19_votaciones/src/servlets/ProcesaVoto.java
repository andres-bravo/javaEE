package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcesaVoto
 */
@WebServlet("/ProcesaVoto")
public class ProcesaVoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtenemos/creamos HttpSession
		HttpSession s=request.getSession();
		//obtener ServletContext
		ServletContext ctx=request.getServletContext();
		//variables contadores
		int totalvotos=0;
		int votosSi=0;
		int votosNo=0;
		String voto = request.getParameter("voto");

		//comprobamos los atributos de aplicación y lo recogemos
		if(ctx.getAttribute("totalvotos")!=null) {
			totalvotos=(Integer)ctx.getAttribute("totalvotos");
		}
		if(ctx.getAttribute("votosSi")!=null) {
			votosSi=(Integer)ctx.getAttribute("votosSi");
		}
		if(ctx.getAttribute("votosNo")!=null) {
			votosNo=(Integer)ctx.getAttribute("votosNo");
		}		
		//dependiendo del voto favorable o no incrementamos 
		//variables de aplicacion
		if (voto.equals("si")) {
			votosSi++;
		}else {
			votosNo++;
		}
		votosNo++;
		//incrementamos la variable global y la guardamos
		totalvotos++;
		ctx.setAttribute("totalvotos", totalvotos);
		ctx.setAttribute("votosSi", votosSi);
		ctx.setAttribute("votosNo", votosNo);
		//transferimos petición a la página de inicio
		RequestDispatcher rd=request.getRequestDispatcher("votar.html");
		rd.forward(request, response);
	}

}
