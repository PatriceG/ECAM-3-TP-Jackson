package fr.ecam;

public class Adresse {
	private String type;
	private String ville;
	private String codePostal;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	@Override
	public String toString() {
		return "Adresse [codePostal=" + codePostal + ", type=" + type
				+ ", ville=" + ville + "]";
	}
	
}
