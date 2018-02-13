package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Alumno;
import modelo.GestionAlumnos;




@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url;
		GestionAlumnos gestion= new GestionAlumnos();
		Alumno al = gestion.obtenerAlumno(request.getParameter("user"),request.getParameter("pwd"));
		if (al!=null) {
			request.getSession().setAttribute("alumno", al);
			if (al.getAdmin()) {
				url="menuAdmin.html";
			}else {
				url="menuAlumno.html";
			};
		}else{
			request.setAttribute("mensaje", "Usuario no registrado");
			url="login.jsp";
		}
      
        request.getRequestDispatcher(url).forward(request, response);
	}
	

}
