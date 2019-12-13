package modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Plateau{

	private Tuile[][] plateau;
	private int nbJoueurs;
	private  List<Joueur> joueurs;
	private List<Carte> pioche = new ArrayList<Carte>();
	private List<Carte> defausse = new ArrayList<Carte>();

	public Plateau(int nbJoueurs) {
		for(int i=0;i<17;i++) {
			pioche.add(new CarteBleue());
		}
		for(int i=0;i<7;i++) {
			pioche.add(new CarteJaune());
		}
		for(int i=0;i<7;i++) {
			pioche.add(new CarteViolete());
		}
		/*for(int i=0;i<2;i++) {
			pioche.add(new CarteRouge());
		}*/
		Collections.shuffle(pioche);
		System.out.println(pioche.toString());
		
		plateau = new Tuile[8][8];
		this.setNbJoueurs(nbJoueurs);
		this.remplir();
		joueurs = new ArrayList<Joueur>();
		switch(nbJoueurs) {
		case 2:
			setMur();

			Joueur j1 = new Joueur(1);
			Tortue t1 = new Tortue(1,'S',0,1);
			j1.setTortue(t1);
			setJoueur(0,1,t1);

			Joueur j2 = new Joueur(2);
			Tortue t2 = new Tortue(2,'S',0,5);
			j2.setTortue(t2);
			setJoueur(0,5,t2);

			setJoyau(7,3);

			joueurs.add(j1);
			joueurs.add(j2);
			
			piocherCartes(j1);
			piocherCartes(j2);
			break;
		case 3:
			setMur();
			j1 = new Joueur(1);
			t1 = new Tortue(1,'S',0,0);
			j1.setTortue(t1);
			setJoueur(0,0,t1);

			j2 = new Joueur(2);
			t2 = new Tortue(2,'S',0,3);
			j2.setTortue(t2);
			setJoueur(0,3,t2);

			Joueur j3 = new Joueur(3);
			Tortue t3 = new Tortue(3,'S',0,6);
			j3.setTortue(t3);
			setJoueur(0,6,t3);

			setJoyau(7,0);
			setJoyau(7,3);
			setJoyau(7,6);

			joueurs.add(j1);
			joueurs.add(j2);
			joueurs.add(j3);
			
			piocherCartes(j1);
			piocherCartes(j2);
			piocherCartes(j3);

			break;
		case 4:

			j1 = new Joueur(1);
			t1 = new Tortue(1,'S',0,0);
			j1.setTortue(t1);
			setJoueur(0,0,t1);

			j2 = new Joueur(2);
			t2 = new Tortue(2,'S',0,2);
			j2.setTortue(t2);
			setJoueur(0,2,t2);

			j3 = new Joueur(3);
			t3 = new Tortue(3,'S',0,5);
			setJoueur(0,5,t3);
			j3.setTortue(t3);

			Joueur j4 = new Joueur(4);
			Tortue t4 = new Tortue(4,'S',0,7);
			j4.setTortue(t4);
			setJoueur(0,7,t4);

			setJoyau(7,1);
			setJoyau(7,6);
			
			joueurs.add(j1);
			joueurs.add(j2);
			joueurs.add(j3);
			joueurs.add(j4);
			
			piocherCartes(j1);
			piocherCartes(j2);
			piocherCartes(j3);
			piocherCartes(j4);

			break;
		}
	}

	public  List<Joueur> getJoueurs() {
		return joueurs;
	}

	public  void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
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
	
	public void piocherCartes(Joueur joueur) {
		for (int i = 1; i <= 5; i++) {
			joueur.getMain().add(pioche.get(i-1));
			pioche.remove(i-1);
		}
		System.out.println(joueur.getMain().toString());
	}
	
	public void piocheUneCarte(Joueur joueur){
		joueur.getMain().add(pioche.get(0));
		pioche.remove(0);
		System.out.println(joueur.getMain().toString());
	}
	
	public Carte piocheUneCarte(){
		Carte carte = pioche.get(0);
		pioche.remove(0);
		return carte;
	}
	

	public List<Carte> getPioche() {
		return pioche;
	}

	public void setPioche(List<Carte> pioche) {
		this.pioche = pioche;
	}

	public List<Carte> getDefausse() {
		return defausse;
	}

	public void setDefausse(List<Carte> defausse) {
		this.defausse = defausse;
	}

	public int getNbJoueurs() {
		return nbJoueurs;
	}

	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}
}
