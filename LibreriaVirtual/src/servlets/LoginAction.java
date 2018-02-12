package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Venta;
import modelo.GestionClientes;



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
		GestionClientes gclientes = new GestionClientes();
		//obtenemos/creamos HttpSession
		HttpSession s=request.getSession();
		int idcliente = gclientes.autenticar(request.getParameter("user"), pwd);

		if(idcliente>0){
			//Establezco parametro de session idcliente
			s.setAttribute("clientesession", idcliente);
			//obtener requestdispatcher
			rd=request.getRequestDispatcher("Controller?op=doRecuperarTemas");				
		}else{
			request.setAttribute("mensaje", "Usuario y contraseña no válidos");
			//obtener requestdispatcher
			 rd=request.getRequestDispatcher("login.jsp");			
		}
		//trasnferir petición
		rd.forward(request, response);
		
	}

}
