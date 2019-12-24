package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import controleur.Controleur;
import modele.Data;

public class PanelAction extends JPanel{

	private JPanel panel;
	private JButton[] boutons;
	private JLabel[] labels;
	private static final long serialVersionUID = 1L;

	public PanelAction(){
		
		this.setPreferredSize(new Dimension(250, 10));
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		this.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
		
		this.setLayout(new BorderLayout());
		boutons = new JButton[5];
		labels = new JLabel[1];

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
	/*	Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		System.out.println(height/2);*/
		
		labels[0] = new JLabel(); 
		labels[0].setVerticalAlignment(SwingConstants.CENTER);
		labels[0].setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(labels[0]);
	    
		panel.add(Box.createVerticalStrut(350));
		for (int i = 0; i < Data.ACTION.length; i++) {
			boutons[i] = new JButton(Data.ACTION[i]);
			boutons[i].setActionCommand(Data.ACTION[i]);
			boutons[i].setFont(new Font(Font.SERIF, 0, 20));
			panel.add(boutons[i]);
		}
		this.add(panel, BorderLayout.CENTER);
	}
	
	public void enregistreEcouteur(Controleur pControleur) {
		for (int i = 0; i < Data.ACTION.length; i++) {
			boutons[i].addActionListener(pControleur); // boutons des opérateurs
		}
	}
	
	public void oneBoutonDisabled(JButton button){
		button.setEnabled(false);
	}
	
	public void oneBoutonAbled(JButton button){
		button.setEnabled(true);
	}
	
	// Getters et setters
	public JButton[] getBoutons() {
		return boutons;
	}
	public JLabel[] getLabels() {
		return labels;
	}
	public void setBoutons(JButton[] boutons) {
		this.boutons = boutons;
	}

}
