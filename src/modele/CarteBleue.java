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
			if ((t.getX()+1 > 7) || (p.getPlateau()[t.getX()+1][t.getY()] instanceof Obstacle)){
				t.setSens('N');
			}
			/*Si je tape une tortue*/
			else if ((p.getPlateau()[t.getX()+1][t.getY()] instanceof Tortue)) {
					/*On les remet au départ*/
					Tortue t2 = (Tortue) p.getPlateau()[t.getX()+1][t.getY()];
					p.setJoueur(t.getX_debut(), t.getY_debut(), t);
					p.setJoueur(t2.getX_debut(), t2.getY_debut(), t2);
					/*Et on met les anciennes cases à vide*/
					p.setVide(t.getX(), t.getY(), new Vide());
					p.setVide(t.getX()+1, t.getY(), new Vide());
					/*Et on remet on synchronise les positions.*/
					t.setX(t.getX_debut());
					t.setY(t.getY_debut());
					t2.setX(t2.getX_debut());
					t2.setY(t2.getY_debut());
			}
			/*Sinon t'avances*/
			else {
				t.setX(t.getX()+1);
				p.setJoueur(t.getX(), t.getY(), t);
				p.setVide(t.getX()-1, t.getY(), new Vide());
			}
			break;
		case 'N':
			if((t.getX()-1 < 0) || (p.getPlateau()[t.getX()-1][t.getY()] instanceof Obstacle) ){
				t.setSens('S');
			}
			/*Si je tape une tortue*/
			else if ((p.getPlateau()[t.getX()-1][t.getY()] instanceof Tortue)) {
					Tortue t2 = (Tortue) p.getPlateau()[t.getX()-1][t.getY()];
					p.setJoueur(t.getX_debut(), t.getY_debut(), t);
					p.setJoueur(t2.getX_debut(), t2.getY_debut(), t2);
					
					p.setVide(t.getX(), t.getY(), new Vide());
					p.setVide(t.getX()-1, t.getY(), new Vide());
					/*Et on remet on synchronise les positions.*/
					t.setX(t.getX_debut());
					t.setY(t.getY_debut());
					t2.setX(t2.getX_debut());
					t2.setY(t2.getY_debut());
			}
			else {
				t.setX(t.getX()-1);
				p.setJoueur(t.getX(), t.getY(), t);
				p.setVide(t.getX()+1, t.getY(), new Vide());
			}
			break;
		case 'E':
			if( (t.getY()+1 > 7) || (p.getPlateau()[t.getX()][t.getY()+1] instanceof Obstacle)){
				t.setSens('O');
			}
			/*Si je tape une tortue*/
			else if ((p.getPlateau()[t.getX()][t.getY()+1] instanceof Tortue)) {
					Tortue t2 = (Tortue) p.getPlateau()[t.getX()][t.getY()+1];
					p.setJoueur(t.getX_debut(), t.getY_debut(), t);
					p.setJoueur(t2.getX_debut(), t2.getY_debut(), t2);
					
					p.setVide(t.getX(), t.getY(), new Vide());
					p.setVide(t.getX(), t.getY()+1, new Vide());
					/*Et on remet on synchronise les positions.*/
					t.setX(t.getX_debut());
					t.setY(t.getY_debut());
					t2.setX(t2.getX_debut());
					t2.setY(t2.getY_debut());
			}
			else {
				t.setY(t.getY()+1);
				p.setJoueur(t.getX(), t.getY(), t);
				p.setVide(t.getX(), t.getY()-1, new Vide());
			}
			break;
		case 'O':
			if((t.getY()-1 < 0 ) ||(p.getPlateau()[t.getX()][t.getY()-1] instanceof Obstacle)){ 
				t.setSens('E');
			}
			/*Si je tape une tortue*/
			else if ((p.getPlateau()[t.getX()][t.getY()-1] instanceof Tortue)) {
					Tortue t2 = (Tortue) p.getPlateau()[t.getX()][t.getY()-1];
					p.setJoueur(t.getX_debut(), t.getY_debut(), t);
					p.setJoueur(t2.getX_debut(), t2.getY_debut(), t2);
					
					p.setVide(t.getX(), t.getY(), new Vide());
					p.setVide(t.getX(), t.getY()-1, new Vide());
					
					/*Et on remet on synchronise les positions.*/
					t.setX(t.getX_debut());
					t.setY(t.getY_debut());
					t2.setX(t2.getX_debut());
					t2.setY(t2.getY_debut());
			}
			else {
				t.setY(t.getY()-1);
				p.setJoueur(t.getX(), t.getY(), t);
				p.setVide(t.getX(), t.getY()+1, new Vide());
			}
			break;
		}	
		System.out.println("----------------------------------------------");
		System.out.println("x : "+t.getX()+ " | y :"+t.getY());
		System.out.println("----------------------------------------------");
	}
}
