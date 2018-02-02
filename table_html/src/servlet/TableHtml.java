package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TableHtml
 */
@WebServlet("/TableHtml")
public class TableHtml extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html><style>" + 
				"table, th, td {" + 
				"    border: 1px solid black;" + 
				"    border-collapse: collapse;" + 
				"}" + 
				"</style><body><center><table>");
		for(int i=1;i<=10;i++) {
			out.println("<tr>");
			for(int j=1;j<=10;j++) {
				out.println("<td>"+i*j+"</td>");
			}
			out.println("</tr>");
		}
		out.println("</table></center></body></html>");
	}
}
