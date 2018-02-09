package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GestionUsuarios {
	private DataSource ds;
	public GestionUsuarios() {
		//Le pido al servidor de conexiones una referencia al DataSource
		try {
			//conectamos con la entrada dl sistema de directorio
			Context ctx = new InitialContext();
			//buscamos el datasource
			//ds =(DataSource)ctx.lookup("jdbc/agendads");
			//Con referencia
			ds =(DataSource)ctx.lookup("java:comp/env/refagenda");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean autenticar(String user, String pwd) {
		boolean res=false;
		try(Connection cn=ds.getConnection()){
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
