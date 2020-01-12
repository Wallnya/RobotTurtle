package controleur;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import modele.*;
import vue.*;

public class Controleur implements ActionListener {

	private PanelNombresJoueurs panelNombresJoueurs;
	private PanelJeu chPanJeu;
	private int numJoueurEnCours = 1;
	private boolean defausse = false;
	private static int valeurObstacle =-1;
	private boolean mur = false;	

	
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
			Joueur joueurEnCours = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1);
			
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
			
			int nbCartesDefausse = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getDefausse().size();
			boutonDefausse.setText("Défausse (" + nbCartesDefausse + ")");
			
			int nbCartesPioche = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getPioche().size();
			boutonPioche.setText("Pioche (" + nbCartesPioche + ")");
			
			int nbCartesProgramme = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getProgramme().size();
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
				
				int nbCartesPioche = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getPioche().size();
				boutonPioche.setText("Pioche (" + nbCartesPioche-- + ")");
				
				chPanJeu.getPanelMain().affichageMain(joueurEnCours.getMain());
				System.out.println(joueurEnCours.getMain());
				
				if (!(joueurEnCours.getMain().get(4) instanceof CarteVide)) {
					chPanJeu.getPanelMain().oneBoutonEnabledFalse(boutonPioche);
					chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton1);
					chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton2);
					chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton3);
					textareaAction.setText("Veuillez choisir une action.");
				}
			}
				
			// Si on appuie sur complï¿½ter programme
			else if(e.getActionCommand().equals(Data.ACTION[0])) {
				chPanJeu.getPanelMain().boutonsMainEnableTrue();	
				chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton1);
				chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton2);
				chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton3);
				chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton4);
				chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton5);
			} 
						
			// Si on choisit la premiï¿½re carte
			else if(e.getActionCommand().equals(0+"")) {
				chPanJeu.getPanelMain().oneBoutonEnabledFalse(chPanJeu.getPanelMain().getBoutonsMain()[0]);
				completerProgramme(0);
			}
			
			// Si on choisit la deuxiï¿½me carte
			else if(e.getActionCommand().equals(1+"")) {
				chPanJeu.getPanelMain().oneBoutonEnabledFalse(chPanJeu.getPanelMain().getBoutonsMain()[1]);
				completerProgramme(1);
			}
			// Si on choisit troisiï¿½me carte
			else if(e.getActionCommand().equals(2+"")) {
				chPanJeu.getPanelMain().oneBoutonEnabledFalse(chPanJeu.getPanelMain().getBoutonsMain()[2]);
				completerProgramme(2);
			}
			// Si on choisit la quatriï¿½me carte
			else if(e.getActionCommand().equals(3+"")) {
				chPanJeu.getPanelMain().oneBoutonEnabledFalse(chPanJeu.getPanelMain().getBoutonsMain()[3]);
				completerProgramme(3);
			}
			// Si on choisit la cinquiï¿½me carte
			else if(e.getActionCommand().equals(4+"")) {
				chPanJeu.getPanelMain().oneBoutonEnabledFalse(chPanJeu.getPanelMain().getBoutonsMain()[4]);
				completerProgramme(4);
			}
			// Si on appuie sur contruire un mur 
			else if(e.getActionCommand().equals(Data.ACTION[1])) {
				System.out.println(Data.ACTION[1].toString());
				chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton1);
				chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton2);
				chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton3);
				chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton4);
				chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton5);
				//Cellule disponible
				chPanJeu.getPanelPlateau().getTable().setEnabled(true);
				Object[] possibleValues = { "Pierre", "Glace"};	
				valeurObstacle = -1;
				while (valeurObstacle == -1) {
					valeurObstacle = JOptionPane.showOptionDialog(null, 
			                "Voulez-vous mettre une pierre ou de la glace ?", 
			                "Le choix est Ã  vous!", 
			                JOptionPane.YES_NO_OPTION, 
			                JOptionPane.QUESTION_MESSAGE, 
			                null, possibleValues, possibleValues[0]);
				}
				mur = true;

				placerObstacle();
				chPanJeu.getPanelPlateau().refresh();
			}
			
			
			// Si on appuie sur executer le programme 
			else if(e.getActionCommand().equals(Data.ACTION[2])) {
				
				chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton1);
				chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton2);
				chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton3);
				chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton4);
				chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton5);
				
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
				// Si toutes les cartes ont ï¿½tï¿½ selectionnï¿½es, on lui fait piocher toutes les cartes
				// car il ne peut pas dï¿½fausser des cartes
				if (nbCartesSelectionnees == 5){
					chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getMain().clear();
					chPanJeu.getPanelPlateau().getPlateau().piocherCartes(chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1));
				}
				// Sinon, demande si on veut dï¿½fausser des cartes
				else {
					//int resultat = JOptionPane.showConfirmDialog(null,"Voulez-vous dï¿½fausser des cartes ?", "Le choix est ï¿½ vous!",JOptionPane.YES_NO_OPTION);
					// Si oui
					//if (resultat == JOptionPane.YES_OPTION){
						/**************************************/
						/*              EN COURS              */
						/**************************************/
						//chPanJeu.getPanelAction().oneBoutonAbled(bouton5);
					
					//}
					// Sinon, on remplace quand mï¿½me les cartes "vides" utilisï¿½es
					//else {
						ArrayList<Carte> mainJoueur = joueurEnCours.getMain();
						for (int i = 0; i < 5; i++){
							if (mainJoueur.get(i) instanceof CarteVide){
								mainJoueur.set(i,chPanJeu.getPanelPlateau().getPlateau().cartePiochee(joueurEnCours));
							}
						}
					//}
				}
				
				// On passe au joueur suivant
				changementTour();
				
				// On rï¿½initialise la vue pour le nouveau tour
				Joueur nouveauJoueur = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours - 1);
				ArrayList<Carte> mainNouveauJoueur = nouveauJoueur.getMain();
				
				chPanJeu.getPanelMain().boutonsMainEnableFalse();
				chPanJeu.getPanelMain().boutonsMainEnableFalse();
				chPanJeu.getPanelMain().boutonsMainEnableFalse();
				chPanJeu.getPanelMain().affichageMain(mainNouveauJoueur);
				chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton1);
				chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton2);
				chPanJeu.getPanelAction().oneBoutonEnabledTrue(bouton3);
				chPanJeu.getPanelAction().oneBoutonEnabledFalse(bouton4);

				// Texte à afficher
				System.out.println("Joueur " + numJoueurEnCours + ", à vous de jouer !");
				textareaJoueurEnCours.setText("Joueur " + numJoueurEnCours + ",\nà vous de jouer !");

				textareaAction.setText("Veuillez choisir une action.");

				int nbCartesDefausse = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getDefausse().size();
				boutonDefausse.setText("Défausse (" + nbCartesDefausse + ")");

				int nbCartesPioche = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getPioche().size();
				boutonPioche.setText("Pioche (" + nbCartesPioche + ")");

				int nbCartesProgramme = chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getProgramme().size();
				labelProgramme.setText("Programme (" + nbCartesProgramme + ")");

			}
			//Si on appuie sur dï¿½fausser des cartes
			else if(e.getActionCommand().equals(Data.ACTION[4])){
				chPanJeu.getPanelAction().oneBoutonEnabledFalse(chPanJeu.getPanelAction().getBoutons()[4]);
				defausse=true;
				//Si toutes les cartes ont ï¿½tï¿½ selectionnï¿½es, on lui fait piocher toutes les cartes
				//car il ne peut pas dï¿½fausser des cartes
				if (chPanJeu.getPanelMain().nombreCartesSelectionnees() == 5){
					chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getDefausse().addAll(chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours).getMain());
					chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1).getMain().clear();
					chPanJeu.getPanelPlateau().getPlateau().piocherCartes(chPanJeu.getPanelPlateau().getPlateau().getJoueurs().get(numJoueurEnCours-1));
				}
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
	
	public void placerObstacle() {
		boolean ok = false;	
		ok = true;
		final Plateau plateau = chPanJeu.getPanelPlateau().getPlateau();
		final JTable table = chPanJeu.getPanelPlateau().getTable();
		if (ok) {
			table.addMouseListener(new java.awt.event.MouseAdapter() {
			    @Override
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			    	if (mur){
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
						mur=false;
						//Cellule indisponible
						chPanJeu.getPanelPlateau().getTable().setEnabled(false);
			    	}
			    }
			});
		}
	}
}



















