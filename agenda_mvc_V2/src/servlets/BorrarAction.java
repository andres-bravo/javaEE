package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Contacto;
import modelo.GestionContactos;

/**
 * Servlet implementation class BorrarAction
 */
@WebServlet("/BorrarAction")
public class BorrarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionContactos gcontactos=new GestionContactos();
		gcontactos.eliminar(Integer.parseInt(request.getParameter("idContacto")));
		//Lo vuelvo a mandar al controlador de Acción para que recupere los contactos otra vez.
		//request.getRequestDispatcher("inicio.html").forward(request, response);
		request.getRequestDispatcher("RecuperarAction").forward(request, response);
	}

}
