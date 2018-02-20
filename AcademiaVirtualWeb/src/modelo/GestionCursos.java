package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Alumno;
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
		//Graba Curso
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
	public List<Curso> todosCursos(){
		Curso c = null;
		List<Curso> lc = new ArrayList<Curso>();
		try(Connection con=ds.getConnection()){
			String sql="select * from cursos";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				c = new Curso(rs.getInt("idcurso"),rs.getString("nombre"),rs.getDate("fecha_inicio").toLocalDate(),rs.getDate("fecha_fin").toLocalDate());
				lc.add(c);
			}			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return lc;	
	}
	public List<Curso> cursosAlumnoNoMatriculado(int idalumno){
		//Lista de cursos en los que un alumno no está matriculado
		Curso c = null;
		List<Curso> lc = new ArrayList<Curso>();
		try(Connection con=ds.getConnection()){
			String sql="select * from academiavirtual.cursos c where c.idcurso not in (select idcurso from academiavirtual.alumnos_curso ac where ac.idalumno="+idalumno+")";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				c = new Curso(rs.getInt("idcurso"),rs.getString("nombre"),rs.getDate("fecha_inicio").toLocalDate(),rs.getDate("fecha_fin").toLocalDate());
				lc.add(c);
			}			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return lc;	
	}
	public List<Curso> cursosExamenPendiente(int idalumno){
		//Lista de cursos en los que un alumno no está matriculado
		Curso c = null;
		List<Curso> lc = new ArrayList<Curso>();
		try(Connection con=ds.getConnection()){
			String sql="select c.idcurso, c.nombre, c.fecha_inicio, c.fecha_fin from academiavirtual.alumnos_curso ac inner join academiavirtual.cursos c "
					+ "where (ac.idcurso=c.idcurso) and (ac.idalumno=? and isnull(ac.fechaexamen) and isnull(ac.notaexamen) and (c.fecha_fin>=?))";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, idalumno);
			ps.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
			ResultSet rs=ps.executeQuery();
			System.out.println(ps.toString());
	
			while (rs.next()) {
				c = new Curso(rs.getInt("idcurso"),rs.getString("nombre"),rs.getDate("fecha_inicio").toLocalDate(),rs.getDate("fecha_fin").toLocalDate());
				lc.add(c);
			}			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return lc;	
	}	
}

