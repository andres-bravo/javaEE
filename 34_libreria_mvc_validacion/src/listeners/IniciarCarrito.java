package listeners;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import javabeans.Libro;

/**
 * Application Lifecycle Listener implementation class IniciarCarrito
 *
 */
@WebListener
public class IniciarCarrito implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public IniciarCarrito() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         arg0.getSession().setAttribute("carrito", new ArrayList<Libro>());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
