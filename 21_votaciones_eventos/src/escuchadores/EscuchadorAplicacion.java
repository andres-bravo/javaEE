package escuchadores;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class EscuchadorAplicacion implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0)  { 
        
    }


    public void contextInitialized(ServletContextEvent arg0)  { 
        ServletContext ctx = arg0.getServletContext();
        //inicializar los atributos de si y de no a 0
        ctx.setAttribute("si", 0);
        ctx.setAttribute("no", 0);

    }
	
}
