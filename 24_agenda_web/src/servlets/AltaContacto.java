package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestionContactos;

/**
 * Servlet implementation class AltaContacto
 */
@WebServlet("/AltaContacto")
public class AltaContacto extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionContactos gcontactos=new GestionContactos();
		gcontactos.agregar(Integer.parseInt(request.getParameter("telefono")),
					request.getParameter("nombre"), request.getParameter("email"));
		request.getRequestDispatcher("inicio.html").forward(request, response);
	}

}
