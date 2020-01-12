package modele;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Plateau{

	private Tuile[][] contenuPlateau;
	private int nbJoueurs;
	private List<Joueur> joueurs;
	private static int victoire = 0;

	public void preparationPlateau(int nbJoueurs) {
		
		contenuPlateau = new Tuile[8][8];
		setNbJoueurs(nbJoueurs);
		initialisationPlateau();
		joueurs = new ArrayList<Joueur>();
		
		switch(nbJoueurs) {
			case 2: {
				for (int i = 0; i <= 7; i++){
					ObstaclePierre obstaclePierre = new ObstaclePierre();
					deplacerTuile(obstaclePierre, i, 7);
				}
				
				Joueur joueur1 = new Joueur(1);
				Tortue tortue1 = new Tortue(1,"1","Rouge",Sens.SUD,0,1);
				joueur1.setTortue(tortue1);
				setJoueur(0,1,tortue1);
				
				Joueur joueur2 = new Joueur(2);
				Tortue tortue2 = new Tortue(2,"2","Bleu",Sens.SUD,0,5);
				joueur2.setTortue(tortue2);
				setJoueur(0,5,tortue2);
				
				joueurs.add(joueur1);
				joueurs.add(joueur2);
				
				melangerCartes(joueur1);
				melangerCartes(joueur2);

				Joyau joyau1 = new Joyau("V","Vert");
				deplacerTuile(joyau1, 0, 3);

				break;
			}
			case 3: {
				for (int i = 0; i <= 7; i++){
					ObstaclePierre obstaclePierre = new ObstaclePierre();
					deplacerTuile(obstaclePierre, i, 7);
				}
				Joueur joueur1 = new Joueur(1);
				Tortue tortue1 = new Tortue(1,"1","Rouge",Sens.SUD,0,0);
				joueur1.setTortue(tortue1);
				setJoueur(0,0,tortue1);
	
				Joueur joueur2 = new Joueur(2);
				Tortue tortue2 = new Tortue(2,"2","Bleu",Sens.SUD,0,3);
				joueur2.setTortue(tortue2);
				setJoueur(0,3,tortue2);
	
				Joueur joueur3 = new Joueur(3);
				Tortue tortue3 = new Tortue(3,"3","Rose",Sens.SUD,0,6);
				joueur3.setTortue(tortue3);
				setJoueur(0,6,tortue3);
	
				joueurs.add(joueur1);
				joueurs.add(joueur2);
				joueurs.add(joueur3);
				
				melangerCartes(joueur1);
				melangerCartes(joueur2);
				melangerCartes(joueur3);
				
				Joyau joyau1 = new Joyau("R","Rose");
				Joyau joyau2 = new Joyau("V","Vert");
				Joyau joyau3 = new Joyau("B","Bleu");
				
				/*deplacerTuile(joyau1, 7, 0);
				deplacerTuile(joyau2, 7, 3);
				deplacerTuile(joyau3, 7, 6);*/
				deplacerTuile(joyau1, 0, 1);
				deplacerTuile(joyau2, 0, 4);
				deplacerTuile(joyau3, 0, 5);

				break;
			}
			case 4: {
	
				Joueur joueur1 = new Joueur(1);
				Tortue tortue1 = new Tortue(1,"1","Rouge",Sens.SUD,0,0);
				joueur1.setTortue(tortue1);
				setJoueur(0,0,tortue1);
	
				Joueur joueur2 = new Joueur(2);
				Tortue tortue2 = new Tortue(2,"2","Bleu",Sens.SUD,0,2);
				joueur2.setTortue(tortue2);
				setJoueur(0,2,tortue2);
	
				Joueur joueur3 = new Joueur(3);
				Tortue tortue3 = new Tortue(3,"3","Rose",Sens.SUD,0,5);
				setJoueur(0,5,tortue3);
				joueur3.setTortue(tortue3);
	
				Joueur joueur4 = new Joueur(4);
				Tortue tortue4 = new Tortue(4,"4","Vert",Sens.SUD,0,7);
				joueur4.setTortue(tortue4);
				setJoueur(0,7,tortue4);
				
				joueurs.add(joueur1);
				joueurs.add(joueur2);
				joueurs.add(joueur3);
				joueurs.add(joueur4);
				
				melangerCartes(joueur1);
				melangerCartes(joueur2);
				melangerCartes(joueur3);
				melangerCartes(joueur4);
				
				Joyau joyau1 = new Joyau("R","Rose");
				Joyau joyau2 = new Joyau("B","Bleu");
				deplacerTuile(joyau1, 7, 1);
				deplacerTuile(joyau2, 7, 6);
	
				break;
			}
		}
	}

	public void deplacerTuile(Tuile tuile, int ligne, int colonne) {
		if (tuile.getLigne() != -1) {
			int ancienneLigne = tuile.getLigne();
			int ancienneColonne = tuile.getColonne();
			Tuile pionVide = new Tuile();
			pionVide.setSymbole(" ");
			contenuPlateau[ancienneLigne][ancienneColonne] = pionVide;
		}
		tuile.setLigne(ligne);
		tuile.setColonne(colonne);
		contenuPlateau[ligne][colonne] = tuile;
	}
	
	public void initialisationPlateau() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Tuile vide = new Vide();
				contenuPlateau[i][j] = vide;
			}
		}
	}
	
	public void melangerCartes(Joueur joueur) {
		
		ArrayList<Carte> listeCartes = new ArrayList<Carte>();
		for (int i = 1; i <= 18; i++) listeCartes.add(new CarteBleue());
		for (int i = 1; i <= 8; i++) listeCartes.add(new CarteJaune());
		for (int i = 1; i <= 8; i++) listeCartes.add(new CarteViolette());
		for (int i = 1; i <= 3; i++) listeCartes.add(new CarteLaser());
		ArrayDeque<Carte> pioche = new ArrayDeque<>();
		
		for (int i = 1; i <= 37; i++) {
			int indiceCartePiochee = (int) (Math.random() * (listeCartes.size()));
			Carte cartePiochee = listeCartes.get(indiceCartePiochee);
			pioche.add(cartePiochee);
			listeCartes.remove(cartePiochee);
		}
		
		joueur.setPioche(pioche);
		//System.out.println("Pioche : " + pioche);
	}
	public void melangerDefausse(Joueur joueur) {
		ArrayDeque<Carte> pioche = joueur.getPioche();
		List<Carte> defausse = joueur.getDefausse();

		System.out.println("Défausse : " + defausse);
		Collections.shuffle(defausse); // Mélanger la liste
		System.out.println("Défausse : " + defausse);

		for (int i = 0; i < defausse.size(); i++) {
			System.out.println("Pioche : " + pioche);
			pioche.add(defausse.get(i));
			defausse.remove(i);
			System.out.println("Pioche : " + pioche);
			i--;
		}

		System.out.println("Défausse : " + defausse);
	}
	
	public void piocherCarte(Joueur joueur, int i) {
		ArrayDeque<Carte> pioche = joueur.getPioche();
		ArrayList<Carte> main = joueur.getMain();
		main.add(i, pioche.getFirst());
		pioche.removeFirst();
	}
	
	public void piocherCartes(Joueur joueur) {
		
		ArrayDeque<Carte> pioche = joueur.getPioche();
		ArrayList<Carte> main = new ArrayList<Carte>();
		
		for (int i = 1; i <= 5; i++) {
			main.add(pioche.getFirst());
			pioche.removeFirst();
		}
	}
	
	/*public void piocheUneCarte(Joueur joueur){
		joueur.getMain().add(pioche.get(0));
		pioche.remove(0);
		System.out.println(joueur.getMain().toString());
	}*/
	
	public Carte cartePiochee(Joueur joueur){
		ArrayDeque<Carte> pioche = joueur.getPioche();	
		Carte carte = pioche.getFirst();
		pioche.removeFirst();
		return carte;
	}
	
	public void afficherPlateauConsole() {
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
	
	// Getters et setters
	public void setJoueur(int i, int j, Tortue joueur){
		contenuPlateau[i][j] = joueur;
	}
	public void setVide(int i, int j, Vide v){
		contenuPlateau[i][j] = v;
	}
	public List<Joueur> getJoueurs() {
		return joueurs;
	}
	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	public Tuile[][] getContenuPlateau() {
		return contenuPlateau;
	}
	public int getNbJoueurs() {
		return nbJoueurs;
	}
	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}
	public Tuile getContenuCase(int ligne, int colonne) {
		return contenuPlateau[ligne][colonne];
	}
	public void viderCase(int ligne, int colonne) {
		Tuile pionVide = new Vide();
		contenuPlateau[ligne][colonne] = pionVide;
	}

	public static int getVictoire() {
		return victoire;
	}

	public static void setVictoire(int victoire) {
		Plateau.victoire = victoire;
	}
}
