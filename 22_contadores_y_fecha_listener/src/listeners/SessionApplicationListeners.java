package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionApplicationListeners
 *
 */
@WebListener
public class SessionApplicationListeners implements ServletContextListener, HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SessionApplicationListeners() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
		//obtenemos/creamos HttpSession   	
		HttpSession s = arg0.getSession();
		s.setAttribute("contador",0);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
		//obtenemos/creamos HttpSession   	
		HttpSession s = arg0.getSession();
		s.setAttribute("contador",0);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
        ServletContext ctx = arg0.getServletContext();
        //inicializar los atributos de si y de no a 0
        ctx.setAttribute("global", 0);
    }
	
}
