package modele;

public class CarteBleue extends Carte{
	
	public String couleur = "Bleu";
	
	@Override
	public String toString() {
		return couleur;
	}
	
	// Avancer
	@Override
	public void action(Tortue tortue, Plateau plateau) {
		
		switch(tortue.getSens()) {
			case SUD:
				// Si on sort du terrain : position de départ.
				if ((tortue.getLigne() + 1 > 7) ) {
					// On la remet au départ.
					plateau.setJoueur(tortue.getLigne_debut(), tortue.getColonne_debut(), tortue);
					// Et on met l'ancienne case à vide
					plateau.setVide(tortue.getLigne(), tortue.getColonne(), new Vide());
					// On synchronise l positions
					tortue.setLigne(tortue.getLigne_debut());
					tortue.setColonne(tortue.getColonne_debut());
				}
				/* Si obstacle, on fait demi-tour*/
				else if((plateau.getContenuPlateau()[tortue.getLigne()+1][tortue.getColonne()] instanceof ObstaclePierre)
						|| (plateau.getContenuPlateau()[tortue.getLigne()+1][tortue.getColonne()] instanceof ObstacleGlace)){
					tortue.setSens(Sens.NORD);
				}
				
				// Si rencontre une tortue
				else if ((plateau.getContenuPlateau()[tortue.getLigne()+1][tortue.getColonne()] instanceof Tortue)) {
					// On les remet au d�part
					Tortue tortue2 = (Tortue) plateau.getContenuPlateau()[tortue.getLigne()+1][tortue.getColonne()];
					plateau.setJoueur(tortue.getLigne_debut(), tortue.getColonne_debut(), tortue);
					plateau.setJoueur(tortue2.getLigne_debut(), tortue2.getColonne_debut(), tortue2);
					// Et on met les anciennes cases � vide
					plateau.setVide(tortue.getLigne(), tortue.getColonne(), new Vide());
					plateau.setVide(tortue.getLigne()+1, tortue.getColonne(), new Vide());
					// On synchronise les positions
					tortue.setLigne(tortue.getLigne_debut());
					tortue.setColonne(tortue.getColonne_debut());
					tortue2.setLigne(tortue2.getLigne_debut());
					tortue2.setColonne(tortue2.getColonne_debut());
				}
				// Sinon, la tortue avance
				else {
					tortue.setLigne(tortue.getLigne() + 1);
					plateau.setJoueur(tortue.getLigne(), tortue.getColonne(), tortue);
					plateau.setVide(tortue.getLigne() - 1, tortue.getColonne(), new Vide());
				}
				break;
				
			case NORD:
				// Si on sort du terrain : position de départ.
				if(tortue.getLigne()-1 < 0) {
					// On la remet au départ.
					plateau.setJoueur(tortue.getLigne_debut(), tortue.getColonne_debut(), tortue);
					// Et on met l'ancienne case à vide
					plateau.setVide(tortue.getLigne(), tortue.getColonne(), new Vide());
					// On synchronise l positions
					tortue.setLigne(tortue.getLigne_debut());
					tortue.setColonne(tortue.getColonne_debut());
					tortue.setSens(Sens.SUD);
				}
				/* Si obstacle, on fait demi-tour*/
				else if((plateau.getContenuPlateau()[tortue.getLigne()-1][tortue.getColonne()] instanceof ObstaclePierre)
						|| (plateau.getContenuPlateau()[tortue.getLigne()-1][tortue.getColonne()] instanceof ObstacleGlace)){
					tortue.setSens(Sens.SUD);
				}
				
				// Si rencontre une tortue
				else if ((plateau.getContenuPlateau()[tortue.getLigne()-1][tortue.getColonne()] instanceof Tortue)) {
						Tortue tortue2 = (Tortue) plateau.getContenuPlateau()[tortue.getLigne()-1][tortue.getColonne()];
						plateau.setJoueur(tortue.getLigne_debut(), tortue.getColonne_debut(), tortue);
						plateau.setJoueur(tortue2.getLigne_debut(), tortue2.getColonne_debut(), tortue2);
						
						plateau.setVide(tortue.getLigne(), tortue.getColonne(), new Vide());
						plateau.setVide(tortue.getLigne()-1, tortue.getColonne(), new Vide());
						
						tortue.setLigne(tortue.getLigne_debut());
						tortue.setColonne(tortue.getColonne_debut());
						tortue2.setLigne(tortue2.getLigne_debut());
						tortue2.setColonne(tortue2.getColonne_debut());
				}
				// Sinon, la tortue avance
				else {
					tortue.setLigne(tortue.getLigne()-1);
					plateau.setJoueur(tortue.getLigne(), tortue.getColonne(), tortue);
					plateau.setVide(tortue.getLigne()+1, tortue.getColonne(), new Vide());
				}
				break;
				
			case EST:
				// Si on sort du terrain : position de départ.
				if (tortue.getColonne()+1 > 7) {
					// On la remet au départ.
					plateau.setJoueur(tortue.getLigne_debut(), tortue.getColonne_debut(), tortue);
					// Et on met l'ancienne case à vide
					plateau.setVide(tortue.getLigne(), tortue.getColonne(), new Vide());
					// On synchronise l positions
					tortue.setLigne(tortue.getLigne_debut());
					tortue.setColonne(tortue.getColonne_debut());
					tortue.setSens(Sens.SUD);
				}
				/* Si obstacle, on fait demi-tour*/
				else if((plateau.getContenuPlateau()[tortue.getLigne()][tortue.getColonne()+1] instanceof Tortue)) {
						Tortue tortue2 = (Tortue) plateau.getContenuPlateau()[tortue.getLigne()][tortue.getColonne()+1];
						plateau.setJoueur(tortue.getLigne_debut(), tortue.getColonne_debut(), tortue);
						plateau.setJoueur(tortue2.getLigne_debut(), tortue2.getColonne_debut(), tortue2);
						
						plateau.setVide(tortue.getLigne(), tortue.getColonne(), new Vide());
						plateau.setVide(tortue.getLigne(), tortue.getColonne()+1, new Vide());
						
						tortue.setLigne(tortue.getLigne_debut());
						tortue.setColonne(tortue.getColonne_debut());
						tortue2.setLigne(tortue2.getLigne_debut());
						tortue2.setColonne(tortue2.getColonne_debut());
				}
				// Sinon, la tortue avance
				else {
					tortue.setColonne(tortue.getColonne()+1);
					plateau.setJoueur(tortue.getLigne(), tortue.getColonne(), tortue);
					plateau.setVide(tortue.getLigne(), tortue.getColonne()-1, new Vide());
				}
				break;
				
			case OUEST:
				
				// Si on sort du terrain : position de départ.
				if(tortue.getColonne()-1 < 0 ) {
					// On la remet au départ.
					plateau.setJoueur(tortue.getLigne_debut(), tortue.getColonne_debut(), tortue);
					// Et on met l'ancienne case à vide
					plateau.setVide(tortue.getLigne(), tortue.getColonne(), new Vide());
					// On synchronise l positions
					tortue.setLigne(tortue.getLigne_debut());
					tortue.setColonne(tortue.getColonne_debut());
					tortue.setSens(Sens.SUD);
				}
				/* Si obstacle, on fait demi-tour*/
				else if((plateau.getContenuPlateau()[tortue.getLigne()][tortue.getColonne()-1] instanceof Tortue)) {
						Tortue tortue2 = (Tortue) plateau.getContenuPlateau()[tortue.getLigne()][tortue.getColonne()-1];
						plateau.setJoueur(tortue.getLigne_debut(), tortue.getColonne_debut(), tortue);
						plateau.setJoueur(tortue2.getLigne_debut(), tortue2.getColonne_debut(), tortue2);
						
						plateau.setVide(tortue.getLigne(), tortue.getColonne(), new Vide());
						plateau.setVide(tortue.getLigne(), tortue.getColonne()-1, new Vide());
						
						tortue.setLigne(tortue.getLigne_debut());
						tortue.setColonne(tortue.getColonne_debut());
						tortue2.setLigne(tortue2.getLigne_debut());
						tortue2.setColonne(tortue2.getColonne_debut());
				}
				// Sinon, la tortue avance
				else {
					tortue.setColonne(tortue.getColonne()-1);
					plateau.setJoueur(tortue.getLigne(), tortue.getColonne(), tortue);
					plateau.setVide(tortue.getLigne(), tortue.getColonne()+1, new Vide());
				}
				break;
		}	
	}
}
