package vue;

import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controleur.Controleur;
import modele.Carte;
import modele.Joueur;

public class PanelMain extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JButton[] boutonsMain = new JButton[5];
	private JButton boutonPioche = new JButton();
	private JButton boutonDefausse= new JButton();
	private JLabel labelProgramme = new JLabel();
	private JPanel container;

	public PanelMain(Joueur joueurEnCours) throws IOException{
		
		boutonsMain[0] = new JButton("");
		boutonsMain[1] = new JButton("");
		boutonsMain[2] = new JButton("");
		boutonsMain[3] = new JButton("");
		boutonsMain[4] = new JButton("");
		boutonEnableFalse();

        container = new JPanel();
        container.setLayout(new GridLayout(1,5, 60, 60));
		container.add(boutonsMain[0]);
		container.add(boutonsMain[1]);
		container.add(boutonsMain[2]);
		container.add(boutonsMain[3]);
		container.add(boutonsMain[4]);
		container.add(boutonPioche);
		container.add(boutonDefausse);
		container.add(labelProgramme);
		
		this.setSize(600, 500);
        this.add(container);
        this.setVisible(true);

        // Affichage de la main du joueur
		affichageMain(joueurEnCours.getMain());
	}
	
	public void affichageMain(ArrayList<Carte> main){
		for (int i = 0; i < 5; i++){
			boutonsMain[i].setText(main.get(i).toString());
			boutonsMain[i].setActionCommand(i+"");
			container.add(boutonsMain[i]);
		}
		this.add(container);
	}
	
	public void boutonEnableFalse(){
		for (int i = 0; i < 5; i++) {
			boutonsMain[i].setEnabled(false);
		}	
	}
	
	public void boutonEnableTrue(){
		for (int i = 0; i < 5; i++) {
			boutonsMain[i].setEnabled(true);
		}	
	}
	
	public int nombreCartesSelectionnees(){
		int compteur = 0;
		for (int i = 0; i < 5; i++){
			if (!boutonsMain[i].isEnabled())
				compteur++;
		}
		return compteur;
	}

	public void enregistreEcouteur(Controleur controleur) {
		for (int i = 0; i < 5; i++) {
			boutonsMain[i].addActionListener(controleur);
		}		
	}
	
	public void oneBoutonDisabled(JButton button){
		button.setEnabled(false);
	}
	
	// Getters et setters
	public JButton[] getBoutonsMain() {
		return boutonsMain;
	}
	public void setBoutonsMain(JButton[] boutonsMain) {
		this.boutonsMain = boutonsMain;
	}	
	public JButton getBoutonPioche() {
		return boutonPioche;
	}
	public JButton getBoutonDefausse() {
		return boutonDefausse;
	}
	public JLabel getLabelProgramme() {
		return labelProgramme;
	}


}
