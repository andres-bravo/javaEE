package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestionClientes;
import modelo.GestionTemas;



@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url;
		GestionClientes gestion=new GestionClientes();
		
		if(gestion.estaRegistrado(request.getParameter("user"),request.getParameter("pwd"))){
			
            //request.setAttribute("temas", gtemas.obtenerTemas());
            url="TemasAction";
            

		}
		else{
			request.setAttribute("mensaje", "Usuario no registrado");
			url="login.jsp";
		}
       
        request.getRequestDispatcher(url).forward(request, response);
	}
	

}
