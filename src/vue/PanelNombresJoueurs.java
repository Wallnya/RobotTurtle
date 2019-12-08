package vue;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controlleur.Controlleur;

public class PanelNombresJoueurs extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3703370640778702506L;
	private JButton valider = new JButton("valider");
    private JComboBox<String> comboTaille;
    private String taille[]= {"2","3","4"};
	private CardLayout cardLayout;
	private Controlleur chControleur;
	public GridBagConstraints contrainte = new GridBagConstraints() ;
	
	public PanelNombresJoueurs() {
		cardLayout = new CardLayout();
		this.setLayout(cardLayout);
		chControleur = new Controlleur(this);
		contrainte.fill = GridBagConstraints.BOTH; contrainte.insets = new Insets(10,10,10,10);
		contrainte.ipady = contrainte.anchor = GridBagConstraints.CENTER;
		
		JPanel pan = new JPanel();
		pan.setLayout(new GridBagLayout());
			
		contrainte.fill = GridBagConstraints.BOTH; contrainte.insets = new Insets(10,10,10,10);
		contrainte.ipady = contrainte.anchor = GridBagConstraints.CENTER;

		comboTaille = new JComboBox<String>(taille);

		comboTaille.addActionListener(chControleur);
		comboTaille.setActionCommand("champs_taille");
			
		valider.addActionListener(chControleur);
		valider.setActionCommand("panelNbJoueurs_valider");
			
		contrainte.gridx = 0; contrainte.gridy = 0;
		contrainte.gridheight = 2; contrainte.gridwidth = 2;
		pan.add(new JLabel("Veuillez choisir un nombre de joueurs (entre 2 et 4)",SwingConstants.CENTER),contrainte);
			
		contrainte.gridx = 0; contrainte.gridy = 2;
		contrainte.gridheight = 1; contrainte.gridwidth = 1;
		pan.add(comboTaille,contrainte);
			
		contrainte.gridx = 1; contrainte.gridy = 2;
		contrainte.gridheight = 1; contrainte.gridwidth = 1;
		pan.add(valider,contrainte);
			
		this.add(pan);
	}

	public Controlleur getChControleur() {
		return chControleur;
	}

	public void setChControleur(Controlleur chControleur) {
		this.chControleur = chControleur;
	}

	public CardLayout getCardLayout1() {
		return cardLayout;
	}

	public void setCardLayout1(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}
	
	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}
	
	public int getTaille() {
		int poids = comboTaille.getSelectedIndex();
		return poids+2;
	}

}
