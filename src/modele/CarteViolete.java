package modele;

public class CarteViolete extends Carte{

	/*Droite*/
	@Override
	public void action(Tortue t,Plateau p) {
		switch(t.getSens()) {
		case 'S':
			t.setSens('O');
			break;
		case 'N':
			t.setSens('E');
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
		return "violette";
	}

}
