package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import modele.*;
import vue.*;

public class Controleur implements ActionListener {

	private PanelNombresJoueurs panelNombresJoueurs;
	private PanelJeu chPanJeu;
	private int numJoueurEnCours = 1;
	private static int valeurObstacle =-1;
	private boolean creationMur = false;	
	private String actionEnCours;
	private boolean premierTour = true;
	
	public Controleur(PanelNombresJoueurs pPanNbJoueurs) {
		panelNombresJoueurs = pPanNbJoueurs;
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
	
		// Panneau d'accueil
		if(e.getActionCommand().equals(Data.CHOIX[0])) {
			panelNombresJoueurs.add(panelNombresJoueurs,"panel_NbJoueurs");
			panelNombresJoueurs.getCardLayout().show(panelNombresJoueurs,"panel_NbJoueurs");
		}
		
		// Arrivée dans le jeu (initialisation)
		else if(e.getActionCommand().equals("panelNbJoueurs_valider")) {
		
			try {
				chPanJeu = new PanelJeu(panelNombresJoueurs.getTaille());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			panelNombresJoueurs.add(chPanJeu, "panel_jeu");
			chPanJeu.enregistreEcouteur(this);
			panelNombresJoueurs.getCardLayout().show(panelNombresJoueurs, "panel_jeu");
			
			// Création des variables
			JTextArea textareaJoueurEnCours = chPanJeu.getPanelAction().getTextAreas()[0];
			JTextArea textareaAction = chPanJeu.getPanelAction().getTextAreas()[1];
			JButton bouton1 = chPanJeu.getPanelAction().getBoutons()[0];
			JButton bouton2 = chPanJeu.getPanelAction().getBoutons()[1];
			JButton bouton3 = chPanJeu.getPanelAction().getBoutons()[2];
			JButton bouton4 = chPanJeu.getPanelAction().getBoutons()[3];
			JButton bouton5 = chPanJeu.getPanelAction().getBoutons()[4];
			JButton boutonDefausse = chPanJeu.getPanelMain().getBoutonDefausse();
			JButton boutonPioche = chPanJeu.getPanelMain().getBoutonPioche();
			JLabel labelProgramme = chPanJeu.getPanelMain().getLabelProgramme();
			//Joueur joueurEnCours = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1);
			int nbCartesDefausse = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getDefausse().size();
			int nbCartesPioche = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getPioche().size();
			int nbCartesProgramme = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getProgramme().size();
			
			// Boutons à activer ou non
			chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton1);
			chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton2);
			chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton3);
			chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton4);
			chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton5);
			chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonDefausse);
			chPanJeu.getPanelMain().oneBoutonEnabledTrue(boutonPioche);
			chPanJeu.getPanelMain().boutonsMainEnableFalse();
			
			// Texte à afficher
			System.out.println("Joueur " + numJoueurEnCours + ", à vous de jouer !");
			textareaJoueurEnCours.setText("Joueur " + numJoueurEnCours + ",\nà vous de jouer !");
			textareaAction.setText("Veuillez piocher vos cartes.");
			boutonDefausse.setText("Défausse (" + nbCartesDefausse + ")");
			boutonPioche.setText("Pioche (" + nbCartesPioche + ")");
			labelProgramme.setText("Programme (" + nbCartesProgramme + ")");
		}

		// Actions du jeu
		else {
			// Création des variables
						JTextArea textareaJoueurEnCours = chPanJeu.getPanelAction().getTextAreas()[0];
						JTextArea textareaAction = chPanJeu.getPanelAction().getTextAreas()[1];
						JButton bouton1 = chPanJeu.getPanelAction().getBoutons()[0];
						JButton bouton2 = chPanJeu.getPanelAction().getBoutons()[1];
						JButton bouton3 = chPanJeu.getPanelAction().getBoutons()[2];
						JButton bouton4 = chPanJeu.getPanelAction().getBoutons()[3];
						JButton bouton5 = chPanJeu.getPanelAction().getBoutons()[4];
						JButton boutonDefausse = chPanJeu.getPanelMain().getBoutonDefausse();
						JButton boutonPioche = chPanJeu.getPanelMain().getBoutonPioche();
						JLabel labelProgramme = chPanJeu.getPanelMain().getLabelProgramme();
						Joueur joueurEnCours = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1);
						int nbCartesDefausse = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getDefausse().size();
						int nbCartesPioche = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getPioche().size();
						int nbCartesProgramme = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getProgramme().size();
								
						// Piocher
						if(e.getActionCommand().equals("pioche")) {
							int i = 0;
							while (i < 5) {
								if (joueurEnCours.getMain().get(i) instanceof CarteVide) {
									break;
								} else {
									i++;
								}
							}
							joueurEnCours.getMain().remove(i);
							chPanJeu.getPanelPlateau().getPlateau().piocherCarte(joueurEnCours, i);
							
							nbCartesPioche--;
							boutonPioche.setText("Pioche (" + nbCartesPioche + ")");
							
							chPanJeu.getPanelMain().affichageMain(joueurEnCours.getMain());
							System.out.println(joueurEnCours.getMain());
							
							if (!(joueurEnCours.getMain().get(0) instanceof CarteVide) &&
									!(joueurEnCours.getMain().get(1) instanceof CarteVide) &&
									!(joueurEnCours.getMain().get(2) instanceof CarteVide) &&
									!(joueurEnCours.getMain().get(3) instanceof CarteVide) &&
									!(joueurEnCours.getMain().get(4) instanceof CarteVide)) {
								
								// Cas de la pioche en fin de tour
								if (actionEnCours == "Défausser") {
									chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton1);
									chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton2);
									chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton3);
									chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton4);
									chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton5);
									chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonDefausse);
									chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonPioche);
									chPanJeu.getPanelMain().boutonsMainEnableFalse();
									textareaAction.setText("Votre tour est terminé.");
									
								// Cas de la première pioche
								} else {
									chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton1);
									chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton2);
									chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton3);
									chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton4);
									chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton5);
									chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonDefausse);
									chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonPioche);
									chPanJeu.getPanelMain().boutonsMainEnableFalse();
									textareaAction.setText("Veuillez choisir une action.");
								}
							}
						}
							
						// Compléter le programme
						else if(e.getActionCommand().equals(Data.ACTION[0])) {
							actionEnCours = "Compléter";
							chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton1);
							chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton2);
							chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton3);
							chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton4);
							chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton5);
							chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonDefausse);
							chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonPioche);
							chPanJeu.getPanelMain().boutonsMainEnableTrue();
							textareaAction.setText("Veuillez choisir les cartes à ajouter à votre programme.");
						}
									
						// Compléter avec la 1ère carte
						else if(actionEnCours == "Compléter" && e.getActionCommand().equals(0+"")) {
							chPanJeu.getPanelMain().oneBoutonEnabledFalse(chPanJeu.getPanelMain().getBoutonsMain()[0]);
							completerProgramme(0);
							nbCartesProgramme++;
							labelProgramme.setText("Programme (" + nbCartesProgramme + ")");
						}
						
						// Compléter avec la 2ème carte
						else if(actionEnCours == "Compléter" && e.getActionCommand().equals(1+"")) {
							chPanJeu.getPanelMain().oneBoutonEnabledFalse(chPanJeu.getPanelMain().getBoutonsMain()[1]);
							completerProgramme(1);
							nbCartesProgramme++;
							labelProgramme.setText("Programme (" + nbCartesProgramme + ")");
						}
						// Compléter avec la 3ème carte
						else if(actionEnCours == "Compléter" && e.getActionCommand().equals(2+"")) {
							chPanJeu.getPanelMain().oneBoutonEnabledFalse(chPanJeu.getPanelMain().getBoutonsMain()[2]);
							completerProgramme(2);
							nbCartesProgramme++;
							labelProgramme.setText("Programme (" + nbCartesProgramme + ")");
						}
						// Compléter avec la 4ème carte
						else if(actionEnCours == "Compléter" && e.getActionCommand().equals(3+"")) {
							chPanJeu.getPanelMain().oneBoutonEnabledFalse(chPanJeu.getPanelMain().getBoutonsMain()[3]);
							completerProgramme(3);
							nbCartesProgramme++;
							labelProgramme.setText("Programme (" + nbCartesProgramme + ")");
						}
						// Compléter avec la 5ème carte
						else if(actionEnCours == "Compléter" && e.getActionCommand().equals(4+"")) {
							chPanJeu.getPanelMain().oneBoutonEnabledFalse(chPanJeu.getPanelMain().getBoutonsMain()[4]);
							completerProgramme(4);
							nbCartesProgramme++;
							labelProgramme.setText("Programme (" + nbCartesProgramme + ")");
						}
						
						// Valider une action
						else if(e.getActionCommand().equals(Data.ACTION[3])) {
							// Validation après défaussage : pioche
							if (actionEnCours == "Défausser") {
								chPanJeu.getPanelMain().affichageMain(joueurEnCours.getMain());
								chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton1);
								chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton2);
								chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton3);
								chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton4);
								chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton5);
								chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonDefausse);
								chPanJeu.getPanelMain().oneBoutonEnabledTrue(boutonPioche);
								chPanJeu.getPanelMain().boutonsMainEnableFalse();
								textareaAction.setText("Veuillez piocher de nouvelles cartes.");
								
							} else {
								// Validation après action : défaussage
								String actionPrecedente = actionEnCours;
								actionEnCours = "Défausser";
								chPanJeu.getPanelMain().affichageMain(joueurEnCours.getMain());
								int nbCartesSelectionnees = chPanJeu.getPanelMain().nombreCartesSelectionnees();
								if (nbCartesSelectionnees < 5 || actionPrecedente == "Obstacle" || actionPrecedente == "Exécuter"){
									int resultat = JOptionPane.showConfirmDialog(null,"Voulez-vous défausser des cartes ?", "Défausse",JOptionPane.YES_NO_OPTION);
									// Cas où on souhaite défausser des cartes
									if (resultat == JOptionPane.YES_OPTION){
										chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton1);
										chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton2);
										chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton3);
										chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton4);
										chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton5);
										chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonDefausse);
										chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonPioche);
										textareaAction.setText("Veuillez choisir les cartes à défausser.");
										
										if (actionPrecedente == "Obstacle" || actionPrecedente == "Exécuter") {
											chPanJeu.getPanelMain().boutonsMainEnableTrue();
										}
									}
									// Cas où on ne souhaite pas défausser 
									else {
										// Cas où on n'a pas besoin de piocher
										if (!(joueurEnCours.getMain().get(0) instanceof CarteVide) &&
												!(joueurEnCours.getMain().get(1) instanceof CarteVide) &&
												!(joueurEnCours.getMain().get(2) instanceof CarteVide) &&
												!(joueurEnCours.getMain().get(3) instanceof CarteVide) &&
												!(joueurEnCours.getMain().get(4) instanceof CarteVide)) {
											chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton1);
											chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton2);
											chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton3);
											chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton4);
											chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton5);
											chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonDefausse);
											chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonPioche);
											chPanJeu.getPanelMain().boutonsMainEnableFalse();
											textareaAction.setText("Votre tour est terminé.");
											
										// Cas où on a besoin de piocher
										} else {
											chPanJeu.getPanelMain().affichageMain(joueurEnCours.getMain());
											chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton1);
											chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton2);
											chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton3);
											chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton4);
											chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton5);
											chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonDefausse);
											chPanJeu.getPanelMain().oneBoutonEnabledTrue(boutonPioche);
											chPanJeu.getPanelMain().boutonsMainEnableFalse();
											textareaAction.setText("Veuillez piocher de nouvelles cartes.");
										}
									}
								}
							}	
						}
						
						// Défausser la 1ère carte
						else if(actionEnCours == "Défausser" && e.getActionCommand().equals(0+"")) {
							chPanJeu.getPanelMain().oneBoutonEnabledFalse(chPanJeu.getPanelMain().getBoutonsMain()[0]);
							defausserCarte(0);
							nbCartesDefausse++;
							boutonDefausse.setText("Défausse (" + nbCartesDefausse + ")");
						}
						
						// Défausser la 2ème carte
						else if(actionEnCours == "Défausser" && e.getActionCommand().equals(1+"")) {
							chPanJeu.getPanelMain().oneBoutonEnabledFalse(chPanJeu.getPanelMain().getBoutonsMain()[1]);
							defausserCarte(1);
							nbCartesDefausse++;
							boutonDefausse.setText("Défausse (" + nbCartesDefausse + ")");
						}
						// Défausser la 3ème carte
						else if(actionEnCours == "Défausser" && e.getActionCommand().equals(2+"")) {
							chPanJeu.getPanelMain().oneBoutonEnabledFalse(chPanJeu.getPanelMain().getBoutonsMain()[2]);
							defausserCarte(2);
							nbCartesDefausse++;
							boutonDefausse.setText("Défausse (" + nbCartesDefausse + ")");
						}
						// Défausser la 4ème carte
						else if(actionEnCours == "Défausser" && e.getActionCommand().equals(3+"")) {
							chPanJeu.getPanelMain().oneBoutonEnabledFalse(chPanJeu.getPanelMain().getBoutonsMain()[3]);
							defausserCarte(3);
							nbCartesDefausse++;
							boutonDefausse.setText("Défausse (" + nbCartesDefausse + ")");
						}
						// Défausser la 5ème carte
						else if(actionEnCours == "Défausser" && e.getActionCommand().equals(4+"")) {
							chPanJeu.getPanelMain().oneBoutonEnabledFalse(chPanJeu.getPanelMain().getBoutonsMain()[4]);
							defausserCarte(4);
							nbCartesDefausse++;
							boutonDefausse.setText("Défausse (" + nbCartesDefausse + ")");
						}
			// Si on appuie sur contruire un mur 
			else if(e.getActionCommand().equals(Data.ACTION[1])) {
				System.out.println(Data.ACTION[1].toString());
				actionEnCours = "Obstacle";
				
				chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton1);
				chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton2);
				chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton3);
				chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton4);
				chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton5);
				chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonDefausse);
				chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonPioche);
				textareaAction.setText("Veuillez choisir l'emplacement de votre obstacle.");
				//Cellule disponible
				chPanJeu.getPanelPlateau().getTable().setEnabled(true);
				Object[] possibleValues = { "Pierre", "Glace"};	
				String chaine="";
				int nbPierre = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getNbObstaclePierre();
				int nbGlace = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getNbObstacleGlace();
				if (nbPierre > 0 && nbGlace >0){
					chaine = "Voulez-vous mettre une pierre ("+nbPierre+") "+
			                "ou de la glace ("+nbGlace+") ?" ;
				}
				else {
					if (nbPierre <= 0){
						chaine = "Voulez-vous mettre une pierre (0) ";
						if (nbGlace <= 0){
							chaine+="ou de la glace (0) ?" ;	
						}
						else{
							chaine+="ou de la glace ("+nbGlace+") ?" ;	
						}
					}
					else{
						if (nbPierre <= 0){
							chaine = "Voulez-vous mettre une pierre (0) "+
					                "ou de la glace (0) ?" ;								
						}
						else{
							chaine = "Voulez-vous mettre une pierre ("+nbPierre+") "+
					                "ou de la glace (0) ?" ;
							}
					}
				}
				valeurObstacle = -1;
				while (valeurObstacle == -1) {
					valeurObstacle = JOptionPane.showOptionDialog(null,chaine, 
			                "Le choix est à vous!", 
			                JOptionPane.YES_NO_OPTION, 
			                JOptionPane.QUESTION_MESSAGE, 
			                null, possibleValues, possibleValues[0]);
				}
				if (valeurObstacle == 0){
					chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).setNbObstaclePierre(chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getNbObstaclePierre()-1);
					nbPierre = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getNbObstaclePierre();
					if (nbPierre < 0){
						JOptionPane.showMessageDialog(null, "Plus de carte pierre :( ");
						creationMur=false;
					}
					else{
						creationMur = true;
					}
				}
				else if (valeurObstacle == 1) {
					chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).setNbObstacleGlace(chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getNbObstacleGlace()-1);
					nbGlace = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getNbObstacleGlace();
					if (nbGlace < 0){
						JOptionPane.showMessageDialog(null, "Plus de carte glace :( ");
						creationMur=false;
					}
					else{
						creationMur = true;
					}
				}
				placerObstacle();
				chPanJeu.getPanelPlateau().refresh();
			}
			
			
						// Executer le programme 
						else if(e.getActionCommand().equals(Data.ACTION[2])) {
							
							actionEnCours = "Exécuter";
							
							chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton1);
							chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton2);
							chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton3);
							chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton4);
							chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton5);
							chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonDefausse);
							chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonPioche);
							textareaAction.setText("Votre programme a été exécuté.");
							
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
						
						// Fin du tour
						else if(e.getActionCommand().equals(Data.ACTION[4])) {

							// On passe au joueur suivant
							changementTour();
							actionEnCours = "tourSuivant";
							
							// On réinitialise la vue pour le nouveau tour
							if (premierTour == true) {
								chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton1);
								chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton2);
								chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton3);
								chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton4);
								chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton5);
								chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonDefausse);
								chPanJeu.getPanelMain().oneBoutonEnabledTrue(boutonPioche);
								chPanJeu.getPanelMain().boutonsMainEnableFalse();
								textareaAction.setText("Veuillez piocher vos cartes.");
							} else {
								chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton1);
								chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton2);
								chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton3);
								chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton4);
								chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton5);
								chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonDefausse);
								chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonPioche);
								chPanJeu.getPanelMain().boutonsMainEnableFalse();
								textareaAction.setText("Veuillez choisir une action.");
							}
							
							// Actualisation des variables
							joueurEnCours = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1);
							nbCartesDefausse = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getDefausse().size();
							nbCartesPioche = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getPioche().size();
							nbCartesProgramme = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getProgramme().size();
							
							// Texte à afficher
							System.out.println("Joueur " + numJoueurEnCours + ", à vous de jouer !");
							textareaJoueurEnCours.setText("Joueur " + numJoueurEnCours + ",\nà vous de jouer !");
							boutonDefausse.setText("Défausse (" + nbCartesDefausse + ")");
							boutonPioche.setText("Pioche (" + nbCartesPioche + ")");
							labelProgramme.setText("Programme (" + nbCartesProgramme + ")");
							
							chPanJeu.getPanelMain().affichageMain(joueurEnCours.getMain());

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
		
		// Si on est revenu au joueur 1, ça veut dire que tous les joueurs ont joué au moins 1 fois
		if (numJoueurEnCours == 1) {
			premierTour = false;
		}
	}

	public void completerProgramme(int numCarte){
		ArrayDeque<Carte> programmeJoueur = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getProgramme();
		ArrayList<Carte> mainJoueur = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getMain();
		String couleurCarte = chPanJeu.getPanelMain().getBoutonsMain()[numCarte].getText().toString();
		
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
	
	public void defausserCarte(int numCarte){
		List<Carte> defausseJoueur = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getDefausse();
		ArrayList<Carte> mainJoueur = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getMain();
		String couleurCarte = chPanJeu.getPanelMain().getBoutonsMain()[numCarte].getText().toString();
		
		// Ajout à la défausse
		switch (couleurCarte){
			case "Bleu":
				defausseJoueur.add(new CarteBleue());
				break;
			case "Jaune":
				defausseJoueur.add(new CarteJaune());
				break;	
			case "Violet":
				defausseJoueur.add(new CarteViolette());
				break;
			case "Laser":
				defausseJoueur.add(new CarteLaser());
				break;
		}
		// Suppression de la main
		mainJoueur.set(numCarte, new CarteVide());
		
		System.out.println("Défausse : " + defausseJoueur);	
		System.out.println("Main : " + mainJoueur);
	}
	
	public void placerObstacle() {
		boolean ok = false;	
		ok = true;
		final Plateau plateau = chPanJeu.getPanelPlateau().getPlateau();
		final JTable table = chPanJeu.getPanelPlateau().getTable();
		if (ok) {
			table.addMouseListener(new java.awt.event.MouseAdapter() {
			    @Override
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			    	if (creationMur){
			    		System.out.println(evt.toString());
				        int ligneSelectionnee = table.rowAtPoint(evt.getPoint());
				        int colonneSelectionnee = table.columnAtPoint(evt.getPoint());
				        
						if (plateau.caseLibre(ligneSelectionnee, colonneSelectionnee)) {
							if (plateau.caseNonBlocante(ligneSelectionnee, colonneSelectionnee)) {
								Tuile obstacle = null;
								// Si pierre
								if (valeurObstacle == 0){
										obstacle = new ObstaclePierre();
								}
								else if (valeurObstacle == 1) {
										 obstacle = new ObstacleGlace();
								}
								plateau.deplacerTuile(obstacle, ligneSelectionnee, colonneSelectionnee);
								try {
									chPanJeu.getPanelPlateau().afficherPlateau(); // refresh() marche pas
								} catch (IOException e) {
									e.printStackTrace();
								}
								chPanJeu.getPanelPlateau().getPlateau().afficherPlateauConsole();
								// Rendre tableau non cliquable aprï¿½s avoir poser l'obstacle
							} else {
								System.out.println("Case blocante.");
							}
						} else {
							System.out.println("Case déjà occupée.");
						}
						creationMur=false;
						//Cellule indisponible
						chPanJeu.getPanelPlateau().getTable().setEnabled(false);
			    	}
			    }
			});
		}
	}
}



















