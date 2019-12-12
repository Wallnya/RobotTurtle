package modele;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Joueur{
	public static Scanner scanner = new Scanner(System.in);
	private ArrayList<Carte> main;
	private ArrayDeque<Carte> programme;
	private Tortue tortue;
	
	public Joueur(int pNum){
		this.main = new ArrayList<Carte>();
		this.programme = new ArrayDeque<Carte>();
		this.tortue = new Tortue(pNum);
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
	
	/*public void completProgram() {
		System.out.println("Voici tes cartes : "+main.toString());
		System.out.println("Combien de cartes veux-tu selectionner (dans l'ordre)?");
		int val=-1;
		int compteur=0;
		do {
			System.out.println("Choisis une action à faire"); 
			val = scanner.nextInt(); 
		}while(val < 0 || val >6);
				
		while(compteur != val) {
			System.out.println("Quelle carte");
			val = scanner.nextInt(); 
			compteur++;
		}
		
	}*/
	
}
