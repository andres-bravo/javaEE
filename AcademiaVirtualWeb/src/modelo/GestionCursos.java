package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Curso;

public class GestionCursos {
	private DataSource ds;
	public GestionCursos() {
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
	public void grabarCurso(String nombre, LocalDate fecha_inicio, LocalDate fecha_fin){
		//Graba Alumno
		//Conexion a la BBDD
		try(Connection cn=ds.getConnection()) {  
			String sql="insert into cursos(nombre,fecha_inicio,fecha_fin) values(?,?,?)";
			PreparedStatement ps= cn.prepareStatement(sql);
			ps.setString(1, nombre);
			//ps.setDate(2, java.sql.Date.valueOf(c.getFecha_inicio()));
			ps.setDate(2, java.sql.Date.valueOf(fecha_inicio));;
			ps.setDate(3, java.sql.Date.valueOf(fecha_fin));
			ps.execute();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
