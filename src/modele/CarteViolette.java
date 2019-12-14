package modele;

public class CarteViolette extends Carte{

	public String couleur = "Violet";
	
	@Override
	public String toString() {
		return couleur;
	}
	
	// Pivoter vers la droite
	@Override
	public void action(Tortue tortue, Plateau plateau) {
		switch(tortue.getSens()) {
			case 'S':
				tortue.setSens('O');
				break;
			case 'N':
				tortue.setSens('E');
				break;
			case 'E':
				tortue.setSens('S');
				break;
			case 'O':
				tortue.setSens('N');
				break;
			}		
	}


}
