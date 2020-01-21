package modele;

import javax.swing.JOptionPane;

public class CarteLaser extends Carte {

	public String couleur = "Laser";

	@Override
	public String toString() {
		return couleur;
	}
	
	// Laser
	@Override
	public void action(Tortue tortue, Plateau plateau) {
		
		Sens sens = tortue.getSens();
		int ligne = tortue.getLigne();
		int colonne = tortue.getColonne();
		
		int i;
		Tuile premiereTuile = new Tuile();
		Tuile tuileCaseActuelle;
		boolean tuileTrouve = false;
		
		switch(sens) {
			case NORD: 
				for (i = ligne - 1; i >= 0; i--) {
					tuileCaseActuelle = plateau.getContenuCase(i, colonne);
					if (tuileCaseActuelle.getSymbole() != " ") {
						premiereTuile = tuileCaseActuelle;
						tuileTrouve = true;
						break;
					}
				}
				break;
			case OUEST: 
				for (i = colonne - 1; i >= 0; i--) {
					tuileCaseActuelle = plateau.getContenuCase(ligne, i);
					if (tuileCaseActuelle.getSymbole() != " ") {
						premiereTuile = tuileCaseActuelle;
						tuileTrouve = true;
						break;
					}
				}
				break;
			case SUD :
				for (i = ligne + 1; i <= 7; i++) {
					tuileCaseActuelle = plateau.getContenuCase(i, colonne);
					if (tuileCaseActuelle.getSymbole() != " ") {
						premiereTuile = tuileCaseActuelle;
						tuileTrouve = true;
						break;
					}
				}
				break;
			case EST:
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
			JOptionPane.showConfirmDialog(null,"Aucun obstacle en vue !", 
					"Laser",JOptionPane.DEFAULT_OPTION);
		} else {
			switch (premiereTuile.getSymbole()) {
				case "1" : case "2" : case "3" : case "4" :
					System.out.println("Vous avez touché un joueur !");

					Tortue tortueTouchee = (Tortue) premiereTuile;
					
					// Si 2 joueurs, demi-tour
					if (plateau.getNbJoueurs() == 2) {
						switch (tortueTouchee.getSens()) {
						case NORD : tortueTouchee.setSens(Sens.SUD); break;
						case SUD : tortueTouchee.setSens(Sens.NORD); break;
						case OUEST : tortueTouchee.setSens(Sens.EST); break;
						case EST : tortueTouchee.setSens(Sens.OUEST); break;
						}
						JOptionPane.showConfirmDialog(null,"Vous avez touché un joueur !\n"
								+ "Sa tortue a fait demi-tour.", 
								"Laser",JOptionPane.DEFAULT_OPTION);
					} 
					// Sinon, case départ
					else {
						plateau.viderCase(tortueTouchee.getLigne(), tortueTouchee.getColonne());
						plateau.setJoueur(tortueTouchee.getLigne_debut(), tortueTouchee.getColonne_debut(), tortueTouchee);
						JOptionPane.showConfirmDialog(null,"Vous avez touché un joueur !\n"
								+ "Sa tortue est retournée à sa case de départ.", 
								"Laser",JOptionPane.DEFAULT_OPTION);
					}
					
					break;
				case "R" : case "V" : case "B" :
					System.out.println("Un joyau a réfléchi votre laser.");
					
					// Si 2 joueurs, demi-tour
					if (plateau.getNbJoueurs() == 2) {
						switch (tortue.getSens()) {
						case NORD : tortue.setSens(Sens.SUD); break;
						case SUD : tortue.setSens(Sens.NORD); break;
						case OUEST : tortue.setSens(Sens.EST); break;
						case EST : tortue.setSens(Sens.OUEST); break;
						}
						JOptionPane.showConfirmDialog(null,"Le laser s'est réfléchi sur un joyau et a touché votre tortue !\n"
								+ "Votre tortue fait demi-tour.", 
								"Laser",JOptionPane.DEFAULT_OPTION);
					} 
					// Sinon, case départ
					else {
						plateau.viderCase(tortue.getLigne(), tortue.getColonne());
						plateau.setJoueur(tortue.getLigne_debut(), tortue.getColonne_debut(), tortue);
						JOptionPane.showConfirmDialog(null,"Le laser s'est réfléchi sur un joyau et a touché votre tortue !\n"
								+ "Votre tortue retourne à sa case de départ.", 
								"Laser",JOptionPane.DEFAULT_OPTION);
					}
					
					break;
				case "P" :
					System.out.println("Le mur de pierre est indestructible !");
					JOptionPane.showConfirmDialog(null,"Vous avez touché un mur de pierre.\n"
							+ "Il est indestructible.", 
							"Laser",JOptionPane.DEFAULT_OPTION);
					break;
				case "G" :
					plateau.viderCase(premiereTuile.getLigne(), premiereTuile.getColonne());
					System.out.println("Le mur de glace a été détruit !");
					JOptionPane.showConfirmDialog(null,"Vous avez touché un mur de glace.\n"
							+ "Vous l'avez détruit !", 
							"Laser",JOptionPane.DEFAULT_OPTION);
					break;
			}
		}
	}

}
