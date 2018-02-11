package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDate;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Alumno;
import beans.Curso;

public class GestionAcademiaVirtual {
	private String cadena,user,pwd;
	private DataSource ds;
	public GestionAcademiaVirtual() {
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
	/*public GestionAcademiaVirtual() {
		//String fichero = "C:\\Users\\manana\\git\\bancabd\\src\\config\\conexion.txt";
		String fichero = "/Users/abravo/eclipse-workspace/academia_virtual/src/config/conexion.txt";
		try(FileReader fr = new FileReader(fichero);
			BufferedReader bf = new BufferedReader(fr)) {
			String s;
			System.out.println("Entro en constructor.");
			while ((s=bf.readLine())!=null){
				//System.out.println(s);
				if (s.contains("user")) {
					user = s.substring(s.indexOf("|")+1);
				}
				else if (s.contains("pwd")){
					pwd = s.substring(s.indexOf("|")+1);
				}
				else if (s.contains("conexion")) {
					cadena = s.substring(s.indexOf("|")+1);;
				}
			}
			System.out.println("user "+this.user+" pwd "+ this.pwd + " cadena "+ this.cadena);
		}	
		catch(IOException e) {
			e.printStackTrace();
		}
	}*/
	private void grabarAlumno(Alumno a){
		//Graba Alumno
		//Conexion a la BBDD
		try(Connection cn=ds.getConnection()) { 
			String sql="insert into alumnos(nombre,dni,telefono) values(?,?,?)";
			PreparedStatement ps= cn.prepareStatement(sql);
			ps.setString(1, a.getNombre());
			ps.setString(2, a.getDni());
			ps.setInt(3, a.getTelefono());
			ps.execute();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	private void grabarCurso(Curso c){
		//Graba Alumno
		//Conexion a la BBDD
		try(Connection cn=ds.getConnection()) {  
			String sql="insert into cursos(nombre,fecha_inicio,fecha_fin) values(?,?,?)";
			PreparedStatement ps= cn.prepareStatement(sql);
			ps.setString(1, c.getCurso());
			//ps.setDate(2, java.sql.Date.valueOf(c.getFecha_inicio()));
			ps.setDate(2, java.sql.Date.valueOf(c.getFecha_inicio()));;
			ps.setDate(3, java.sql.Date.valueOf(c.getFecha_fin()));
			ps.execute();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	

	public static void main(String[] args) {
		GestionAcademiaVirtual gestAc = new GestionAcademiaVirtual();
		/*Alumno a = new Alumno("a1","111a",1111);		
		gestAc.grabarAlumno(a);
		System.out.println("alumno creado");*/
		Curso c = new  Curso("python",LocalDate.parse("2018-02-01"),LocalDate.parse("2018-02-25"));
		gestAc.grabarCurso(c);
		//DateFormat.parse("12/1/2018"), new DateFormat.parse("20/01/2018"));
		
		
	}

}
