
public class Carte {

	private String couleur;
	
	public Carte(String couleur) {
		this.couleur = couleur;
	}
	
	@Override
	public String toString() {
		return couleur;
	}

	public String getCouleur() {
		return couleur;
	}
}
