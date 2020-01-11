import java.util.ArrayDeque;
import java.util.ArrayList;

public class Joueur {

	private int num;
	private Tortue tortue;
	private ArrayDeque<Carte> pioche = new ArrayDeque<>();
	private ArrayDeque<Carte> defausse = new ArrayDeque<>();
	private ArrayList<Carte> main = new ArrayList<Carte>();
	private ArrayDeque<Carte> programme = new ArrayDeque<>();
	private int nbObstaclePierre = 3;
	private int nbObstacleGlace = 2;
	
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

	public ArrayDeque<Carte> getProgramme() {
		return programme;
	}

	public Tortue getTortue() {
		return tortue;
	}

	public ArrayList<Carte> getMain() {
		return main;
	}
	
	
}
