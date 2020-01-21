package modele;

public class Tuile {
	
	protected String symbole;
	protected int ligne = -1;
	protected int colonne = -1;
	
	public Tuile(int ligne, int colonne, String symbole) {
		this.ligne = ligne;
		this.colonne = colonne;
		this.symbole = symbole;
	}

	public Tuile() {
	}

	public String toString() {
		return this.symbole;
	}
	
	// Getters et setters
	public void setLigne(int ligne) {
		this.ligne = ligne;
	}
	public void setColonne(int colonne) {
		this.colonne = colonne;
	}
	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}
	public int getLigne() {
		return ligne;
	}
	public int getColonne() {
		return colonne;
	}
	public String getSymbole() {
		return symbole;
	}
	
}
