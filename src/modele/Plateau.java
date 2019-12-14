package modele;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Plateau{

	private Tuile[][] plateau;
	private int nbJoueurs;
	private List<Joueur> joueurs;
	

	public void preparationPlateau(int nbJoueurs) {
		
		plateau = new Tuile[8][8];
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
				Tortue tortue1 = new Tortue(1,"1","Rouge",'S',0,1);
				joueur1.setTortue(tortue1);
				setJoueur(0,1,tortue1);
				
				Joueur joueur2 = new Joueur(2);
				Tortue tortue2 = new Tortue(2,"2","Bleu",'S',0,5);
				joueur2.setTortue(tortue2);
				setJoueur(0,5,tortue2);
				
				joueurs.add(joueur1);
				joueurs.add(joueur2);
				
				melangerCartes(joueur1);
				melangerCartes(joueur2);

				Joyau joyau1 = new Joyau("V","Vert");
				deplacerTuile(joyau1, 7, 3);
	
				for (int i = 1; i <= 5; i++) {
					piocherCarte(joueur1);
					piocherCarte(joueur2);
				}
				break;
			}
			case 3: {
				for (int i = 0; i <= 7; i++){
					ObstaclePierre obstaclePierre = new ObstaclePierre();
					deplacerTuile(obstaclePierre, i, 7);
				}
				Joueur joueur1 = new Joueur(1);
				Tortue tortue1 = new Tortue(1,"1","Rouge",'S',0,0);
				joueur1.setTortue(tortue1);
				setJoueur(0,0,tortue1);
	
				Joueur joueur2 = new Joueur(2);
				Tortue tortue2 = new Tortue(2,"2","Bleu",'S',0,3);
				joueur2.setTortue(tortue2);
				setJoueur(0,3,tortue2);
	
				Joueur joueur3 = new Joueur(3);
				Tortue tortue3 = new Tortue(3,"3","Rose",'S',0,6);
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

				for (int i = 1; i <= 5; i++) {
					piocherCarte(joueur1);
					piocherCarte(joueur2);
					piocherCarte(joueur3);
				}
	
				break;
			}
			case 4: {
	
				Joueur joueur1 = new Joueur(1);
				Tortue tortue1 = new Tortue(1,"1","Rouge",'S',0,0);
				joueur1.setTortue(tortue1);
				setJoueur(0,0,tortue1);
	
				Joueur joueur2 = new Joueur(2);
				Tortue tortue2 = new Tortue(2,"2","Bleu",'S',0,2);
				joueur2.setTortue(tortue2);
				setJoueur(0,2,tortue2);
	
				Joueur joueur3 = new Joueur(3);
				Tortue tortue3 = new Tortue(3,"3","Rose",'S',0,5);
				setJoueur(0,5,tortue3);
				joueur3.setTortue(tortue3);
	
				Joueur joueur4 = new Joueur(4);
				Tortue tortue4 = new Tortue(4,"4","Vert",'S',0,7);
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
				
				for (int i = 1; i <= 5; i++) {
					piocherCarte(joueur1);
					piocherCarte(joueur2);
					piocherCarte(joueur3);
					piocherCarte(joueur4);
				}
	
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
			plateau[ancienneLigne][ancienneColonne] = pionVide;
		}
		tuile.setLigne(ligne);
		tuile.setColonne(colonne);
		plateau[ligne][colonne] = tuile;
	}
	
	public void initialisationPlateau() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Tuile vide = new Vide();
				plateau[i][j] = vide;
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
		System.out.println(pioche);
	}
	
	public void piocherCarte(Joueur joueur) {
		
		ArrayDeque<Carte> pioche = joueur.getPioche();
		ArrayList<Carte> main = new ArrayList<Carte>();
		
		main.add(pioche.getFirst());
		pioche.removeFirst();
		
		System.out.println(main);
		joueur.setMain(main);
	}
	
	public void piocherCartes(Joueur joueur) {
		
		ArrayDeque<Carte> pioche = joueur.getPioche();
		ArrayList<Carte> main = new ArrayList<Carte>();
		
		for (int i = 1; i <= 5; i++) {
			main.add(pioche.getFirst());
			pioche.removeFirst();
		}
		System.out.println(main);
		joueur.setMain(main);
	}
	
	/*public void piocheUneCarte(Joueur joueur){
		joueur.getMain().add(pioche.get(0));
		pioche.remove(0);
		System.out.println(joueur.getMain().toString());
	}
	
	public Carte piocheUneCarte(){
		Carte carte = pioche.get(0);
		pioche.remove(0);
		return carte;
	}*/
	
	public void afficherPlateauConsole() {
    	System.out.println("    0 1 2 3 4 5 6 7 \n  +-----------------+");
    	String total = "";
    	for (int i = 0; i <= 7; i++) {
    		String ligne = i + " | ";
        	for (int j = 0; j <= 7; j++) {
        		ligne = ligne + plateau[i][j] + " ";
        	}
        	total = total + ligne + "| \n";
        }
    	System.out.println(total + "  +-----------------+");
    }

	
	
	
	
	
	
	
	public  List<Joueur> getJoueurs() {
		return joueurs;
	}

	public  void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public void setJoueur(int i, int j, Tortue joueur){
		plateau[i][j] = joueur;
	}

	public void setVide(int i, int j, Vide v){
		plateau[i][j] = v;
	}

	/*public void affichage() {
		for(int i=0;i<8;i++) {
			for(int j =0;j<8;j++) {
				if(plateau[i][j] instanceof Tortue){
					Tortue o = (Tortue) plateau[i][j];
					o.coucou();
				}
				//plateau[i][j].test();
			}
			System.out.println();
		}
	}*/

	

	public Tuile[][] getPlateau() {
		return plateau;
	}

	public void setPlateau(Tuile[][] plateau) {
		this.plateau = plateau;
	}

	/*public void setMur() {
		for(int i=0;i<8;i++) {
			for(int j=7;j<=7;j++) {
				Tuile mur = new Mur();
				plateau[i][j]= mur;
			}
		}
	}*/

	/*public void setJoyau(int i, int j){
		Tuile joyau = new Joyau();
		plateau[i][j] = joyau;
	}*/
	
	


	
	
	

	

	public int getNbJoueurs() {
		return nbJoueurs;
	}

	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}
}
