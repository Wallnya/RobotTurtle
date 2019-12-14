package modele;

public class CarteLaser extends Carte {

	public String couleur = "Laser";

	@Override
	public String toString() {
		return couleur;
	}
	
	/*Laser*/
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
			t.setSens('S');
			break;
		case 'O':
			t.setSens('N');
			break;
		}		
	}

}
