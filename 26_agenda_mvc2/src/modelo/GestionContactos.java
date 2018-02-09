package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Contacto;

public class GestionContactos {
	private String url="jdbc:mysql://localhost:3306/agenda";
    private String user="root";
    private String pwd="root";
    private static String driver="com.mysql.jdbc.Driver";
    static{
    	try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
        
    }
    public void agregar(int telefono, String nombre, String email){
        try(Connection cn=DriverManager.getConnection(url, user, pwd);) {                       
            /*//Paso 2: Envio SQL
            String sql="Insert into contactos (nombre,email,telefono) ";
            sql+="values('"+nombre+"','"+email+"',"+telefono+")";
            Statement st=cn.createStatement();
            st.execute(sql);   */
            String sql="Insert into contactos (nombre,email,telefono) ";
            sql+="values(?,?,?)";
            //creamos consulta preparada:
            PreparedStatement ps=cn.prepareStatement(sql);
               //Sustituimos parametros por valores
               ps.setString(1, nombre);
               ps.setString(2, email);
               ps.setInt(3, telefono);
               //ejecutamos
               ps.execute();
            
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }      
    }
    public void agregar(Contacto con){
        agregar(con.getTelefono(),con.getNombre(),con.getEmail());
    } 
   
    
    public List<Contacto> recuperarTodos(){        
        List<Contacto> lista=new ArrayList<> ();
           
        try(Connection cn=DriverManager.getConnection(url, user, pwd);) {                       
            //Paso 2: Envio SQL
            String sql="select * from contactos";
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);            
            while(rs.next()){
                lista.add(new Contacto(rs.getInt("idContacto"),rs.getString("nombre"),rs.getString("email"),rs.getInt("telefono")));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return lista;
    }
    public void eliminarContacto(int id) {
    	try(Connection cn=DriverManager.getConnection(url, user, pwd);) {                       
            
            String sql="Delete from contactos where idContacto=?";
            
            //creamos consulta preparada:
            PreparedStatement ps=cn.prepareStatement(sql);
               //Sustituimos parametros por valores
              
               ps.setInt(1, id);
               //ejecutamos
               ps.execute();
            
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }     
    }
    
    
}
