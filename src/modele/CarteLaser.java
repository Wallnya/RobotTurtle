package modele;

public class CarteLaser extends Carte {

	public String couleur = "Laser";

	@Override
	public String toString() {
		return couleur;
	}
	
	// Laser
	@Override
	public void action(Tortue tortue, Plateau plateau) {
		
	}

}
