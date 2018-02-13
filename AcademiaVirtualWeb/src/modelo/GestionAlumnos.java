package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Alumno;

public class GestionAlumnos {
	private DataSource ds;
	public GestionAlumnos() {
		//Le pido al servidor de conexiones una referencia al DataSource
		try {
			//conectamos con la entrada dl sistema de directorio
			Context ctx = new InitialContext();
			//buscamos el datasource
			//ds =(DataSource)ctx.lookup("jdbc/agendads");
			//Con referencia
			ds =(DataSource)ctx.lookup("java:comp/env/refacademiavirtual");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public Alumno obtenerAlumno(String user, String pass) {
		Alumno al = null;
		try(Connection con=ds.getConnection()){
			String sql="select * from alumnos where nombre=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				al= new Alumno(rs.getString("nombre"),rs.getString("dni"),rs.getInt("telefono"),rs.getBoolean("admin") );
			}			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return al;
	}
	
	public void grabarAlumno(String nombre, String dni, int telefono, boolean admin){
		//Graba Alumno
		//Conexion a la BBDD
		try(Connection cn=ds.getConnection()) { 
			String sql="insert into alumnos(nombre,dni,telefono,admin) values(?,?,?,?)";
			PreparedStatement ps= cn.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setString(2, dni);
			ps.setInt(3, telefono);
			ps.setBoolean(4, admin);
			ps.execute();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public void grabarAlumnoCurso(int idalumno, int idcurso) {
		//Graba Asociacion Alumno Curso alumnos_curso
		//Conexion a la BBDD
		try(Connection cn=ds.getConnection()) { 
			String sql="insert into alumnos_curso(idalumno,idcurso) values(?,?)";
			PreparedStatement ps= cn.prepareStatement(sql);
			ps.setInt(1, idalumno);
			ps.setInt(2, idcurso);
			ps.execute();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}		
}
	

