import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Partie {
	
	private Plateau plateau;
	private Scanner scanner = new Scanner(System.in);
	private int nbJoueurs;
	private Joueur joueurEnCours;
	
	
	public void run() {
		
		plateau = new Plateau();
        plateau.initialisationPlateau();
        plateau.preparationPlateau(nbJoueurs);
        initialisation();
        plateau.afficherPlateau();
        demarrer();
		
    }

	public void initialisation() {
		
		Tortue tortue1 = plateau.tortues.get(0);
		Tortue tortue2 = plateau.tortues.get(1);
		Joyau joyau1 = plateau.joyaux.get(0);
		Joueur joueur1 = plateau.joueurs.get(0);
		Joueur joueur2 = plateau.joueurs.get(1);
		
		switch (nbJoueurs) {
			case 2: {
				for (int i = 0; i <= 7; i++){
					ObstaclePierre obstaclePierre = new ObstaclePierre();
					plateau.deplacerPion(obstaclePierre, i, 7);
				}
				plateau.deplacerPion(tortue1, 0, 1);
				plateau.deplacerPion(tortue2, 0, 5);
				plateau.deplacerPion(joyau1, 7, 3);
				melangerCartes(joueur1);
				melangerCartes(joueur2);
				piocherCartes(joueur1);
				piocherCartes(joueur2);
				break;
			}
			case 3: {
				for (int i = 0; i <= 7; i++){
					ObstaclePierre obstaclePierre = new ObstaclePierre();
					plateau.deplacerPion(obstaclePierre, i, 7);
				}
				Tortue tortue3 = plateau.tortues.get(2);
				Joyau joyau2 = plateau.joyaux.get(1);
				Joyau joyau3 = plateau.joyaux.get(2);
				Joueur joueur3 = plateau.joueurs.get(2);
				plateau.deplacerPion(tortue1, 0, 0);
				plateau.deplacerPion(tortue2, 0, 3);
				plateau.deplacerPion(tortue3, 0, 6);
				plateau.deplacerPion(joyau1, 7, 0);
				plateau.deplacerPion(joyau2, 7, 3);
				plateau.deplacerPion(joyau3, 7, 6);
				melangerCartes(joueur1);
				melangerCartes(joueur2);
				melangerCartes(joueur3);
				piocherCartes(joueur1);
				piocherCartes(joueur2);
				piocherCartes(joueur3);
				break;
			}
			case 4 :{
				Tortue tortue3 = plateau.tortues.get(2);
				Tortue tortue4 = plateau.tortues.get(3);
				Joyau joyau2 = plateau.joyaux.get(1);
				Joueur joueur3 = plateau.joueurs.get(2);
				Joueur joueur4 = plateau.joueurs.get(3);
				plateau.deplacerPion(tortue1, 0, 0);
				plateau.deplacerPion(tortue2, 0, 2);
				plateau.deplacerPion(tortue3, 0, 5);
				plateau.deplacerPion(tortue4, 0, 7);
				plateau.deplacerPion(joyau1, 7, 1);
				plateau.deplacerPion(joyau2, 7, 6);
				melangerCartes(joueur1);
				melangerCartes(joueur2);
				melangerCartes(joueur3);
				melangerCartes(joueur4);
				piocherCartes(joueur1);
				piocherCartes(joueur2);
				piocherCartes(joueur3);
				piocherCartes(joueur4);
				break;
			}
		}
		joueurEnCours = plateau.getJoueurByNum(1);
	}
	
	public void demarrer() {
		
		int reponse;
		do {
			do {
			System.out.println("Joueur " + joueurEnCours.getNum() + ", � vous de jouer !\n"
					+ "- 1 : Compl�ter votre programme\n"
					+ "- 2 : Construire un mur\n"
					+ "- 3 : Ex�cuter votre programme\n");
			reponse = Integer.parseInt(scanner.nextLine());
			} while (reponse < 1 || reponse > 3);
			
			
			switch(reponse) {
				case 1 :
					completerProgramme();	
					break;
				case 2 :
					placerObstacle();
					plateau.afficherPlateau();
					break;
				case 3 :
					executerProgramme();
					break;
			}
			changementTour();	
		} while (true);
	}
	
	public void executerProgramme(){
		System.out.println(joueurEnCours.programme);
		plateau.afficherPlateau();
		for (Carte carte : joueurEnCours.programme) {
			switch (carte.getCouleur()) {
			// ................................
			}
		}
	}
	
	public void placerObstacle() {
		String reponse;
		boolean ok = false;
		do {
			System.out.println("Type d'obstacle (Pierre/Glace) :");
			reponse = scanner.nextLine();
		} while (!reponse.equals("Pierre") && !reponse.equals("Glace"));
		
		if (reponse.equals("Pierre")) {
			int nbPierre = joueurEnCours.getNbObstaclePierre();
			if (nbPierre > 0) {
				joueurEnCours.setNbObstaclePierre(nbPierre - 1);
				ok = true;
			} else {
				System.out.println("Aucun mur de pierre � poser.");
			}
			
		} else {
			int nbGlace = joueurEnCours.getNbObstacleGlace();
			if (nbGlace > 0) {
				joueurEnCours.setNbObstaclePierre(nbGlace - 1);
				
				ok = true;
			} else {
				System.out.println("Aucun mur de glace � poser.");
			}
		}
		
		if (ok) {
			int ligne;
			int colonne;
			boolean continuer = false;
			do {
				do {
					System.out.println("Ligne :");
					ligne = Integer.parseInt(scanner.nextLine());
					System.out.println("Colonne :");
					colonne = Integer.parseInt(scanner.nextLine());
				} while (ligne > 7 || ligne < 0 || colonne > 7 || colonne < 0);
				
				if (plateau.caseLibre(ligne, colonne)) {
					if (reponse.equals("Pierre")) {
						ObstaclePierre pierre = new ObstaclePierre();
						plateau.deplacerPion(pierre, ligne, colonne);
						continuer = true;
					} else {
						ObstacleGlace glace = new ObstacleGlace();
						plateau.deplacerPion(glace, ligne, colonne);
						continuer = true;
					}
				} else {
					System.out.println("Case d�j� occup�e.");
				}
			} while(continuer == false);
		}
		
		
	}
	
	public void completerProgramme() {
		
		System.out.println("Votre main : " + joueurEnCours.main);
		
		String reponseCouleur;
		Carte reponseCarte;

		int i = 1;
		do {
			if (i == 1) {
				System.out.println("Carte " + i + " � placer :");
			} else {
				System.out.println("Carte " + i + " � placer (ou stop) :");
			}
			reponseCouleur = scanner.nextLine();
			if ((i == 1 && !reponseCouleur.equals("stop")) || (!reponseCouleur.equals("stop") && i != 1)) {
				reponseCarte = new Carte(reponseCouleur);
				if (!isCarteInMain(reponseCarte)) {
					System.out.println("Carte indisponible.");
				} else {
					joueurEnCours.programme.addLast(reponseCarte);
					removeCarteFromMain(reponseCarte);
					i++;
				}
			}
			System.out.println("Programme : " + joueurEnCours.programme);
			System.out.println("Main : " + joueurEnCours.main);
			
		} while ((i <= 5 && !reponseCouleur.equals("stop")) || (i == 1 && reponseCouleur.equals("stop")));
		
	}

	public void changementTour() {
		int num = joueurEnCours.getNum();
		if (num < nbJoueurs) {
			num++;
		} else {
			num = 1;
		}
		joueurEnCours = plateau.getJoueurByNum(num);
	}
	
	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

	public void melangerCartes(Joueur joueur) {
		
		ArrayList<Carte> listeCartes = new ArrayList<Carte>();
		for (int i = 1; i <= 18; i++) listeCartes.add(new Carte("Bleu"));
		for (int i = 1; i <= 8; i++) listeCartes.add(new Carte("Jaune"));
		for (int i = 1; i <= 8; i++) listeCartes.add(new Carte("Violet"));
		for (int i = 1; i <= 3; i++) listeCartes.add(new Carte("Laser"));
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

	public boolean isCarteInMain(Carte carte) {
		Iterator<Carte> iterator = joueurEnCours.main.iterator();
        while (iterator.hasNext()) {
        	Carte carteMain = iterator.next();
            if (carteMain.getCouleur().equals(carte.getCouleur())) {
                return true;
            }
        }
        return false;
	}

	public void removeCarteFromMain(Carte carte) {
		for (Carte carteMain : joueurEnCours.main) {
			if (carteMain.getCouleur().equals(carte.getCouleur())) {
            	joueurEnCours.main.remove(carteMain);
            	break;
            }
		}
	}
}






