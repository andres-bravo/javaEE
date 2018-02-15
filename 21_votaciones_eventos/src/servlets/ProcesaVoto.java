package servlets;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ProcesaVoto", urlPatterns = {"/ProcesaVoto"})
 public class ProcesaVoto extends javax.servlet.http.HttpServlet  {
	
	 @Override
	 protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtiene nombre del atributo de aplicación a incrementar
		String voto=request.getParameter("voto");
		
		ServletContext sc=this.getServletContext();
		int valor=0;		
		if(voto.equals("si")){
			valor=(Integer)sc.getAttribute("si");
			sc.setAttribute("si", ++valor);
		}
		else{
			valor=(Integer)sc.getAttribute("no");
			sc.setAttribute("no", ++valor);
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("votar.html");
		rd.forward(request, response);	
	} 
	 
	 
	 
}