package vue;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controleur;
import modele.Joueur;

public class PanelJeu extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private int nbJoueur;
	private PanelAction panelAction;
	private PanelPlateau panelPlateau;
	private PanelMain panelMain;

	public PanelJeu(int taille) throws IOException {
		
		nbJoueur = taille;
		panelPlateau = new PanelPlateau(nbJoueur);
		Joueur joueurEnCours = panelPlateau.getPlateau().getJoueurs().iterator().next();
		panelMain = new PanelMain(joueurEnCours);
		panelAction = new PanelAction();
		
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(100, 100, 100, 100));
		
		this.add(panelPlateau, BorderLayout.CENTER);
		this.add(panelMain, BorderLayout.SOUTH);
		this.add(panelAction, BorderLayout.EAST);
		
		//panelPlateau.getPlateau().getJoueurs();
	}

	public void enregistreEcouteur(Controleur controleur) {
		panelAction.enregistreEcouteur(controleur);
		panelMain.enregistreEcouteur(controleur);
	}
	
	public PanelAction getAction() {
		return panelAction;
	}
	


	
	
	
	
	
	public PanelPlateau getPanelPlateau() {
		return panelPlateau;
	}

	public void setPanelPlateau(PanelPlateau panelPlateau) {
		this.panelPlateau = panelPlateau;
	}



	/*public void setPanelAction(PanelAction panelAction) {
		this.panelAction = panelAction;
	}*/

	public PanelMain getPanelMain() {
		return panelMain;
	}

	public void setPanelMain(PanelMain panelMain) {
		this.panelMain = panelMain;
	}
}
