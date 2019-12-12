package modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Jeu {
	private int nbJoueurs;
	private Plateau plateau;
	private List<Carte> pioche;
	private static List<Joueur> joueurs;
	public static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Constructeur
	 * */
	public Jeu(int parNbJoueurs, Plateau parPlateau, List<Carte> parPioche) {
		nbJoueurs = parNbJoueurs;
		plateau = parPlateau;
		pioche = parPioche;
	}
	
	public int getNbJoueurs() {
		return nbJoueurs;
	}
	
	public void pioche(Joueur j) {
		j.getMain().add(pioche.get(0));
		pioche.remove(0);
	}
	
	public static void lancerPartie() {
		int nb = 2;
		Joueur j1 = new Joueur(1);
		Plateau p = new Plateau(nb);
		j1.setTortue(new Tortue(1,'S',0,1));
		Joueur j2 = new Joueur(2);
		joueurs = new ArrayList<Joueur>();
		joueurs.add(j1);
		joueurs.add(j2);
		List<Carte> pioche = new ArrayList<Carte>();
		for(int i=0;i<17;i++) {
			pioche.add(new CarteBleue());
		}
		for(int i=0;i<7;i++) {
			pioche.add(new CarteJaune());
		}
		for(int i=0;i<7;i++) {
			pioche.add(new CarteViolete());
		}
		/*for(int i=0;i<2;i++) {
			pioche.add(new CarteRouge());
		}*/
		Collections.shuffle(pioche);
		System.out.println(pioche.toString());
		Jeu j = new Jeu(nb,p,pioche);
		j.plateau.affichage();

		for(int i=0;i<5;i++) {
			j.pioche(j1);
			j.pioche(j2);
		}
		while(true) {
			int val=-1;
			do {
				System.out.println("Choisis une action à faire"); 
				val = scanner.nextInt(); 
			}while((val < 0 || val >4));
			switch(val) {
			case 1:
				/*j1.completProgram();*/
				System.out.println();
			case 2:
				break;
			case 3:
				
			}
		}
		/*for(Carte str : j1.getMain()){
			   System.out.println(str.toString());
			   str.action(j1.getTortue(), p);
			   j.plateau.affichage();
			   System.out.println(j1.getTortue().getSens()+"------------------------");
		}*/
	}
	
	public static void main(String[] args) {
		lancerPartie();
	}
}
