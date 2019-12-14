package modele;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
	
	public static Scanner scanner = new Scanner(System.in);
	private ArrayDeque<Carte> pioche = new ArrayDeque<>();
	private ArrayList<Carte> main;
	private ArrayDeque<Carte> programme;
	private Tortue tortue;
	private int nbObstaclePierre = 3;
	private int nbObstacleGlace = 2;
	
	public Joueur(int pNum){
		this.main = new ArrayList<Carte>();
		this.programme = new ArrayDeque<Carte>();
		this.tortue = new Tortue(pNum);
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
}
