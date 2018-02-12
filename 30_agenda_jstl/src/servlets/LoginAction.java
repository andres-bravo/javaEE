package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestionUsuarios;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd=request.getParameter("pwd");
		RequestDispatcher rd;
		GestionUsuarios gusuarios=new GestionUsuarios();
		
		if(gusuarios.autenticar(request.getParameter("user"), pwd)){
			//obtener requestdispatcher
			rd=request.getRequestDispatcher("inicio.html");		
			
		}else{
			request.setAttribute("mensaje", "Usuario y contraseña no válidos");
			//obtener requestdispatcher
			 rd=request.getRequestDispatcher("login.jsp");			
		}
		//trasnferir petición
		rd.forward(request, response);
		
	}

}
