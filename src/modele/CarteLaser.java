package modele;

public class CarteLaser extends Carte {

	public String couleur = "Laser";

	@Override
	public String toString() {
		return couleur;
	}
	
	// Laser
	@Override
	public void action(Tortue tortue, Plateau plateau) {
		
		char sens = tortue.getSens();
		int ligne = tortue.getLigne();
		int colonne = tortue.getColonne();
		
		int i;
		Tuile premiereTuile = new Tuile();
		Tuile tuileCaseActuelle;
		boolean tuileTrouve = false;
		
		switch(sens) {
			case ('N') : 
				for (i = ligne - 1; i >= 0; i--) {
					tuileCaseActuelle = plateau.getContenuCase(i, colonne);
					if (tuileCaseActuelle.getSymbole() != " ") {
						premiereTuile = tuileCaseActuelle;
						tuileTrouve = true;
						break;
					}
				}
				break;
			case ('O') : 
				for (i = colonne - 1; i >= 0; i--) {
					tuileCaseActuelle = plateau.getContenuCase(ligne, i);
					if (tuileCaseActuelle.getSymbole() != " ") {
						premiereTuile = tuileCaseActuelle;
						tuileTrouve = true;
						break;
					}
				}
				break;
			case ('S') : 
				for (i = ligne + 1; i <= 7; i++) {
					tuileCaseActuelle = plateau.getContenuCase(i, colonne);
					if (tuileCaseActuelle.getSymbole() != " ") {
						premiereTuile = tuileCaseActuelle;
						tuileTrouve = true;
						break;
					}
				}
				break;
			case ('E') : 
				for (i = colonne + 1; i <= 7; i++) {
					tuileCaseActuelle = plateau.getContenuCase(ligne, i);
					if (tuileCaseActuelle.getSymbole() != " ") {
						premiereTuile = tuileCaseActuelle;
						tuileTrouve = true;
						break;
					}
				}
				break;
		};
		if (tuileTrouve == false) {
			System.out.println("Aucun obstacle en vue !");
		} else {
			switch (premiereTuile.getSymbole()) {
				case "1" : case "2" : case "3" : case "4" :
					System.out.println("Vous avez touché un joueur !");
					Tortue tortueTouchee = (Tortue) premiereTuile;
					
					// Si 2 joueurs, demi-tour
					if (plateau.getNbJoueurs() == 2) {
						switch (tortueTouchee.getSens()) {
						case 'N' : tortueTouchee.setSens('S'); break;
						case 'S' : tortueTouchee.setSens('N'); break;
						case 'O' : tortueTouchee.setSens('E'); break;
						case 'E' : tortueTouchee.setSens('O'); break;
						}
					} 
					// Sinon, case départ
					else {
						plateau.viderCase(tortueTouchee.getLigne(), tortueTouchee.getColonne());
						plateau.setJoueur(tortueTouchee.getLigne_debut(), tortueTouchee.getColonne_debut(), tortueTouchee);
					}
					
					break;
				case "R" : case "V" : case "B" :
					System.out.println("Un joyau a bloqué votre laser.");
					break;
				case "P" :
					System.out.println("Le mur de pierre est indestructible !");
					break;
				case "G" :
					plateau.viderCase(premiereTuile.getLigne(), premiereTuile.getColonne());
					System.out.println("Le mur de glace a été détruit !");
					break;
			}
		}
	}

}
