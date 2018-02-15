package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import beans.Libro;
import beans.Venta;
import modelo.GestionLibros;

/**
 * Servlet implementation class AgregarProductoCarrito
 */
@WebServlet("/AgregarProductoCarrito")
public class AgregarProductoCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionLibros glibros=new GestionLibros();
		//obtenemos/creamos HttpSession
		HttpSession s=request.getSession();
		//Recogemos los detalles del libro
		Libro l = glibros.recuperarLibro(Integer.parseInt(request.getParameter("idLibro")));
		//Recogemos los parametros del formulario
		Venta v=new Venta(0,(Integer)s.getAttribute("clientesession"),l.getIsbn(),
				LocalDateTime.now(),l.getTitulo(),l.getAutor(),
				l.getPrecio());

		//Comprobamos si est� establecido el par�metro de session del carrito
		ArrayList<Venta> carrito = (ArrayList<Venta>)s.getAttribute("carrito");
		//Si el carrito estaba vacio lo creo nuevo
		if (carrito==null){
			carrito = new ArrayList();
		}
		//A�ado articulo al carrito
		carrito.add(v);
		//Actualizo la session con el carrito
		s.setAttribute("carrito", carrito);
		//Hago un forward al MostrarLibros
		//request.getRequestDispatcher("Controller?op=doMostrarLibros?selectTemas=2");
		//request.getRequestDispatcher("RecuperarLibrosAction?selectTemas="+Integer.parseInt(request.getParameter("selectTemas"))).forward(request, response);
		//Metemos el carrito en un JSON para enviar
		//el servlet responde al cliente enviado array Json
		String lista=formatearJson(carrito);
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.println(lista);		
	}
	private String formatearJson(List<Venta> ventas) {
		//Construcci�n del array JSon desde lista de ventas
		String resultado="";
		JSONArray array = new JSONArray();
		for(Venta v:ventas) {
			JSONObject ob = new JSONObject();
			ob.put("idLibro", v.getIdLibro());
			ob.put("titulo", v.getLibro());
			ob.put("autor", v.getAutor());
			ob.put("precio", v.getPrecio());
			array.add(ob);
		}
		return array.toJSONString();
	}

}
