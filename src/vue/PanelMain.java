package vue;

import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import controleur.Controleur;
import modele.Carte;
import modele.Joueur;

public class PanelMain extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JButton[] label = new JButton[5];
	private ArrayList<Carte> main;
	private JPanel container;

	public PanelMain(Joueur joueurEnCours) throws IOException{
		
		label[0] = new JButton("");
		label[1] = new JButton("");
		label[2] = new JButton("");
		label[3] = new JButton("");
		label[4] = new JButton("");
		boutonEnableFalse();
		
        container = new JPanel();
        container.setLayout(new GridLayout(1,5, 60, 60));
		container.add(label[0]);
		container.add(label[1]);
		container.add(label[2]);
		container.add(label[3]);
		container.add(label[4]);
		
		this.setSize(600, 500);
        this.add(container);
        this.setVisible(true);

        // Affichage de la main du joueur
		affichageMain(joueurEnCours.getMain());
	}
	
	public void affichageMain(ArrayList<Carte> main){
		for (int i = 0; i < 5; i++){
			label[i].setText(main.get(i).toString());
			label[i].setActionCommand(i+"");
			container.add(label[i]);
		}
		this.add(container);
	}
	
	public void boutonEnableFalse(){
		for (int i = 0; i < 5; i++) {
			label[i].setEnabled(false);
		}	
	}
	
	public void boutonEnableTrue(){
		for (int i = 0; i < 5; i++) {
			label[i].setEnabled(true);
		}	
	}
	
	public int nombreCartesSelectionnees(){
		int compteur = 0;
		for (int i = 0; i < 5; i++){
			if (!label[i].isEnabled())
				compteur++;
		}
		return compteur;
	}

	public void enregistreEcouteur(Controleur controleur) {
		for (int i = 0; i < 5; i++) {
			label[i].addActionListener(controleur);
		}		
	}
	
	public void oneBoutonDisabled(JButton button){
		button.setEnabled(false);
	}
	
	// Getters et setters
	public JButton[] getLabel() {
		return label;
	}
	public void setLabel(JButton[] label) {
		this.label = label;
	}	

}
