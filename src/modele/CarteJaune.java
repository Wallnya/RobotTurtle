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
			case SUD:
				tortue.setSens(Sens.EST);
				break;
			case NORD:
				tortue.setSens(Sens.OUEST);
				break;
			case EST:
				tortue.setSens(Sens.NORD);
				break;
			case OUEST:
				tortue.setSens(Sens.SUD);
				break;
			}		
	}



}
