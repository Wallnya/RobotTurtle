package modele;

public abstract class Carte {
	
	public String couleur;
	public abstract void action(Tortue t, Plateau p);

	public String getCouleur() {
		return couleur;
	}

}
