package vue;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlleur.Controlleur;

public class PanelJeu extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nbJoueur;
	
	public PanelJeu(int taille) throws IOException {
		nbJoueur = taille;
		PanelPlateau plateau = new PanelPlateau(nbJoueur);
		PanelMain main = new PanelMain();
		PanelAction action = new PanelAction();
		
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(100, 100, 100, 100));
		
		this.add(plateau, BorderLayout.CENTER);
		this.add(main, BorderLayout.SOUTH);
		this.add(action, BorderLayout.EAST);

		}

	public void enregistreEcouteur(Controlleur controlleur) {
		// TODO Auto-generated method stub
		
	}

}
