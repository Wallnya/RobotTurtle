package vue;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controleur.Controleur;

public class PanelNombresJoueurs extends JPanel{
	
	public GridBagConstraints contrainte = new GridBagConstraints();
	private static final long serialVersionUID = 3703370640778702506L;
	private JButton valider = new JButton("valider");
    private JComboBox<String> comboTaille;
    private String taille[]= {"2","3","4"};
	private CardLayout cardLayout;
	private Controleur chControleur;
	
	
	public PanelNombresJoueurs() {
		cardLayout = new CardLayout();
		this.setLayout(cardLayout);
		chControleur = new Controleur(this);
		
		// Cr�ation du panel
		JPanel pan = new JPanel()        {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
 
                ImageIcon m = new ImageIcon("images/background.jpeg");
                Image monImage = m.getImage();
                int x=(getWidth()-620)/2;
                int y=(getHeight()-802)/2;
                g.drawImage(monImage, x, y,this);
            }
        };
		pan.setLayout(new GridBagLayout());
			
		contrainte.fill = GridBagConstraints.BOTH; contrainte.insets = new Insets(10,10,10,10);
		contrainte.ipady = contrainte.anchor = GridBagConstraints.CENTER;

		// Liste d�roulante
		comboTaille = new JComboBox<String>(taille);
		comboTaille.addActionListener(chControleur);
		comboTaille.setActionCommand("champs_taille");
		
		// Bouton
		valider.addActionListener(chControleur);
		valider.setActionCommand("panelNbJoueurs_valider");
			
		// Affichage
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

	// Getters et setters
	public Controleur getChControleur() {
		return chControleur;
	}
	public void setChControleur(Controleur chControleur) {
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
	public int getTaille() {
		int poids = comboTaille.getSelectedIndex();
		return poids+2;
	}
	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

}
