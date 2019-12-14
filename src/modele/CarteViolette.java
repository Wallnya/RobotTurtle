package modele;

public class CarteViolette extends Carte{

	public String couleur = "Violet";
	
	@Override
	public String toString() {
		return couleur;
	}
	
	/*Droite*/
	@Override
	public void action(Tortue t,Plateau p) {
		switch(t.getSens()) {
		case 'S':
			t.setSens('O');
			break;
		case 'N':
			t.setSens('E');
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
