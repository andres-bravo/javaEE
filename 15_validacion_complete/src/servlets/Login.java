package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd=request.getParameter("pwd");
		RequestDispatcher rd;
		if(pwd.equals("Java")){
			//obtener requestdispatcher es un forward
			rd=request.getRequestDispatcher("Bienvenida.jsp");		
			
		}else{
			//obtener requestdispatcher
			 rd=request.getRequestDispatcher("Error.jsp");			
		}
		//trasnferir petición
		rd.forward(request, response);
		
	}

}
