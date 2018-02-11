package beans;

import java.time.LocalDate;

public class Curso {
	private int idcurso;
	private String curso;
	private LocalDate fecha_inicio;
	private LocalDate fecha_fin;
	public Curso(String curso, LocalDate fecha_inicio, LocalDate fecha_fin) {
		super();
		this.curso = curso;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public LocalDate getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(LocalDate fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	
}
