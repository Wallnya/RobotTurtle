package vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import modele.Carte;
import modele.Data;
import modele.Joueur;

public class PanelMain extends JPanel{
	private JButton[] label = new JButton[5];
	private static final long serialVersionUID = 1L;
	private ArrayList<Carte> main;
	private JPanel container;

	public PanelMain(Joueur joueur) throws IOException{
		label[0] = new JButton("");
		label[1] = new JButton("");
		label[2] = new JButton("");
		label[3] = new JButton("");
		label[4] = new JButton("");
        container = new JPanel();
        this.setSize(600, 500);
        container.setLayout(new GridLayout(1,5, 60, 60));
		container.add(label[0]);
		container.add(label[1]);
		container.add(label[2]);
		container.add(label[3]);
		container.add(label[4]);
        this.add(container);
        this.setVisible(true);
		main = new ArrayList<Carte>();
		for(int i=0;i<5;i++){
			main.add(i, joueur.getMain().get(i));
		}
		affichageMain(main);
	}
	
	public void affichageMain(ArrayList<Carte> main){
		for(int i=0;i<5;i++){
			label[i].setText(main.get(i).toString());
			label[i].setActionCommand(main.get(i).toString());
			container.add(label[i]);
		}
		this.add(container);
	}

	public void affichageMain(Joueur joueur) {
		// TODO Auto-generated method stub
		
	}
}
