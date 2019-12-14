package vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelAccueil extends JFrame implements ActionListener{

	public GridBagConstraints contrainte = new GridBagConstraints();
	private static final long serialVersionUID = 1L;
	private JButton lancer_partie = new JButton("Lancer une partie");
	private JButton quitter_jeu = new JButton("Quitter le jeu");
	
	
	public static void main(String[] args) {
		new PanelAccueil();
	}
	
	/**
	 * Construit un objet API correspondant à un GridBagLayout qui est l'accueil de l'application
	 */
	public PanelAccueil() {
		super("Accueil du jeu Robot Turtle");
		JPanel pan = new JPanel();
		pan.setLayout(new GridBagLayout());
		
		// Taille
		contrainte.fill = GridBagConstraints.BOTH; 
		// Padding externe (bottom, left, right, top)
		contrainte.insets = new Insets(10,10,10,10);
		// Padding interne
		contrainte.ipady = contrainte.anchor = GridBagConstraints.CENTER;
		
		lancer_partie.addActionListener(this);
		lancer_partie.setActionCommand("lancer");
		
		quitter_jeu.addActionListener(this);
		quitter_jeu.setActionCommand("quitter");
		
		// Cellule où commence l'affichage
		contrainte.gridx = 0; contrainte.gridy = 0;
		// Nombre de cellules par colonne / ligne
		contrainte.gridheight = 2; contrainte.gridwidth = 2;
		pan.add(new JLabel("Bienvenue dans le jeu Robot Turtle!",SwingConstants.CENTER),contrainte);
		
		contrainte.gridx = 0; contrainte.gridy = 2;
		contrainte.gridheight = 1; contrainte.gridwidth = 1;
		pan.add(lancer_partie,contrainte);
		
		contrainte.gridx = 1; contrainte.gridy = 2;
		contrainte.gridheight = 1; contrainte.gridwidth = 1;
		pan.add(quitter_jeu,contrainte);
		
		this.add(pan);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800,400);
	}
		
	public void actionPerformed(ActionEvent ev) {
		if(ev.getActionCommand().equals("lancer")) {
			new FenetreMere();
		}
		if(ev.getActionCommand().equals("quitter")){
			System.exit(0);
		}
	}
}