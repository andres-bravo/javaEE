package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Pregunta;
import beans.PreguntaRespuestas;
import beans.Respuesta;

public class GestionExamen {
	private DataSource ds;
	public GestionExamen() {
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
	
	public List<PreguntaRespuestas> DameExamenCurso(int idcurso){
		/*Query union
		 *  select pe.idcurso, pe.idpregunta, p.pregunta, r.idrespuesta,r.respuesta, r.correcta
 from academiavirtual.preguntasexamen pe 
 inner join academiavirtual.preguntas p on (pe.idpregunta=p.idpregunta) 
 inner join academiavirtual.respuestaspregunta rp on (p.idpregunta= rp.idpregunta) 
 inner join academiavirtual.respuestas r on (rp.idrespuesta=r.idrespuesta)
 having pe.idcurso=5;
		 */
		/*Query preguntas Examen
		 * select pe.idcurso, pe.idpregunta, p.pregunta 
 from academiavirtual.preguntasexamen pe 
 inner join academiavirtual.preguntas p on (pe.idpregunta=p.idpregunta) 
  having pe.idcurso=5 order by pe.idpregunta;
		 */
		//Lista de cursos en los que un alumno no está matriculado
		Pregunta pre = null;
		Respuesta resp = null;
		List<Respuesta> lRespPre = null;
		PreguntaRespuestas preResp = null;
		
		List<PreguntaRespuestas> lpreResp = new ArrayList<PreguntaRespuestas>();
		try(Connection con=ds.getConnection()){
			String sql="select pe.idcurso, pe.idpregunta, p.pregunta " + 
					" from academiavirtual.preguntasexamen pe " + 
					" inner join academiavirtual.preguntas p on (pe.idpregunta=p.idpregunta) " + 
					"  having pe.idcurso=? order by pe.idpregunta;";
			String sqlRespuestas="select rp.idpregunta, rp.idrespuesta, r.respuesta, r.correcta from respuestaspregunta rp " + 
					"inner join respuestas r on (rp.idrespuesta= r.idrespuesta) " + 
					"having rp.idpregunta=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, idcurso);
			ResultSet rs=ps.executeQuery();
			System.out.println(ps.toString());
			PreparedStatement psresp=con.prepareStatement(sqlRespuestas);
			//Por cada pregunta Recupero las Respuestas y las inserto en listaPreResp
			while (rs.next()) {
				pre = new Pregunta(rs.getInt("idpregunta"), rs.getString("pregunta"));
				//Traigo las respuestas
				psresp.setInt(1, rs.getInt("idpregunta"));
				ResultSet rsResp=psresp.executeQuery();
				System.out.println(psresp.toString());
				lRespPre = new ArrayList<Respuesta>();
				while (rsResp.next()) {
					resp = new Respuesta(rsResp.getInt("idrespuesta"),rsResp.getString("respuesta"),rsResp.getBoolean("correcta"));
					lRespPre.add(resp);
				}
				preResp = new PreguntaRespuestas(pre,lRespPre);
				lpreResp.add(preResp);
			}
			
			/* INTENTO EN UNA SOLA QUERY, PODRIA SER PERO MUCHO ALGORITMO
			//Variable idpregunta para ir cambiando de posicion en la Lista de PreguntaRespuestas
			int idpregunta = -1;
			while (rs.next()) {
				if (rs.getInt("idpregunta") != idpregunta) {
					//Comienzo pregunta
					if (idpregunta>-1) {
						//Si no es la primera la inserto en la lista preguntas y respuestas
						pr = new PreguntaRespuestas(p,rp);
						lpr.add(pr);
					}
					p = new Pregunta(rs.getInt("idpregunta"), rs.getString("pregunta"));
				}else {
					//Inserto respuesta en pregunta existente
				}
				c = new Curso(rs.getInt("idcurso"),rs.getString("nombre"),rs.getDate("fecha_inicio").toLocalDate(),rs.getDate("fecha_fin").toLocalDate());
				lc.add(c);
			}*/			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return lpreResp;			
	}
	public List<Integer> RespuestasCorrectasExamen(int idcurso) {
		/*Query
		 * select r.idrespuesta 
 from academiavirtual.preguntasexamen pe 
 inner join academiavirtual.preguntas p on (pe.idpregunta=p.idpregunta) 
inner join academiavirtual.respuestaspregunta rp on (p.idpregunta= rp.idpregunta) 
inner join academiavirtual.respuestas r on (rp.idrespuesta= r.idrespuesta)
 where pe.idcurso=5 and r.correcta=true;
		 */
		List<Integer> laciertos = new ArrayList<Integer>();
		try(Connection con=ds.getConnection()){
			String sql="select r.idrespuesta \n" + 
					" from academiavirtual.preguntasexamen pe \n" + 
					" inner join academiavirtual.preguntas p on (pe.idpregunta=p.idpregunta) \n" + 
					"inner join academiavirtual.respuestaspregunta rp on (p.idpregunta= rp.idpregunta) \n" + 
					"inner join academiavirtual.respuestas r on (rp.idrespuesta= r.idrespuesta)\n" + 
					" where pe.idcurso=? and r.correcta=true";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, idcurso);
			ResultSet rs=ps.executeQuery();
			System.out.println(ps.toString());
			while (rs.next()) {
				laciertos.add(rs.getInt("idrespuesta"));
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return laciertos;
	}
	public void GrabarExamen(int idcurso, int idalumno,double notaexamen) {
		//Graba el resultado del examen en la tabla alumnos curso
		//Conexion a la BBDD
		try(Connection cn=ds.getConnection()) {  
			String sql="update alumnos_curso set (idalumno = ?,idcurso =?,fechaexamen=?,notaexamen=?) where (idalumno=? and icurso=?)";
			PreparedStatement ps= cn.prepareStatement(sql);
			ps.setInt(1, idalumno);
			ps.setInt(2, idcurso);
			ps.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
			ps.setDouble(4, notaexamen);
			ps.setInt(5, idalumno);
			ps.setInt(6, idcurso);
			System.out.println(ps.toString());
			ps.execute();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
