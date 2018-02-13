package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabeans.Cliente;
import modelo.GestionClientes;



@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url;
		GestionClientes gestion=new GestionClientes();
		
		if(gestion.estaRegistrado(request.getParameter("user"),request.getParameter("pwd"))){
			Cliente c=gestion.obtenerCliente(request.getParameter("user"),request.getParameter("pwd"));
			request.getSession().setAttribute("cliente", c);
            url="TemasAction";
            

		}
		else{
			request.setAttribute("mensaje", "Usuario no registrado");
			url="login.jsp";
		}
       
        request.getRequestDispatcher(url).forward(request, response);
	}
	

}
