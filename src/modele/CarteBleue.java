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
			if(p.getPlateau()[t.getX()+1][t.getY()] instanceof Obstacle){
				t.setSens('N');
			}
			else {
				t.setX(t.getX()+1);
				p.setJoueur(t.getX(), t.getY(), t);
				p.setVide(t.getX()-1, t.getY(), new Vide());
			}
			break;
		case 'N':
			if(p.getPlateau()[t.getX()-1][t.getY()] instanceof Obstacle){
				t.setSens('S');
			}
			else {
				t.setX(t.getX()-1);
				p.setJoueur(t.getX(), t.getY(), t);
				p.setVide(t.getX()+1, t.getY(), new Vide());
			}
			break;
		case 'E':
			if(p.getPlateau()[t.getX()][t.getY()+1] instanceof Obstacle){
				t.setSens('O');
			}
			else {
				t.setY(t.getY()+1);
				p.setJoueur(t.getX(), t.getY(), t);
				p.setVide(t.getX(), t.getY()-1, new Vide());
			}
			break;
		case 'O':
			if(p.getPlateau()[t.getX()][t.getY()-1] instanceof Obstacle){
				t.setSens('E');
			}
			else {
				t.setY(t.getY()-1);
				p.setJoueur(t.getX(), t.getY(), t);
				p.setVide(t.getX(), t.getY()+1, new Vide());
			}
			break;
		}		
	}


}
