package vue;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelAccueil extends JFrame implements ActionListener{

	public GridBagConstraints contrainte = new GridBagConstraints();
	private static final long serialVersionUID = 1L;
	private JButton lancer_partie = new JButton("Lancer une partie");
	private JButton quitter_jeu = new JButton("Quitter le jeu");
	
	
	public static void main(String[] args) throws IOException {
		new PanelAccueil();
	}
	
	/**
	 * Construit un objet API correspondant à un GridBagLayout qui est l'accueil de l'application
	 * @throws IOException 
	 */
	public PanelAccueil() throws IOException {
		super("Accueil du jeu Robot Turtle");
		JPanel pan = new JPanel()        {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
 
                ImageIcon m = new ImageIcon("images/fond.png");
                Image monImage = m.getImage();
                g.drawImage(monImage, 0, 0,this);
            }
        };
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
		
		contrainte.gridx = 0; contrainte.gridy = 2;
		contrainte.gridheight = 1; contrainte.gridwidth = 1;
		pan.add(lancer_partie,contrainte);
		
		contrainte.gridx = 1; contrainte.gridy = 2;
		contrainte.gridheight = 1; contrainte.gridwidth = 1;
		pan.add(quitter_jeu,contrainte);

		this.add(pan);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(700,410);
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