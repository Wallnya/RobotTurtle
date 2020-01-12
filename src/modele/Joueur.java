package modele;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Joueur {
	
	public static Scanner scanner = new Scanner(System.in);
	private ArrayDeque<Carte> pioche = new ArrayDeque<>();
	private List<Carte> defausse = new ArrayList<Carte>();
	private ArrayList<Carte> main;
	private ArrayDeque<Carte> programme;
	private Tortue tortue;
	private int nbObstaclePierre = 3;
	private int nbObstacleGlace = 2;
	
	public Joueur(int pNum){
		main = new ArrayList<Carte>();
		main.add(new CarteVide());
		main.add(new CarteVide());
		main.add(new CarteVide());
		main.add(new CarteVide());
		main.add(new CarteVide());
		
		programme = new ArrayDeque<Carte>();
		tortue = new Tortue(pNum);
	}
	
	// Getters et setters
	public void setPioche(ArrayDeque<Carte> pioche) {
		this.pioche = pioche;
	}
	public ArrayDeque<Carte> getPioche() {
		return pioche;
	}
	public ArrayList<Carte> getMain() {
		return main;
	}
	public void setMain(ArrayList<Carte> main) {
		this.main = main;
	}
	public ArrayDeque<Carte> getProgramme() {
		return programme;
	}
	public void setProgramme(ArrayDeque<Carte> programme) {
		this.programme = programme;
	}
	public Tortue getTortue() {
		return tortue;
	}
	public void setTortue(Tortue tortue) {
		this.tortue = tortue;
	}
	public int getNbObstaclePierre() {
		return nbObstaclePierre;
	}
	public void setNbObstaclePierre(int nbObstaclePierre) {
		this.nbObstaclePierre = nbObstaclePierre;
	}
	public int getNbObstacleGlace() {
		return nbObstacleGlace;
	}
	public void setNbObstacleGlace(int nbObstacleGlace) {
		this.nbObstacleGlace = nbObstacleGlace;
	}
	public List<Carte> getDefausse() {
		return defausse;
	}
	public void setDefausse(List<Carte> defausse) {
		this.defausse = defausse;
	}
}
