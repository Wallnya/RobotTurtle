package modele;

public class CarteJaune extends Carte{
	
	public String couleur = "Jaune";
	
	@Override
	public String toString() {
		return couleur;
	}
	
	/*Gauche*/
	@Override
	public void action(Tortue t,Plateau p) {
		switch(t.getSens()) {
		case 'S':
			t.setSens('E');
			break;
		case 'N':
			t.setSens('O');
			break;
		case 'E':
			t.setSens('N');
			break;
		case 'O':
			t.setSens('S');
			break;
		}		
	}



}
