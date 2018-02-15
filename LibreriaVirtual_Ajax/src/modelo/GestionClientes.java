package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Cliente;

public class GestionClientes {
	private DataSource ds;
	public GestionClientes() {
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
		
	public int autenticar(String user, String pwd) {
		int res=0;
		boolean encontrado = false;
		try(Connection cn=ds.getConnection();){
			String sql="select * from clientes where usuario=? and password=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pwd);
			ResultSet rs=ps.executeQuery();
			encontrado=rs.next();
			if (encontrado) {
				res=rs.getInt("IdCliente");
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return res;
	}
    public void agregar(String usuario, String password, String email, int telefono){
        try(Connection cn=ds.getConnection()) {                       
            /*//Paso 2: Envio SQL
            String sql="Insert into contactos (nombre,email,telefono) ";
            sql+="values('"+nombre+"','"+email+"',"+telefono+")";
            Statement st=cn.createStatement();
            st.execute(sql);   */
            String sql="Insert into clientes (usuario, password, email, telefono) ";
            sql+="values(?,?,?,?)";
            //creamos consulta preparada:
            PreparedStatement ps=cn.prepareStatement(sql);
               //Sustituimos parametros por valores
               ps.setString(1, usuario);
               ps.setString(2, password);
               ps.setString(3, email);
               ps.setInt(4, telefono);
               //ejecutamos
               ps.execute();
            
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }      
    }
    public void agregar(Cliente cli){
        agregar(cli.getUsuario(), cli.getPassword(), cli.getEmail(), cli.getTelefono());
    } 
}
