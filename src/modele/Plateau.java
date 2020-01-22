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
				deplacerTuile(joyau1, 7, 3);

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
				
				deplacerTuile(joyau1, 7, 0);
				deplacerTuile(joyau2, 7, 3);
				deplacerTuile(joyau3, 7, 6);

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
				vide.setLigne(i);
				vide.setColonne(j);
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
	

	public boolean caseNonBlocante(Joueur joueur, int ligne, int colonne) {
	
		ArrayDeque<Tuile> queue = new ArrayDeque<Tuile>();
		//ArrayList<Tuile> discovered = new ArrayList<Tuile>();
		ArrayList<Tuile> path = new ArrayList<Tuile>();
		
		contenuPlateau[ligne][colonne] = new ObstaclePierre();
				
		Tuile node;
		Tuile depart = joueur.getTortue();
		
		queue.addFirst(depart);

		while (!queue.isEmpty()) {
			node = queue.getLast();
			
			if (!path.contains(node)){
				
				path.add(node);
				//discovered.add(node);
				System.out.println("Path : (" + path.size() + ") : " + path);
				
				int ligneCase = node.getLigne();
				int colonneCase = node.getColonne();
				
				int ligneCaseHaut = ligneCase - 1;
				int colonneCaseHaut = colonneCase;
				int ligneCaseBas = ligneCase + 1;
				int colonneCaseBas = colonneCase;
				int ligneCaseGauche = ligneCase;
				int colonneCaseGauche = colonneCase - 1;
				int ligneCaseDroite = ligneCase;
				int colonneCaseDroite = colonneCase + 1;
				
				ArrayList<Tuile> voisins = new ArrayList<Tuile>();
				if (ligneCaseHaut >= 0 && ligneCaseHaut <= 7 && colonneCaseHaut >= 0 && colonneCaseHaut <= 7) {	
					Tuile caseHaut = contenuPlateau[ligneCaseHaut][colonneCaseHaut];
					voisins.add(caseHaut);
				}
				if (ligneCaseBas >= 0 && ligneCaseBas <= 7 && colonneCaseBas >= 0 && colonneCaseBas <= 7) {
					Tuile caseBas = new Tuile(ligneCaseBas, colonneCaseBas, contenuPlateau[ligneCaseBas][colonneCaseBas].getSymbole());
					voisins.add(caseBas);
				}
				if (ligneCaseGauche >= 0 && ligneCaseGauche <= 7 && colonneCaseGauche >= 0 && colonneCaseGauche <= 7) {
					Tuile caseGauche = new Tuile(ligneCaseGauche, colonneCaseGauche, contenuPlateau[ligneCaseGauche][colonneCaseGauche].getSymbole());
					voisins.add(caseGauche);
				}
				if (ligneCaseDroite >= 0 && ligneCaseDroite <= 7 && colonneCaseDroite >= 0 && colonneCaseDroite <= 7) {
					Tuile caseDroite = new Tuile(ligneCaseDroite, colonneCaseDroite, contenuPlateau[ligneCaseDroite][colonneCaseDroite].getSymbole());
					voisins.add(caseDroite);
				}
				
				queue.remove(node);
				for (Tuile voisin : voisins) {
					
					boolean isJoyau = false;
					if (voisin.getSymbole() == "R" || voisin.getSymbole() == "V" || voisin.getSymbole() == "B") {
						isJoyau = true;
					}
					
					// On a trouvé un chemin jusqu'à un joyau
					if (isJoyau) {
						contenuPlateau[ligne][colonne] = new Vide();
						return true;
					}
					
					boolean dejaDansPath = false;
					for (Tuile tuile : path) {
						if (voisin.equals(tuile)) {
							dejaDansPath = true;
						}
					}
					boolean dejaDansQueue = false;
					for (Tuile tuile : queue) {
						if (voisin.equals(tuile)) {
							dejaDansQueue = true;
						}
					}
					
					// Si la case est un mur de pierre, on ne passe pas par lui 
					// car ses voisins sont potentiellement inaccessibles
					if (!dejaDansPath && !dejaDansQueue && voisin.getSymbole() != "P") {
						queue.add(voisin);
					}
				}
				System.out.println("Queue : (" + queue.size() + ") : " + queue);
			}
		}
		
		// Si pas trouvé de joyau
		contenuPlateau[ligne][colonne] = new Vide();
		return false;
		
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
