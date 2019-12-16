package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modele.*;

public class PanelPlateau extends JPanel implements TableModelListener{

	private static final long serialVersionUID = 1L;
	private Plateau plateau;
	private JTable table;
	private DefaultTableModel tableur;
	private TableModel tm;

	public PanelPlateau(int nbJoueur) throws IOException {	
		plateau = new Plateau();
		plateau.preparationPlateau(nbJoueur);
		
		// Affichage
		tableur = new DefaultTableModel();
		for(int i=0;i<8;i++){
			tableur.addColumn("");
		}
		tableur.setRowCount(8);
		
		table = new JTable(tableur);
		table.setPreferredScrollableViewportSize(new Dimension(800, 800));
		add(new JScrollPane(table), BorderLayout.CENTER);

		tableur.addTableModelListener(this);
		setLocation(200, 300);
		setVisible(true);
		table.setRowHeight(100);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setAutoResizeMode(JTable.WIDTH);
		
        table.setModel(tableur);
        tm = table.getModel();
        
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
	
	@Override
	public void tableChanged(TableModelEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	// Getters et setters
	public TableModel getTm() {
		return tm;
	}
	public void setTm(TableModel tm) {
		this.tm = tm;
	}
	public DefaultTableModel getTableur() {
		return tableur;
	}
	public void setTableur(DefaultTableModel tableur) {
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
}
