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
			case 'S':
				// Si obstacle ou sortie de terrain : demi-tour
				if ((tortue.getLigne() + 1 > 7) 
						|| (plateau.getContenuPlateau()[tortue.getLigne()+1][tortue.getColonne()] instanceof ObstaclePierre)
						|| (plateau.getContenuPlateau()[tortue.getLigne()+1][tortue.getColonne()] instanceof ObstacleGlace)){
					tortue.setSens('N');
				}
				
				// Si rencontre une tortue
				else if ((plateau.getContenuPlateau()[tortue.getLigne()+1][tortue.getColonne()] instanceof Tortue)) {
					// On les remet au départ
					Tortue tortue2 = (Tortue) plateau.getContenuPlateau()[tortue.getLigne()+1][tortue.getColonne()];
					plateau.setJoueur(tortue.getLigne_debut(), tortue.getColonne_debut(), tortue);
					plateau.setJoueur(tortue2.getLigne_debut(), tortue2.getColonne_debut(), tortue2);
					// Et on met les anciennes cases à vide
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
				
			case 'N':
				// Si obstacle ou sortie de terrain : demi-tour
				if((tortue.getLigne()-1 < 0) 
						|| (plateau.getContenuPlateau()[tortue.getLigne()-1][tortue.getColonne()] instanceof ObstaclePierre)
						|| (plateau.getContenuPlateau()[tortue.getLigne()-1][tortue.getColonne()] instanceof ObstacleGlace)){
					tortue.setSens('S');
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
				
			case 'E':
				// Si obstacle ou sortie de terrain : demi-tour
				if( (tortue.getColonne()+1 > 7) 
						|| (plateau.getContenuPlateau()[tortue.getLigne()][tortue.getColonne()+1] instanceof ObstaclePierre)
						|| (plateau.getContenuPlateau()[tortue.getLigne()][tortue.getColonne()+1] instanceof ObstacleGlace)){
					tortue.setSens('O');
				}
				
				// Si rencontre une tortue
				else if ((plateau.getContenuPlateau()[tortue.getLigne()][tortue.getColonne()+1] instanceof Tortue)) {
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
				
			case 'O':
				// Si obstacle ou sortie de terrain : demi-tour
				if((tortue.getColonne()-1 < 0 ) 
						|| (plateau.getContenuPlateau()[tortue.getLigne()][tortue.getColonne()-1] instanceof ObstaclePierre)
						|| (plateau.getContenuPlateau()[tortue.getLigne()][tortue.getColonne()-1] instanceof ObstacleGlace)){ 
					tortue.setSens('E');
				}
				
				// Si rencontre une tortue
				else if ((plateau.getContenuPlateau()[tortue.getLigne()][tortue.getColonne()-1] instanceof Tortue)) {
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
