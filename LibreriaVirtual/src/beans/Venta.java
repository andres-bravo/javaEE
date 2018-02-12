package beans;

import java.time.LocalDateTime;

public class Venta {
	private int idVenta;
	private int idCliente;
	private int idLibro;
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
	public Venta(int idVenta, int idCliente, int idLibro, LocalDateTime fecha) {
		this.idVenta = idVenta;
		this.idCliente = idCliente;
		this.idLibro = idLibro;
		this.fecha = fecha;
	}
	
	
}
