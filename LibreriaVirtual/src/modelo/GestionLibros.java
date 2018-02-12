package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Libro;
import beans.Tema;

public class GestionLibros {
	private DataSource ds;
	public GestionLibros() {
		try {
			//conectamos con la entrada del sistema de directorio
			Context ctx=new InitialContext();
			//buscamos el DataSource
			ds=(DataSource)ctx.lookup("java:comp/env/reflibros");
		}
		catch(NamingException ex) {
			ex.printStackTrace();
		}
	}
    public List<Libro> recuperarLibros(int idtema){        
        List<Libro> lista=new ArrayList<> ();
           
        try(Connection cn=ds.getConnection();) {                       
            //Paso 2: Envio SQL
        	String sql="";
        	if (idtema>0) {
        		sql="select * from libros where idtema="+idtema;
        	}else {
        		sql="select * from libros";
        	}
        		
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);            
            while(rs.next()){
            	lista.add(new Libro(rs.getInt("isbn"),rs.getString("titulo"),rs.getString("autor"),rs.getDouble("precio")));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return lista;
    }
}
