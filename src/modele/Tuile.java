package modele;

public class Tuile {
	
	protected String symbole;
	protected int ligne;
	protected int colonne;
	
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
