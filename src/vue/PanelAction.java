package vue;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import controleur.Controleur;
import modele.Data;

public class PanelAction extends JPanel{

	private JPanel panel;
	private JButton[] boutons;
	private JTextArea[] textareas;
	private static final long serialVersionUID = 1L;

	public PanelAction(){
		
		this.setPreferredSize(new Dimension(300, 10));
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		this.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
		
		this.setLayout(new BorderLayout());
		boutons = new JButton[5];
		textareas = new JTextArea[2];

		panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
	/*	Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		System.out.println(height/2);*/
		
		for (int i = 0; i < textareas.length; i++) {
			panel.add(Box.createVerticalStrut(20));
			textareas[i] = new JTextArea();
			textareas[i].setFont(new Font(textareas[0].getName(), Font.PLAIN, 20));
			textareas[i].setOpaque(false); // enlever le fond blanc
			panel.add(textareas[i]);
			panel.add(Box.createVerticalStrut(20));
		}

		for (int i = 0; i < Data.ACTION.length; i++) {
			panel.add(Box.createVerticalStrut(2));
			boutons[i] = new JButton(Data.ACTION[i]);
			boutons[i].setActionCommand(Data.ACTION[i]);
			boutons[i].setFont(new Font(Font.SERIF, 0, 20));
			panel.add(boutons[i]);
			panel.add(Box.createVerticalStrut(2));
		}
		
		this.add(panel, BorderLayout.PAGE_START);
		
	}
	
	
	public void enregistreEcouteur(Controleur pControleur) {
		for (int i = 0; i < Data.ACTION.length; i++) {
			boutons[i].addActionListener(pControleur); // boutons des opérateurs
		}
	}
	
	public void oneBoutonEnabledFalse(JButton button){
		button.setEnabled(false);
	}
	
	public void oneBoutonEnabledTrue(JButton button){
		button.setEnabled(true);
	}
	
	// Getters et setters
	public JButton[] getBoutons() {
		return boutons;
	}
	public JTextArea[] getTextAreas() {
		return textareas;
	}
	public void setBoutons(JButton[] boutons) {
		this.boutons = boutons;
	}

}
