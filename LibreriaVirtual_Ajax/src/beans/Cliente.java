package beans;

public class Cliente {
	private int idcliente;
	private String usuario;
	private String password;
	private String email;
	private int telefono;
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public Cliente(int idcliente, String usuario, String password, String email, int telefono) {
		this.idcliente = idcliente;
		this.usuario = usuario;
		this.password = password;
		this.email = email;
		this.telefono = telefono;
	}
}
