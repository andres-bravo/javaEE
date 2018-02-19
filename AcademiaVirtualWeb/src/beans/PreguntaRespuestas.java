package beans;

import java.util.List;

public class PreguntaRespuestas {
	private Pregunta pregunta;
	private List<Respuesta> lrespuestas;
	public Pregunta getPregunta() {
		return pregunta;
	}
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	public List<Respuesta> getLrespuestas() {
		return lrespuestas;
	}
	public void setLrespuestas(List<Respuesta> lrespuestas) {
		this.lrespuestas = lrespuestas;
	}
	public PreguntaRespuestas(Pregunta pregunta, List<Respuesta> lrespuestas) {
		super();
		this.pregunta = pregunta;
		this.lrespuestas = lrespuestas;
	}
}
