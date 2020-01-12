package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import modele.*;

public class PanelPlateau extends JPanel implements AdjustmentListener{

	private static final long serialVersionUID = 1L;
	private Plateau plateau;
	private JTable table;
	private ModelPlateau tableur;
	private TableModel tm;

	public PanelPlateau(int nbJoueur) throws IOException {	
		plateau = new Plateau();
		plateau.preparationPlateau(nbJoueur);
		
		// Affichage
		tableur = new ModelPlateau();
		/*for(int i=0;i<8;i++){
			tableur.addColumn("");
		}
		tableur.setRowCount(8);*/
		
		
		table = new JTable(tableur);
		table.setPreferredScrollableViewportSize(new Dimension(800, 800));
		add(new JScrollPane(table), BorderLayout.CENTER);

		setLocation(200, 300);
		setVisible(true);
		table.setRowHeight(100);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setAutoResizeMode(JTable.WIDTH);
		
        table.setModel(tableur);
        //tm = table.getModel();
        
        // Affichage
        afficherPlateau();
        plateau.afficherPlateauConsole();
	}
	
	public void afficherPlateau() throws IOException{
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				Tuile tuile = plateau.getContenuPlateau()[i][j];
				tableur.setValueAt(tuile, i, j);
			}
		}
	}
	
	public void refresh() {
		tableur.fireTableDataChanged();
	}
	
	// Getters et setters
	public TableModel getTm() {
		return tm;
	}
	public void setTm(TableModel tm) {
		this.tm = tm;
	}
	public ModelPlateau getTableur() {
		return tableur;
	}
	public void setTableur(ModelPlateau tableur) {
		this.tableur = tableur;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public Plateau getPlateau() {
		return plateau;
	}
	public void setP(Plateau plateau) {
		this.plateau = plateau;
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
