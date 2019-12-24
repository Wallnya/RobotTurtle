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
			case SUD:
				tortue.setSens(Sens.OUEST);
				break;
			case NORD:
				tortue.setSens(Sens.EST);
				break;
			case EST:
				tortue.setSens(Sens.SUD);
				break;
			case OUEST:
				tortue.setSens(Sens.NORD);
				break;
			}		
	}


}
