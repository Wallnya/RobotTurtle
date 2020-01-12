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
import modele.Data;
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

        container = new JPanel();
        container.setLayout(new GridLayout(1,5, 60, 60));
        
        boutonDefausse.setActionCommand("defausse");
        boutonPioche.setActionCommand("pioche");
        boutonsMain[0].setActionCommand(0+"");
        boutonsMain[1].setActionCommand(1+"");
        boutonsMain[2].setActionCommand(2+"");
        boutonsMain[3].setActionCommand(3+"");
        boutonsMain[4].setActionCommand(4+"");
        
        container.add(boutonDefausse);
        container.add(boutonPioche);
		container.add(labelProgramme);
		container.add(boutonsMain[0]);
		container.add(boutonsMain[1]);
		container.add(boutonsMain[2]);
		container.add(boutonsMain[3]);
		container.add(boutonsMain[4]);
		
		this.setSize(600, 500);
        this.add(container);
        this.setVisible(true);
       
        
        // Affichage de la main du joueur
		//affichageMain(joueurEnCours.getMain());
	}
	
	public void affichageMain(ArrayList<Carte> main){
		for (int i = 0; i < 5; i++){
			boutonsMain[i].setText(main.get(i).toString());
		}
	}
	
	public void affichageMainFalse(){
		for (int i = 0; i < 5; i++){
			boutonsMain[i].setText("ererererere");
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
	    boutonDefausse.addActionListener(controleur);
	    boutonPioche.addActionListener(controleur);
	}
	
	public void oneBoutonEnabledFalse(JButton button){
		button.setEnabled(false);
	}
	
	public void oneBoutonEnabledTrue(JButton button){
		button.setEnabled(true);
	}
	
	public void boutonsMainEnableFalse(){
		for (int i = 0; i < 5; i++) {
			oneBoutonEnabledFalse(boutonsMain[i]);
		}	
	}
	
	public void boutonsMainEnableTrue(){
		for (int i = 0; i < 5; i++) {
			oneBoutonEnabledTrue(boutonsMain[i]);
		}	
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
