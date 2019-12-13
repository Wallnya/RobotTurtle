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
	private Plateau p;
	private JTable table;
	private DefaultTableModel tableur;
	private TableModel tm;

	public PanelPlateau(int nbJoueur) throws IOException {	
		p = new Plateau(nbJoueur);
		p.affichage();
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
		updatePlateau();
	}
	
	public TableModel getTm() {
		return tm;
	}

	public void setTm(TableModel tm) {
		this.tm = tm;
	}
	
    public void refresh() {
        tableur.fireTableDataChanged();
    }

	public void updatePlateau() throws IOException{
		for(int i=0;i<8;i++){
			for (int j=0;j<8;j++){
				if (p.getPlateau()[i][j] instanceof Tortue){
					tableur.setValueAt("tortue", i, j);
				}
				else if (p.getPlateau()[i][j] instanceof Obstacle){
					tableur.setValueAt("mur", i, j);
				}
				else if (p.getPlateau()[i][j] instanceof Joyau){
					tableur.setValueAt("joyau", i, j);
				}
				else{
					tableur.setValueAt("", i, j);
				}
			}
		}
	}

	@Override
	public void tableChanged(TableModelEvent arg0) {
		// TODO Auto-generated method stub
		
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

	public Plateau getP() {
		return p;
	}

	public void setP(Plateau p) {
		this.p = p;
	}
}
