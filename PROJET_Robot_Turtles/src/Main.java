import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bienvenue dans Robot Turtles !");
		int reponse;
		reponse = 2;
		/*do {
			System.out.println("Nombre de joueurs (2, 3 ou 4) :");
			reponse = Integer.parseInt(scanner.nextLine());
		} while (reponse < 2 || reponse > 4);*/
		
		Partie partie = new Partie();
		partie.setNbJoueurs(reponse);
		partie.run();
	}	
}
