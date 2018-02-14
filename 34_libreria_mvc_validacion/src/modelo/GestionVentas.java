package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import javabeans.Libro;

public class GestionVentas {
	DataSource ds;
    public GestionVentas(){
    	try {
			InitialContext ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/reflibros");
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
    }
	
	public void registrarVenta(List<Libro> libros, int idCliente) {
		try(Connection cn=ds.getConnection();){
			String sql="insert into ventas(idCliente,idLibro,fecha) ";
			sql+="values(?,?,?)";
			PreparedStatement ps=cn.prepareStatement(sql);
			for(Libro lib:libros){
				ps.setInt(1, idCliente);
				ps.setInt(2, lib.getIsbn());
				ps.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
				ps.execute();
			}
		}
		catch (SQLException ex) {
            ex.printStackTrace();
        }   

	}

}
