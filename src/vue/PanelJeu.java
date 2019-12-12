package vue;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlleur.Controlleur;

public class PanelJeu extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private int nbJoueur;
	
	private PanelAction action;
	private PanelPlateau plateau;
	private PanelMain main;

	public PanelJeu(int taille) throws IOException {
		nbJoueur = taille;
		plateau = new PanelPlateau(nbJoueur);
		main = new PanelMain(plateau.getP().getJoueurs().iterator().next());
		action = new PanelAction();
		
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(100, 100, 100, 100));
		
		this.add(plateau, BorderLayout.CENTER);
		this.add(main, BorderLayout.SOUTH);
		this.add(action, BorderLayout.EAST);
		
		plateau.getP().getJoueurs();
	}

	public PanelPlateau getPlateau() {
		return plateau;
	}

	public void setPlateau(PanelPlateau plateau) {
		this.plateau = plateau;
	}

	public void enregistreEcouteur(Controlleur controlleur) {
		action.enregistreEcouteur(controlleur);
		
	}
	public PanelAction getAction() {
		return action;
	}

	public void setAction(PanelAction action) {
		this.action = action;
	}

	public PanelMain getMain() {
		return main;
	}

	public void setMain(PanelMain main) {
		this.main = main;
	}
}
