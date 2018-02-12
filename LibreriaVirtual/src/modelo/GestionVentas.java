package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

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
		
    public void agregar(int idVenta, int idCliente, int idLibro, LocalDateTime fecha){
        try(Connection cn=ds.getConnection()) {                       
            /*//Paso 2: Envio SQL
            String sql="Insert into contactos (nombre,email,telefono) ";
            sql+="values('"+nombre+"','"+email+"',"+telefono+")";
            Statement st=cn.createStatement();
            st.execute(sql);   */
            String sql="Insert into ventas (idVEnta, idCliente, idLibro, fecha) ";
            sql+="values(?,?,?,?)";
            //creamos consulta preparada:
            PreparedStatement ps=cn.prepareStatement(sql);
               //Sustituimos parametros por valores
               ps.setInt(1, idVenta);
               ps.setInt(2, idCliente);
               ps.setInt(3, idLibro);
               ps.setTimestamp(4, java.sql.Timestamp.valueOf(fecha));
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
