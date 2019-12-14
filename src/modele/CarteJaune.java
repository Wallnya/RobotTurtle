package modele;

public class CarteJaune extends Carte{
	
	public String couleur = "Jaune";
	
	@Override
	public String toString() {
		return couleur;
	}
	
	// Pivoter vers la gauche
	@Override
	public void action(Tortue tortue, Plateau plateau) {
		
		switch(tortue.getSens()) {
			case 'S':
				tortue.setSens('E');
				break;
			case 'N':
				tortue.setSens('O');
				break;
			case 'E':
				tortue.setSens('N');
				break;
			case 'O':
				tortue.setSens('S');
				break;
			}		
	}



}
