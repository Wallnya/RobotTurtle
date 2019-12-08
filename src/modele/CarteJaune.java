package modele;

public class CarteJaune extends Carte{
	
	/*Gauche*/
	@Override
	public void action(Tortue t,Plateau p) {
		switch(t.getSens()) {
		case 'S':
			t.setSens('E');
			break;
		case 'N':
			t.setSens('O');
			break;
		case 'E':
			t.setSens('N');
			break;
		case 'O':
			t.setSens('S');
			break;
		}		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "jaune";
	}

}
