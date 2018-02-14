package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import beans.Contacto;
import modelo.GestionContactos;

/**
 * Servlet implementation class RecuperarAction
 */
@WebServlet("/RecuperarAction")
public class RecuperarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionContactos gcontactos=new GestionContactos();
		List<Contacto> contactos=gcontactos.recuperarTodos();
		//el servlet responde al cliente enviado array Json
		String lista=formatearJson(contactos);
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.println(lista);
	}
	private String formatearJson(List<Contacto> contactos) {
		//Construcción del array JSon desde lista de contactos
		String resultado="";
		JSONArray array = new JSONArray();
		for(Contacto c:contactos) {
			JSONObject ob = new JSONObject();
			ob.put("idContacto", c.getIdContacto());
			ob.put("nombre", c.getNombre());
			ob.put("email", c.getEmail());
			ob.put("telefono", c.getTelefono());
			array.add(ob);
		}
		return array.toJSONString();
	}

}
