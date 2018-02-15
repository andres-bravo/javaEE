package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

import beans.Venta;

/**
 * Servlet implementation class QuitarProductoCarrito
 */
@WebServlet("/QuitarProductoCarrito")
public class QuitarProductoCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtenemos/creamos HttpSession
		HttpSession s=request.getSession();
		//Comprobamos si est� establecido el par�metro de session del carrito
		ArrayList<Venta> carrito = (ArrayList<Venta>)s.getAttribute("carrito");
		//Si el no est� vacio intento borrar.
		if (carrito!=null){		
			int pos=Integer.parseInt(request.getParameter("numarticulo"));
			//eliminamos el producto
			carrito.remove(pos);
			//No tengo que hacer un set de la variable carrito en la session porque estoy tocando el
			//objeto original.
		}
		
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
