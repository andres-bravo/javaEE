package filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter(urlPatterns= {"/Controller*","*.html","*.jsp"})
		//"/menuAdmin.html","/menuAlumno.html","/datosCurso.html"})
public class ComprobarLogin implements Filter {

    
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession s=((HttpServletRequest)request).getSession();
		String op=(request.getParameter("op")!=null)?request.getParameter("op"):"";
		if(s.getAttribute("cuenta")!=null||
				op.equals("doLogin")||
				op.equals("doIngresar")||
				op.equals("doExtraer") ||
				op.equals("doMovimientos")) {
			chain.doFilter(request, response);
		}else {//si no est� autenticado, no le dejamos pasar
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
