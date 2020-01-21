package br.com.cardif.webservice.model;

public class ResponseVolksJSON {
	
	private String codRetorno;
	private String message;
	private String bilheteId;
	
	
	public String getCodRetorno() {
		return codRetorno;
	}
	public void setCodRetorno(String codRetorno) {
		this.codRetorno = codRetorno;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getBilheteId() {
		return bilheteId;
	}
	public void setBilheteId(String bilheteId) {
		this.bilheteId = bilheteId;
	}
	

}
