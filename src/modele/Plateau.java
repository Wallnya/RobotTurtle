package modele;

public class Plateau{

	private Tuile[][] plateau;
	private int nbJoueurs;
	
	/*
	 * plateau[0][0]=new Obstacles();
	 * if(plateau[0][0] instanceof Obstacles){
	 * Ostables o = (Obstacles) plateau[0][0];
	 * o.getkflmkmlds();
	 * */
	
	public int getNbJoueurs() {
		return nbJoueurs;
	}

	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

	public Plateau(int nbJoueurs) {
		plateau = new Tuile[8][8];
		this.setNbJoueurs(nbJoueurs);
		this.remplir();
		switch(nbJoueurs) {
		case 2:
			setMur();
			//Positionnement des joueurs
			for(int i=0;i<nbJoueurs;i++) {
				Tortue t1 = new Tortue(1,'S',0,1);
				setJoueur(0,1,t1);
				Tortue t2 = new Tortue(2,'S',0,5);
				setJoueur(0,5,t2);
			}
			setJoyau(7,3);
			break;
		case 3:
			//Positionnement des joueurs
			for(int i=0;i<nbJoueurs;i++) {
				Tortue t1 = new Tortue(1,'S',0,0);
				setJoueur(0,0,t1);
				Tortue t2 = new Tortue(2,'S',0,3);
				setJoueur(0,3,t2);
				Tortue t3 = new Tortue(3,'S',0,6);
				setJoueur(0,6,t3);
			}
			setJoyau(7,0);
			setJoyau(7,3);
			setJoyau(7,6);
			setMur();
			break;
		case 4:
			//Positionnement des joueurs
			for(int i=0;i<nbJoueurs;i++) {
				Tortue t1 = new Tortue(1,'S',0,0);
				setJoueur(0,0,t1);
				Tortue t2 = new Tortue(2,'S',0,2);
				setJoueur(0,2,t2);
				Tortue t3 = new Tortue(3,'S',0,5);
				setJoueur(0,5,t3);
				Tortue t4 = new Tortue(4,'S',0,7);
				setJoueur(0,7,t4);
			}
			setJoyau(7,1);
			setJoyau(7,6);
			break;
		}
	}
	
	public void setJoueur(int i, int j, Tortue joueur){
		plateau[i][j] = joueur;
	}
	
	public void setVide(int i, int j, Vide v){
		plateau[i][j] = v;
	}
	
	public void affichage() {
		for(int i=0;i<8;i++) {
			for(int j =0;j<8;j++) {
				 if(plateau[i][j] instanceof Tortue){
					 Tortue o = (Tortue) plateau[i][j];
					 o.coucou();
				 }
				plateau[i][j].test();
			}
			System.out.println();
		}
	}
	
	public void remplir() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				Tuile vide = new Vide();
				plateau[i][j]= vide;
			}
		}
	}
	
	public Tuile[][] getPlateau() {
		return plateau;
	}

	public void setPlateau(Tuile[][] plateau) {
		this.plateau = plateau;
	}

	public void setMur() {
		for(int i=0;i<8;i++) {
			for(int j=7;j<=7;j++) {
				Tuile mur = new Mur();
				plateau[i][j]= mur;
			}
		}
	}
	
	public void setJoyau(int i, int j){
		Tuile joyau = new Joyau();
		plateau[i][j] = joyau;
	}
	
}
