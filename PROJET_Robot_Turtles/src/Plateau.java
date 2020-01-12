import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Plateau {

	private Scanner scanner = new Scanner(System.in);
	private Pion[][] contenuPlateau = new Pion[8][8]; // ligne x colonne
	private List<Joueur> joueurs = new ArrayList<Joueur>();
	private List<Tortue> tortues = new ArrayList<Tortue>();
	private List<Joyau> joyaux = new ArrayList<Joyau>();
	
	public void initialisationPlateau() {
		Pion pionVide = new Pion();
		pionVide.setSymbole(" ");
		
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				contenuPlateau[i][j] = pionVide;
			}
		}
	}
	
	public void preparationPlateau(int nbJoueurs) {
		
		Tortue tortue1 = new Tortue("1","Rouge", 'B');
		Tortue tortue2 = new Tortue("2","Bleu", 'B');
		Joueur joueur1 = new Joueur(1, tortue1);
		Joueur joueur2 = new Joueur(2, tortue2);
		joueurs.add(joueur1);
		joueurs.add(joueur2);
		tortues.add(tortue1);
		tortues.add(tortue2);
		
		switch (nbJoueurs) {
			case 2: {
				Joyau joyau1 = new Joyau("V","Vert");
				joyaux.add(joyau1);
				break;
			}
			case 3: {
				Tortue tortue3 = new Tortue("3","Rose", 'B');
				Joueur joueur3 = new Joueur(3, tortue3);
				Joyau joyau1 = new Joyau("R","Rose");
				Joyau joyau2 = new Joyau("V","Vert");
				Joyau joyau3 = new Joyau("B","Bleu");
				tortues.add(tortue3);
				joueurs.add(joueur3);
				joyaux.add(joyau1);
				joyaux.add(joyau2);
				joyaux.add(joyau3);
				break;
			}
			case 4 :{
				Tortue tortue3 = new Tortue("3","Rose", 'B');
				Joueur joueur3 = new Joueur(3, tortue3);
				Tortue tortue4 = new Tortue("4","Vert", 'B');
				Joueur joueur4 = new Joueur(4, tortue4);
				Joyau joyau1 = new Joyau("R","Rose");
				Joyau joyau2 = new Joyau("B","Bleu");
				tortues.add(tortue3);
				joueurs.add(joueur3);
				tortues.add(tortue4);
				joueurs.add(joueur4);
				joyaux.add(joyau1);
				joyaux.add(joyau2);
				break;
			}
		}
	}
	
	public void afficherPlateau() {
    	System.out.println("    0 1 2 3 4 5 6 7 \n  +-----------------+");
    	String total = "";
    	for (int i = 0; i <= 7; i++) {
    		String ligne = i + " | ";
        	for (int j = 0; j <= 7; j++) {
        		ligne = ligne + contenuPlateau[i][j].getSymbole() + " ";
        	}
        	total = total + ligne + "| \n";
        }
    	System.out.println(total + "  +-----------------+");
    }
	
	public void deplacerPion(Pion pion, int ligne, int colonne) {
		if (pion.getLigne() != -1) {
			int ancienneLigne = pion.getLigne();
			int ancienneColonne = pion.getColonne();
			Pion pionVide = new Pion();
			pionVide.setSymbole(" ");
			contenuPlateau[ancienneLigne][ancienneColonne] = pionVide;
		}
		pion.setLigne(ligne);
		pion.setColonne(colonne);
		contenuPlateau[ligne][colonne] = pion;
	}
	
	public void deplacerTortue(Tortue tortue) {
		char orientation = tortue.getOrientation();
		int ligne = tortue.getLigne();
		int colonne = tortue.getColonne();
		
		switch(orientation) {
			case ('H') : 
				ligne = ligne - 1; 
				break;
			case ('G') : 
				colonne = colonne - 1;
				break;
			case ('B') : 
				ligne = ligne + 1;
				break;
			case ('D') : 
				colonne = colonne + 1;
				break;
		}
		if (ligne < 0 || ligne > 7 || colonne < 0 || colonne > 7) {
			System.out.println("Case invalide.");
		} else {
			if (caseLibre(ligne, colonne)) {
				if (caseNonBlocante(ligne, colonne)) {
					deplacerPion(tortue, ligne, colonne);
				} else {
					System.out.println("Case blocante.");
				}
			} else {
				System.out.println("Case déjà occupée.");
			}
		}
	}

	public void tournerTortueGauche(Tortue tortue) {
		switch(tortue.getOrientation()) {
			case ('H') : tortue.setOrientation('G'); break;
			case ('G') : tortue.setOrientation('B'); break;
			case ('B') : tortue.setOrientation('D'); break;
			case ('D') : tortue.setOrientation('H'); break;
		};
	}
	
	public void tournerTortueDroite(Tortue tortue) {
		switch(tortue.getOrientation()) {
			case ('H') : tortue.setOrientation('D'); break;
			case ('D') : tortue.setOrientation('B'); break;
			case ('B') : tortue.setOrientation('G'); break;
			case ('G') : tortue.setOrientation('H'); break;
		};
	}
	
	public boolean caseLibre(int ligne, int colonne) {
		if (contenuPlateau[ligne][colonne].getSymbole() == " ") {
			return true;
		}
		return false;
	}
	
	/* A faire */
	public boolean caseNonBlocante(int ligne, int colonne) {

		int ligneCaseHaut = ligne - 1;
		int colonneCaseHaut = colonne;
		int ligneCaseBas = ligne + 1;
		int colonneCaseBas = colonne;
		int ligneCaseGauche = ligne;
		int colonneCaseGauche = colonne - 1;
		int ligneCaseDroite = ligne;
		int colonneCaseDroite = colonne + 1;
		
		return true;
	}

	public Joueur getJoueurByNum(int numJoueur) {
		Iterator<Joueur> iterator = joueurs.iterator();
        while (iterator.hasNext()) {
        	Joueur joueur = iterator.next();
            if (joueur.getNum() == numJoueur) {
                return joueur;
            }
        }
        return null;
	}

	
	public List<Tortue> getTortues() {
		return tortues;
	}

	public List<Joyau> getJoyaux() {
		return joyaux;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public Pion getContenuCase(int ligne, int colonne) {
		return contenuPlateau[ligne][colonne];
	}
	
	public void viderCase(int ligne, int colonne) {
		Pion pionVide = new Pion();
		pionVide.setSymbole(" ");
		contenuPlateau[ligne][colonne] = pionVide;
	}
}









