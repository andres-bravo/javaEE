package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cuenta;
import modelo.GestionBancaBd;




@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url;
		GestionBancaBd gestion= new GestionBancaBd();
		Cuenta c = gestion.recuperarCuenta(Integer.parseInt(request.getParameter("numerocuenta")));
		if (c!=null) {
			request.getSession().setAttribute("cuenta", c);
			url="menuprincipal.html";
		}else{
			request.setAttribute("mensaje", "Número de cuenta no válido.");
			url="login.jsp";
		}
        request.getRequestDispatcher(url).forward(request, response);
	}
	

}
