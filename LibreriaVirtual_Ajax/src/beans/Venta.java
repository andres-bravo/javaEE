package beans;

import java.time.LocalDateTime;

public class Venta {
	private int idVenta;
	private int idCliente;
	private int idLibro;
	private String libro;
	private String autor;
	private double precio;
	
	private LocalDateTime fecha;
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}	
	public String getLibro() {
		return libro;
	}
	public void setLibro(String libro) {
		this.libro = libro;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Venta(int idVenta, int idCliente, int idLibro, LocalDateTime fecha, String libro, String autor, double precio) {
		this.idVenta = idVenta;
		this.idCliente = idCliente;
		this.idLibro = idLibro;
		this.fecha = fecha;
		this.autor=autor;
		this.libro=libro;
		this.precio=precio;
	}
	
	
}
