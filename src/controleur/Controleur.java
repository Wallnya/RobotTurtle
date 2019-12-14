package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modele.*;
import vue.*;

public class Controleur implements ActionListener {

	private PanelNombresJoueurs panelNombresJoueurs;
	private PanelJeu chPanJeu;
	private int numJoueurEnCours=1;
	
	public Controleur(PanelNombresJoueurs pPanNbJoueurs) {
		panelNombresJoueurs = pPanNbJoueurs;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton bouton1 = new JButton();
		JButton bouton2 = new JButton();
		JButton bouton3 = new JButton();
		JButton bouton4 = new JButton();
		JButton bouton5 = new JButton();
		
		// Si on lance le jeu
		if(e.getActionCommand().equals(Data.CHOIX[0])) {
			panelNombresJoueurs.add(panelNombresJoueurs,"panel_NbJoueurs");
			panelNombresJoueurs.getCardLayout().show(panelNombresJoueurs,"panel_NbJoueurs");
		}
		
		// Si on a validé le nombre de joueurs
		else if(e.getActionCommand().equals("panelNbJoueurs_valider")) {
			try {
				chPanJeu = new PanelJeu(panelNombresJoueurs.getTaille());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			bouton1 = chPanJeu.getAction().getBoutons()[0];
			bouton2 = chPanJeu.getAction().getBoutons()[1];
			bouton3 = chPanJeu.getAction().getBoutons()[2];
			bouton4 = chPanJeu.getAction().getBoutons()[3];
			bouton5 = chPanJeu.getAction().getBoutons()[4];
			
			panelNombresJoueurs.add(chPanJeu, "panel_jeu");
			chPanJeu.enregistreEcouteur(this);
			panelNombresJoueurs.getCardLayout().show(panelNombresJoueurs, "panel_jeu");
			chPanJeu.getAction().oneBoutonDisabled(bouton4);
			chPanJeu.getAction().oneBoutonDisabled(bouton5);
		}

		else {
			bouton1 = chPanJeu.getAction().getBoutons()[0];
			bouton2 = chPanJeu.getAction().getBoutons()[1];
			bouton3 = chPanJeu.getAction().getBoutons()[2];
			bouton4 = chPanJeu.getAction().getBoutons()[3];
			bouton5 = chPanJeu.getAction().getBoutons()[4];
			
			// Si on appuie sur compléter programme
			if(e.getActionCommand().equals(Data.ACTION[0])) {
				chPanJeu.getPanelMain().boutonEnableTrue();	
				chPanJeu.getAction().oneBoutonDisabled(bouton1);
				chPanJeu.getAction().oneBoutonDisabled(bouton2);
				chPanJeu.getAction().oneBoutonDisabled(bouton3);
				chPanJeu.getAction().oneBoutonAbled(bouton4);
			} 
			
			// Si on choisit la première carte
			else if(e.getActionCommand().equals(0+"")) {
				chPanJeu.getPanelMain().oneBoutonDisabled(chPanJeu.getPanelMain().getLabel()[0]);
				completerProgramme(0);
			}
			
			// Si on choisit la deuxième carte
			else if(e.getActionCommand().equals(1+"")) {
				chPanJeu.getPanelMain().oneBoutonDisabled(chPanJeu.getPanelMain().getLabel()[1]);
				completerProgramme(1);
			}
			// Si on choisit troisième carte
			else if(e.getActionCommand().equals(2+"")) {
				chPanJeu.getPanelMain().oneBoutonDisabled(chPanJeu.getPanelMain().getLabel()[2]);
				completerProgramme(2);
			}
			// Si on choisit la quatrième carte
			else if(e.getActionCommand().equals(3+"")) {
				chPanJeu.getPanelMain().oneBoutonDisabled(chPanJeu.getPanelMain().getLabel()[3]);
				completerProgramme(3);
			}
			// Si on choisit la cinquième carte
			else if(e.getActionCommand().equals(4+"")) {
				chPanJeu.getPanelMain().oneBoutonDisabled(chPanJeu.getPanelMain().getLabel()[4]);
				completerProgramme(4);
			}
			
			// Si on appuie sur contruire un mur 
			else if(e.getActionCommand().equals(Data.ACTION[1])) {
				System.out.println(Data.ACTION[1].toString());
				chPanJeu.getAction().oneBoutonDisabled(bouton1);
				chPanJeu.getAction().oneBoutonDisabled(bouton2);
				chPanJeu.getAction().oneBoutonDisabled(bouton3);
				chPanJeu.getAction().oneBoutonAbled(bouton4);
				
				/**************************************/
				/*               A FAIRE              */
				/**************************************/
			}
			
			
			// Si on appuie sur executer le programme 
			else if(e.getActionCommand().equals(Data.ACTION[2])) {
				
				chPanJeu.getAction().oneBoutonDisabled(bouton1);
				chPanJeu.getAction().oneBoutonDisabled(bouton2);
				chPanJeu.getAction().oneBoutonDisabled(bouton3);
				chPanJeu.getAction().oneBoutonAbled(bouton4);
				
				ArrayDeque<Carte> programmeJoueur = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getProgramme();
				Tortue tortueJoueur = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getTortue();
				Plateau plateau = chPanJeu.getPanelPlateau().getPlateau();
				
				for(Carte carte : programmeJoueur){
					carte.action(tortueJoueur, plateau);
					programmeJoueur.removeFirst();
				}
				try {
					chPanJeu.getPanelPlateau().afficherPlateau();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				chPanJeu.getPanelPlateau().refresh();
				chPanJeu.getPanelPlateau().getPlateau().afficherPlateauConsole();
			}
			
			// Si on appuie sur fin du tour 
			else if(e.getActionCommand().equals(Data.ACTION[3])) {
				
				int nbCartesSelectionnees = chPanJeu.getPanelMain().nombreCartesSelectionnees();
				// Si toutes les cartes ont été selectionnées, on lui fait piocher toutes les cartes
				// car il ne peut pas défausser des cartes
				if (nbCartesSelectionnees == 5){
					chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getMain().clear();
					chPanJeu.getPanelPlateau().getPlateau().piocherCartes(chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1));
				}
				// Sinon, demande si on veut défausser des cartes
				else {
					int resultat = JOptionPane.showConfirmDialog(null,"Voulez-vous défausser des cartes ?", "Le choix est à vous!",JOptionPane.YES_NO_OPTION);
					// Si oui
					if (resultat == JOptionPane.YES_OPTION){
						/**************************************/
						/*              EN COURS              */
						/**************************************/
						chPanJeu.getAction().oneBoutonAbled(bouton5);
						
					}
					// Sinon, on remplace quand même les cartes "vides"
					else {
						Joueur joueurEnCours = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1);
						ArrayList<Carte> mainJoueur = joueurEnCours.getMain();
						for (int i = 0; i < 5; i++){
							if (mainJoueur.get(i) instanceof CarteVide){
								mainJoueur.set(i,chPanJeu.getPanelPlateau().getPlateau().cartePiochee(joueurEnCours));
							}
						}
					}
				}
				
				// On passe au joueur suivant
				changementTour();
				
				// On réinitialise la vue pour le nouveau tour
				Joueur nouveauJoueur = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours - 1);
				ArrayList<Carte> mainNouveauJoueur = nouveauJoueur.getMain();
				
				chPanJeu.getPanelMain().boutonEnableFalse();
				chPanJeu.getPanelMain().affichageMain(mainNouveauJoueur);
				chPanJeu.getAction().oneBoutonAbled(bouton1);
				chPanJeu.getAction().oneBoutonAbled(bouton2);
				chPanJeu.getAction().oneBoutonAbled(bouton3);
				chPanJeu.getAction().oneBoutonDisabled(bouton4);

			}
			
		}
	}

	public void changementTour() {
		int nbJoueurs = panelNombresJoueurs.getTaille();
		
		if (numJoueurEnCours < nbJoueurs) {
			numJoueurEnCours++;
		} else {
			numJoueurEnCours = 1;
		}
	}

	public void completerProgramme(int numCarte){
		ArrayDeque<Carte> programmeJoueur = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getProgramme();
		ArrayList<Carte> mainJoueur = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getMain();
		String couleurCarte = chPanJeu.getPanelMain().getLabel()[numCarte].getText().toString();
		
		// Ajout au programme
		switch (couleurCarte){
			case "Bleu":
				programmeJoueur.addLast(new CarteBleue());
				break;
			case "Jaune":
				programmeJoueur.addLast(new CarteJaune());
				break;	
			case "Violet":
				programmeJoueur.addLast(new CarteViolette());
				break;
			case "Laser":
				programmeJoueur.addLast(new CarteLaser());
				break;
		}
		// Suppression de la main
		mainJoueur.set(numCarte, new CarteVide());
		
		System.out.println("Programme : " + programmeJoueur);	
		System.out.println("Main : " + mainJoueur);
	}
}
