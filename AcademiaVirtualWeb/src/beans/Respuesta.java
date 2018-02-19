package beans;

public class Respuesta {
	private int idrespuesta;
	private String respuesta;
	private boolean correcta;
	public int getIdrespuesta() {
		return idrespuesta;
	}
	public void setIdrespuesta(int idrespuesta) {
		this.idrespuesta = idrespuesta;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public boolean isCorrecta() {
		return correcta;
	}
	public void setCorrecta(boolean correcta) {
		this.correcta = correcta;
	}
	public Respuesta(int idrespuesta, String respuesta, boolean correcta) {
		super();
		this.idrespuesta = idrespuesta;
		this.respuesta = respuesta;
		this.correcta = correcta;
	}
}
