import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Plateau {

	Scanner scanner = new Scanner(System.in);
	String[][] contenuPlateau = new String[8][8]; // ligne x colonne
	List<Joueur> joueurs = new ArrayList<Joueur>();
	List<Tortue> tortues = new ArrayList<Tortue>();
	List<Joyau> joyaux = new ArrayList<Joyau>();
	
	public void initialisationPlateau() {
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				contenuPlateau[i][j] = " ";
			}
		}
	}
	
	public void preparationPlateau(int nbJoueurs) {
		
		Tortue tortue1 = new Tortue("1","Rouge");
		Tortue tortue2 = new Tortue("2","Bleu");
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
				Tortue tortue3 = new Tortue("3","Rose");
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
				Tortue tortue3 = new Tortue("3","Rose");
				Joueur joueur3 = new Joueur(3, tortue3);
				Tortue tortue4 = new Tortue("4","Vert");
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
        		ligne = ligne + contenuPlateau[i][j] + " ";
        	}
        	total = total + ligne + "| \n";
        }
    	System.out.println(total + "  +-----------------+");
    }
	
	public void deplacerPion(Pion pion, int ligne, int colonne) {
		if (pion.getLigne() != -1) {
			int ancienneLigne = pion.getLigne();
			int ancienneColonne = pion.getColonne();
			contenuPlateau[ancienneLigne][ancienneColonne] = " ";
		}
		pion.setLigne(ligne);
		pion.setColonne(colonne);
		contenuPlateau[ligne][colonne] = pion.symbole;
	}
	
	public boolean caseLibre(int ligne, int colonne) {
		if (contenuPlateau[ligne][colonne] == " ") {
			return true;
		}
		return false;
	}
	
	/* A faire */
	public void caseNonBlocante(int ligne, int colonne) {

		int ligneCaseHaut = ligne - 1;
		int colonneCaseHaut = colonne;
		int ligneCaseBas = ligne + 1;
		int colonneCaseBas = colonne;
		int ligneCaseGauche = ligne;
		int colonneCaseGauche = colonne - 1;
		int ligneCaseDroite = ligne;
		int colonneCaseDroite = colonne + 1;
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
}









