package modele;

public class Joyau extends Tuile{

	private String couleur;
	
	public Joyau(String symbole, String couleur) {
		this.symbole = symbole;
		this.couleur = couleur;
	}
	
	// Getters et setters
	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
}
