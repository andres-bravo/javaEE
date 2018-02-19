package beans;

public class Pregunta {
	private int idpregunta;
	private String pregunta;
	public int getIdpregunta() {
		return idpregunta;
	}
	public void setIdpregunta(int idpregunta) {
		this.idpregunta = idpregunta;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public Pregunta(int idpregunta, String pregunta) {
		super();
		this.idpregunta = idpregunta;
		this.pregunta = pregunta;
	}
}
