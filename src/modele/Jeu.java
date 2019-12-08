package modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jeu {
	private int nbJoueurs;
	private Plateau plateau;
	private List<Carte> pioche;
	private static List<Joueur> joueurs;
	
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
	
	public static void main(String[] args) {
		int nb = 2;
		Joueur j1 = new Joueur();
		Plateau p = new Plateau(nb);
		j1.setTortue(new Tortue(1,'S',0,7));
		Joueur j2 = new Joueur();
		Joueur j3 = new Joueur();
		joueurs = new ArrayList<Joueur>();
		joueurs.add(j1);
		joueurs.add(j2);
		joueurs.add(j3);
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
		for(int i=0;i<2;i++) {
			pioche.add(new CarteRouge());
		}
		Collections.shuffle(pioche);
		System.out.println(pioche.toString());
		Jeu j = new Jeu(nb,p,pioche);
		j.plateau.affichage();

		for(int i=0;i<10;i++) {
			j.pioche(j1);

		}
		for(Carte str : j1.getMain()){
			   System.out.println(str.toString());
			   str.action(j1.getTortue(), p);
			   j.plateau.affichage();
			   System.out.println(j1.getTortue().getSens()+"------------------------");
		}
	}
}
