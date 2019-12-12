package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import modele.*;
import vue.*;

public class Controlleur implements ActionListener {

	private PanelNombresJoueurs panelNombresJoueurs;
	private PanelJeu chPanJeu;
	private PanelMain chPanMan;
	private int etat=1;

	public Controlleur(PanelNombresJoueurs pPanNbJoueurs) {
		panelNombresJoueurs = pPanNbJoueurs;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//choix du lancement du jeu
		if(e.getActionCommand().equals(Data.CHOIX[0])) {
			panelNombresJoueurs.add(panelNombresJoueurs,"panel_NbJoueurs");
			panelNombresJoueurs.getCardLayout().show(panelNombresJoueurs,"panel_NbJoueurs");
		}
		//choix du nombre de joueur
		else if(e.getActionCommand().equals("panelNbJoueurs_valider")) {
			try {
				chPanJeu = new PanelJeu(panelNombresJoueurs.getTaille());
			} catch (IOException e1) {e1.printStackTrace();}
			panelNombresJoueurs.add(chPanJeu, "panel_jeu");
			chPanJeu.enregistreEcouteur(this);
			panelNombresJoueurs.getCardLayout().show(panelNombresJoueurs, "panel_jeu");
		}
		
		//Si on appuie sur completer programme
		else if(e.getActionCommand().equals(Data.ACTION[0])) {
			System.out.println(Data.ACTION[0].toString());
		}
		//Si on appuie sur contruire un mur 
		else if(e.getActionCommand().equals(Data.ACTION[1])) {
			System.out.println(Data.ACTION[1].toString());
		}
		//Si on appuie sur executer le programme 
		else if(e.getActionCommand().equals(Data.ACTION[2])) {
			System.out.println(Data.ACTION[2].toString());
		}
		//Si on appuie sur fin du tour 
		else if(e.getActionCommand().equals(Data.ACTION[3])) {
			/*On va changer l'état pour savoir quel joueur doit jouer*/
			switch(panelNombresJoueurs.getTaille()){
			case 2:
				if (etat == 1){
					etat = 2;
				}
				else{
					etat =1;
				}
				break;
			case 3:
				if (etat == 1)
					etat =2;
				else if (etat  == 2)
					etat =3;
				else
					etat = 1;
				break;
			case 4:
				if (etat == 1)
					etat =2;
				else if (etat  == 2)
					etat =3;
				else if (etat == 3)
					etat = 4;	
				else
					etat =1;
				break;
			}
			chPanJeu.getMain().affichageMain(chPanJeu.getPlateau().getP().getJoueurs().get(etat-1).getMain());
		}
	}

}
