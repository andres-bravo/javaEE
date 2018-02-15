package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
import modelo.GestionLibros;

/**
 * Servlet implementation class RecuperarAction
 */
@WebServlet("/RecuperarLibrosAction")
public class RecuperarLibrosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionLibros glibros=new GestionLibros();
		List<Libro> libros=glibros.recuperarLibros(Integer.parseInt(request.getParameter("selectTemas")));
		//el servlet responde al cliente enviado array Json
		String lista=formatearJson(libros,request.getParameter("selectTemas"));
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.println(lista);
	}
	private String formatearJson(List<Libro> libros, String selectTemas) {
		//Construcci�n del array JSon desde lista de contactos
		String resultado="";
		JSONArray array = new JSONArray();
		for(Libro l:libros) {
			JSONObject ob = new JSONObject();
			ob.put("idLibro", l.getIsbn());
			ob.put("titulo", l.getTitulo());
			ob.put("autor", l.getAutor());
			ob.put("precio", l.getPrecio());
			ob.put("selectTemas", selectTemas);
			array.add(ob);
		}
		return array.toJSONString();
	}

}
