package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayDeque;

import javax.swing.JOptionPane;

import modele.*;
import vue.*;

public class Controleur implements ActionListener {

	private PanelNombresJoueurs panelNombresJoueurs;
	private PanelJeu chPanJeu;
	private int etat=1;
	
	public Controleur(PanelNombresJoueurs pPanNbJoueurs) {
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
			chPanJeu.getAction().boutonFinDefausseFalse();
			chPanJeu.getAction().oneBoutonDisabled(chPanJeu.getAction().getBoutons()[3]);
		}

		//Si on appuie sur completer programme
		else if(e.getActionCommand().equals(Data.ACTION[0])) {
			chPanJeu.getMain().boutonEnableTrue();
			chPanJeu.getAction().oneBoutonAble(chPanJeu.getAction().getBoutons()[3]);
			chPanJeu.getAction().oneBoutonDisabled(chPanJeu.getAction().getBoutons()[1]);
			chPanJeu.getAction().oneBoutonDisabled(chPanJeu.getAction().getBoutons()[2]);
		}
		//Si on appuie sur contruire un mur 
		else if(e.getActionCommand().equals(Data.ACTION[1])) {
			System.out.println(Data.ACTION[1].toString());
			chPanJeu.getAction().oneBoutonAble(chPanJeu.getAction().getBoutons()[3]);
			chPanJeu.getAction().oneBoutonDisabled(chPanJeu.getAction().getBoutons()[0]);
			chPanJeu.getAction().oneBoutonDisabled(chPanJeu.getAction().getBoutons()[2]);
		}
		//Si on appuie sur executer le programme 
		else if(e.getActionCommand().equals(Data.ACTION[2])) {
			chPanJeu.getAction().oneBoutonAble(chPanJeu.getAction().getBoutons()[3]);
			chPanJeu.getAction().oneBoutonDisabled(chPanJeu.getAction().getBoutons()[0]);
			chPanJeu.getAction().oneBoutonDisabled(chPanJeu.getAction().getBoutons()[1]);
			
			for(Carte str : chPanJeu.getPlateau().getP().getJoueurs().get(etat-1).getProgramme()){
				System.out.println(str.toString());
				str.action(chPanJeu.getPlateau().getP().getJoueurs().get(etat-1).getTortue(), chPanJeu.getPlateau().getP());
				chPanJeu.getPlateau().getP().getJoueurs().get(etat-1).getProgramme().removeFirst();
			}
			try {
				chPanJeu.getPlateau().updatePlateau();
			} catch (IOException e1) {e1.printStackTrace();}
			chPanJeu.getPlateau().refresh();
			chPanJeu.getPlateau().getP().affichage();
		}
		//Si on appuie sur fin du tour 
		else if(e.getActionCommand().equals(Data.ACTION[3])) {
			//Si toutes les cartes ont été selectionnées, on lui fait piocher toutes les cartes
			//car il ne peut pas défausser des cartes
			System.out.println("nbCarte "+chPanJeu.getMain().nombreCarteSelectionnee());
			System.out.println("joueur"+(etat-1));

			if (chPanJeu.getMain().nombreCarteSelectionnee() == 5){
				chPanJeu.getPlateau().getP().getJoueurs().get(etat-1).getMain().clear();
				chPanJeu.getPlateau().getP().piocherCartes(chPanJeu.getPlateau().getP().getJoueurs().get(etat-1));
			}
			//Sinon on lui demande s'il veut défausser des cartes en plus
			else {
				int resultat = JOptionPane.showConfirmDialog(null,"Voulez-vous défausser des cartes ?", "Le choix est à vous!",JOptionPane.YES_NO_OPTION);
				//S'il veut défausser des cartes
				if (resultat == JOptionPane.YES_OPTION){
					/***********************************/
					/*		EN COURS				*/
					/*************************************/
					chPanJeu.getAction().boutonFinDefausseTrue();

				}
				//S'il ne veut pas défausser des cartes
				else{
					for (int i=0;i<5;i++){
						if(chPanJeu.getPlateau().getP().getJoueurs().get(etat-1).getMain().get(i) instanceof CarteVide){
							chPanJeu.getPlateau().getP().getJoueurs().get(etat-1).getMain().set(i,chPanJeu.getPlateau().getP().piocheUneCarte());
						}
					}
				}
			}
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
			chPanJeu.getMain().boutonEnableFalse();
			chPanJeu.getMain().affichageMain(chPanJeu.getPlateau().getP().getJoueurs().get(etat-1).getMain());
			/*On réaffiche tous les boutons.*/
			chPanJeu.getAction().oneBoutonAble(chPanJeu.getAction().getBoutons()[0]);
			chPanJeu.getAction().oneBoutonAble(chPanJeu.getAction().getBoutons()[1]);
			chPanJeu.getAction().oneBoutonAble(chPanJeu.getAction().getBoutons()[2]);
			chPanJeu.getAction().oneBoutonDisabled(chPanJeu.getAction().getBoutons()[3]);


		}
		/*S'il clique sur la première carte*/
		else if(e.getActionCommand().equals(0+"")) {
			chPanJeu.getMain().oneBoutonDisabled(chPanJeu.getMain().getLabel()[0]);
			//On ajoute la carte au programme
			ajoutProgramm(0);
			//et on l'enlève de la main du joueur.
			chPanJeu.getPlateau().getP().getJoueurs().get(etat-1).getMain().set(0, new CarteVide());
		}
		/*S'il clique sur la deuxième carte*/
		else if(e.getActionCommand().equals(1+"")) {
			chPanJeu.getMain().oneBoutonDisabled(chPanJeu.getMain().getLabel()[1]);
			ajoutProgramm(1);
			//et on l'enlève de la main du joueur.
			chPanJeu.getPlateau().getP().getJoueurs().get(etat-1).getMain().set(1, new CarteVide());
		}
		/*S'il clique sur la troisième carte*/
		else if(e.getActionCommand().equals(2+"")) {
			chPanJeu.getMain().oneBoutonDisabled(chPanJeu.getMain().getLabel()[2]);
			ajoutProgramm(2);
			//et on l'enlève de la main du joueur.
			chPanJeu.getPlateau().getP().getJoueurs().get(etat-1).getMain().set(2, new CarteVide());
		}
		/*S'il clique sur la quatrième carte*/
		else if(e.getActionCommand().equals(3+"")) {
			chPanJeu.getMain().oneBoutonDisabled(chPanJeu.getMain().getLabel()[3]);
			ajoutProgramm(3);
			//et on l'enlève de la main du joueur.
			chPanJeu.getPlateau().getP().getJoueurs().get(etat-1).getMain().set(3, new CarteVide());
		}
		/*S'il clique sur la cinquième carte*/
		else if(e.getActionCommand().equals(4+"")) {
			chPanJeu.getMain().oneBoutonDisabled(chPanJeu.getMain().getLabel()[4]);
			ajoutProgramm(4);
			//et on l'enlève de la main du joueur.
			chPanJeu.getPlateau().getP().getJoueurs().get(etat-1).getMain().set(4, new CarteVide());
		}
	}

	public void ajoutProgramm(int i){
		ArrayDeque<Carte> programmeJoueur = chPanJeu.getPlateau().getP().getJoueurs().get(etat-1).getProgramme();
		String couleurCarte = chPanJeu.getMain().getLabel()[i].getText().toString();
		switch (couleurCarte){
		case "bleu":
			programmeJoueur.add(new CarteBleue());
			break;
		case "jaune":
			programmeJoueur.add(new CarteJaune());
			break;	
		case "rouge":
			programmeJoueur.add(new CarteRouge());
			break;
		case "violette":
			programmeJoueur.add(new CarteViolete());
			break;
		}
		System.out.println(programmeJoueur);	
	}

}
