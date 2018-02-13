package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Venta;

public class GestionVentas {
	private DataSource ds;
	public GestionVentas() {
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
	public void agregarVentas(List<Venta> ventas) {
	       try(Connection cn=ds.getConnection()) {
	            String sql="Insert into ventas (idCliente, idLibro, fecha) ";
	            sql+="values(?,?,?)";
	            //creamos consulta preparada:
	            PreparedStatement ps=cn.prepareStatement(sql);
	            for(Venta v:ventas) {   
	            	//Sustituimos parametros por valores
	               ps.setInt(1, v.getIdCliente());
	               ps.setInt(2, v.getIdLibro());
	               ps.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
	               //ejecutamos
	               ps.execute();
	            }
	        }  catch (SQLException ex) {
	            ex.printStackTrace();
	        }      
	}
    public void agregar(int idVenta, int idCliente, int idLibro, LocalDateTime fecha){
        try(Connection cn=ds.getConnection()) {                       
            /*//Paso 2: Envio SQL
            String sql="Insert into contactos (nombre,email,telefono) ";
            sql+="values('"+nombre+"','"+email+"',"+telefono+")";
            Statement st=cn.createStatement();
            st.execute(sql);   */
            String sql="Insert into ventas (idCliente, idLibro, fecha) ";
            sql+="values(?,?,?)";
            //creamos consulta preparada:
            PreparedStatement ps=cn.prepareStatement(sql);
               //Sustituimos parametros por valores
               ps.setInt(1, idCliente);
               ps.setInt(2, idLibro);
               ps.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
               //ejecutamos
               ps.execute();
            
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }      
    }
    public void agregar(Venta ven){
        agregar(ven.getIdVenta(),ven.getIdCliente(),ven.getIdLibro(),ven.getFecha());
    } 
}
