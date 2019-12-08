package modele;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Joueur{
	private ArrayDeque<Carte> programme;
	private List<Carte> main = new ArrayList<Carte>();
	private Tortue tortue;
	
	public Tortue getTortue() {
		return tortue;
	}
	public void setTortue(Tortue tortue) {
		this.tortue = tortue;
	}
	public ArrayDeque<Carte> getProgramme() {
		return programme;
	}
	public void setProgramme(ArrayDeque<Carte> programme) {
		this.programme = programme;
	}
	public List<Carte> getMain() {
		return main;
	}
	public void setMain(List<Carte> main) {
		this.main = main;
	}
	public void test() {
		System.out.print("Joueur ");
	}
	
}
