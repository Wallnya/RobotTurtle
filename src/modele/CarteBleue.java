package modele;

public class CarteBleue extends Carte{
	@Override
	public String toString() {
		return "bleu";
	}

	/*Avancer*/
	@Override
	public void action(Tortue t,Plateau p) {
		
		switch(t.getSens()) {
		case 'S':
			/*Si tu tapes un obstacle, tu fais demi-tour. Ou que tu es hors du terrain*/
			if ((t.getLigne()+1 > 7) || (p.getPlateau()[t.getLigne()+1][t.getColonne()] instanceof Obstacle)){
				t.setSens('N');
			}
			/*Si je tape une tortue*/
			else if ((p.getPlateau()[t.getLigne()+1][t.getColonne()] instanceof Tortue)) {
					/*On les remet au départ*/
					Tortue t2 = (Tortue) p.getPlateau()[t.getLigne()+1][t.getColonne()];
					p.setJoueur(t.getLigne_debut(), t.getColonne_debut(), t);
					p.setJoueur(t2.getLigne_debut(), t2.getColonne_debut(), t2);
					/*Et on met les anciennes cases à vide*/
					p.setVide(t.getLigne(), t.getColonne(), new Vide());
					p.setVide(t.getLigne()+1, t.getColonne(), new Vide());
					/*Et on remet on synchronise les positions.*/
					t.setLigne(t.getLigne_debut());
					t.setColonne(t.getColonne_debut());
					t2.setLigne(t2.getLigne_debut());
					t2.setColonne(t2.getColonne_debut());
			}
			/*Sinon t'avances*/
			else {
				t.setLigne(t.getLigne()+1);
				p.setJoueur(t.getLigne(), t.getColonne(), t);
				p.setVide(t.getLigne()-1, t.getColonne(), new Vide());
			}
			break;
		case 'N':
			if((t.getLigne()-1 < 0) || (p.getPlateau()[t.getLigne()-1][t.getColonne()] instanceof Obstacle) ){
				t.setSens('S');
			}
			/*Si je tape une tortue*/
			else if ((p.getPlateau()[t.getLigne()-1][t.getColonne()] instanceof Tortue)) {
					Tortue t2 = (Tortue) p.getPlateau()[t.getLigne()-1][t.getColonne()];
					p.setJoueur(t.getLigne_debut(), t.getColonne_debut(), t);
					p.setJoueur(t2.getLigne_debut(), t2.getColonne_debut(), t2);
					
					p.setVide(t.getLigne(), t.getColonne(), new Vide());
					p.setVide(t.getLigne()-1, t.getColonne(), new Vide());
					/*Et on remet on synchronise les positions.*/
					t.setLigne(t.getLigne_debut());
					t.setColonne(t.getColonne_debut());
					t2.setLigne(t2.getLigne_debut());
					t2.setColonne(t2.getColonne_debut());
			}
			else {
				t.setLigne(t.getLigne()-1);
				p.setJoueur(t.getLigne(), t.getColonne(), t);
				p.setVide(t.getLigne()+1, t.getColonne(), new Vide());
			}
			break;
		case 'E':
			if( (t.getColonne()+1 > 7) || (p.getPlateau()[t.getLigne()][t.getColonne()+1] instanceof Obstacle)){
				t.setSens('O');
			}
			/*Si je tape une tortue*/
			else if ((p.getPlateau()[t.getLigne()][t.getColonne()+1] instanceof Tortue)) {
					Tortue t2 = (Tortue) p.getPlateau()[t.getLigne()][t.getColonne()+1];
					p.setJoueur(t.getLigne_debut(), t.getColonne_debut(), t);
					p.setJoueur(t2.getLigne_debut(), t2.getColonne_debut(), t2);
					
					p.setVide(t.getLigne(), t.getColonne(), new Vide());
					p.setVide(t.getLigne(), t.getColonne()+1, new Vide());
					/*Et on remet on synchronise les positions.*/
					t.setLigne(t.getLigne_debut());
					t.setColonne(t.getColonne_debut());
					t2.setLigne(t2.getLigne_debut());
					t2.setColonne(t2.getColonne_debut());
			}
			else {
				t.setColonne(t.getColonne()+1);
				p.setJoueur(t.getLigne(), t.getColonne(), t);
				p.setVide(t.getLigne(), t.getColonne()-1, new Vide());
			}
			break;
		case 'O':
			if((t.getColonne()-1 < 0 ) ||(p.getPlateau()[t.getLigne()][t.getColonne()-1] instanceof Obstacle)){ 
				t.setSens('E');
			}
			/*Si je tape une tortue*/
			else if ((p.getPlateau()[t.getLigne()][t.getColonne()-1] instanceof Tortue)) {
					Tortue t2 = (Tortue) p.getPlateau()[t.getLigne()][t.getColonne()-1];
					p.setJoueur(t.getLigne_debut(), t.getColonne_debut(), t);
					p.setJoueur(t2.getLigne_debut(), t2.getColonne_debut(), t2);
					
					p.setVide(t.getLigne(), t.getColonne(), new Vide());
					p.setVide(t.getLigne(), t.getColonne()-1, new Vide());
					
					/*Et on remet on synchronise les positions.*/
					t.setLigne(t.getLigne_debut());
					t.setColonne(t.getColonne_debut());
					t2.setLigne(t2.getLigne_debut());
					t2.setColonne(t2.getColonne_debut());
			}
			else {
				t.setColonne(t.getColonne()-1);
				p.setJoueur(t.getLigne(), t.getColonne(), t);
				p.setVide(t.getLigne(), t.getColonne()+1, new Vide());
			}
			break;
		}	
		System.out.println("----------------------------------------------");
		System.out.println("x : "+t.getLigne()+ " | y :"+t.getColonne());
		System.out.println("----------------------------------------------");
	}
}
