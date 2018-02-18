package beans;

public class Alumno {
	private int id_alumno;
	private String nombre;
	private String dni;
	private int telefono;
	private boolean admin;
	
	public Alumno(int idalumno, String nombre, String dni, int telefono, boolean admin) {
		super();
		this.id_alumno = idalumno;
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.admin = admin;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}
	public boolean getAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	

}
