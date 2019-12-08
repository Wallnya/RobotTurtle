package modele;

public class CarteRouge extends Carte{

	/*Laser*/
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
			t.setSens('S');
			break;
		case 'O':
			t.setSens('N');
			break;
		}		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "rouge";
	}

}
