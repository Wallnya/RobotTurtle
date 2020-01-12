
public class Pion {
	
	protected String symbole;
	private int ligne = -1;
	private int colonne = -1;
	

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
