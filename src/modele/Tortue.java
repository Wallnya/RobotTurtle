package modele;

public class Tortue extends Tuile{
	private int numero_joueur;
	private char sens = 'S';
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getNumero_joueur() {
		return numero_joueur;
	}
	public char getSens() {
		return sens;
	}
	public void setNumero_joueur(int numero_joueur) {
		this.numero_joueur = numero_joueur;
	}
	public void setSens(char sens) {
		this.sens = sens;
	}
	public Tortue(int parNumero_joueur) {
		numero_joueur = parNumero_joueur;
	}
	public Tortue(int numero_joueur, char sens, int x, int y) {
		this.numero_joueur = numero_joueur;
		this.sens = sens;
		this.x=x;
		this.y=y;
	}
	public void test() {
		System.out.print("tortue ");
	}
	public void coucou() {
		
	}
	
}
