package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestionUsuarios {
	String cadena="jdbc:mysql://localhost:3306/agenda";
	String user="root";
	String pwd="root";
	
	static {
		//carga del driver en memoria
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public boolean autenticar(String user, String pwd) {
		boolean res=false;
		try(Connection cn=DriverManager.getConnection(cadena,this.user,this.pwd);){
			String sql="select * from usuarios where usuario=? and password=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pwd);
			ResultSet rs=ps.executeQuery();
			res=rs.next();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return res;
	}
}
