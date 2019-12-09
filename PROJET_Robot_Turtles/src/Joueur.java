import java.util.ArrayDeque;
import java.util.ArrayList;

public class Joueur {

	int num;
	Tortue tortue;
	ArrayDeque<Carte> pioche = new ArrayDeque<>();
	ArrayDeque<Carte> defausse = new ArrayDeque<>();
	ArrayList<Carte> main = new ArrayList<Carte>();
	ArrayDeque<Carte> programme = new ArrayDeque<>();
	int nbObstaclePierre = 3;
	int nbObstacleGlace = 2;
	
	public Joueur(int num, Tortue tortue) {
		this.num = num;
		this.tortue = tortue;
	}

	public Joueur() {
	}

	public void setTortue(Tortue tortue) {
		this.tortue = tortue;
	}

	public void setPioche(ArrayDeque<Carte> pioche) {
		this.pioche = pioche;
	}
	public ArrayDeque<Carte> getPioche() {
		return pioche;
	}
	
	public void setMain(ArrayList<Carte> main) {
		this.main = main;
	}
	
	public String toString() {
		return "Joueur"+num;
	}

	public int getNum() {
		return num;
	}

	public int getNbObstaclePierre() {
		return nbObstaclePierre;
	}

	public void setNbObstaclePierre(int nbObstaclePierre) {
		this.nbObstaclePierre = nbObstaclePierre;
	}

	public int getNbObstacleGlace() {
		return nbObstacleGlace;
	}

	public void setNbObstacleGlace(int nbObstacleGlace) {
		this.nbObstacleGlace = nbObstacleGlace;
	}
	
	
}
