package modele;

public class Tortue extends Tuile {
	
	private int numero_joueur;
	private String couleur;
	private char sens = 'S';
	private final int ligne_debut;
	private final int colonne_debut;
	
	
	public Tortue(int parNumero_joueur) {
		numero_joueur = parNumero_joueur;
		ligne_debut=0;
		colonne_debut=0;
	}
	
	public Tortue(int numero_joueur, String symbole, String couleur, char sens, int ligne, int colonne) {
		this.numero_joueur = numero_joueur;
		this.symbole = symbole;
		this.couleur = couleur;
		this.sens = sens;
		this.ligne=ligne;
		this.colonne=colonne;
		ligne_debut=ligne;
		colonne_debut=colonne;
	}
	
	// Getters et setters
	public void setSens(char sens) {
		this.sens = sens;
	}
	public char getSens() {
		return sens;
	}
	public void setNumero_joueur(int numero_joueur) {
		this.numero_joueur = numero_joueur;
	}
	public int getNumero_joueur() {
		return numero_joueur;
	}
	public int getLigne_debut() {
		return ligne_debut;
	}
	public int getColonne_debut() {
		return colonne_debut;
	}
	
}
