
public class Tortue extends Pion {
	
	private String couleur;
	private char orientation;
	
	public Tortue(String symbole, String couleur, char orientation) {
		this.symbole = symbole;
		this.couleur = couleur;
		this.orientation = orientation;
	}
	public Tortue() {
		
	}
	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public void setOrientation(char orientation) {
		this.orientation = orientation;
	}
	public char getOrientation() {
		return orientation;
	}

}