package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.*;
import vue.PanelNombresJoueurs;

public class Controlleur implements ActionListener {

	private PanelNombresJoueurs panelNombresJoueurs;

	public Controlleur(PanelNombresJoueurs pPanNbJoueurs) {
		panelNombresJoueurs = pPanNbJoueurs;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(Data.CHOIX[0])) {//choix du lancement du jeu
			panelNombresJoueurs.add(panelNombresJoueurs,"panel_NbJoueurs");
			panelNombresJoueurs.getCardLayout().show(panelNombresJoueurs,"panel_NbJoueurs");
		}
		
		/*if(e.getActionCommand().equals(Data.VALIDER_PANEL_TAILLE)) {//choix de la taille de la matrice
			chPanMatrice = new PanelMatrice(chPanTaille.getTaille());
			chPanelChoix.add(chPanMatrice, "panel_matrice");
			chPanMatrice.enregistreEcouteur(this);
			chPanelChoix.getCardLayout().show(chPanelChoix, "panel_matrice");	
		}*/		
	}

}
