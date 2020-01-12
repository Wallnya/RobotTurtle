package vue;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import modele.Data;

public class ModelAffichageMatrices extends DefaultTableModel implements Data{
	private static final long serialVersionUID = 1L;
	
	public ModelAffichageMatrices() {
		//on définit le modèle de la table
		this.setColumnIdentifiers(Data.INTITULES);
		this.setRowCount(8);
		for(int i = 0;i<8;i++) {
			for(int j=0;j<8;j++) {
				this.isCellEditable(i, j);
			}
		}
	}
	
	public boolean isCellEditable(int indLigne, int indCol, boolean value) {
		return value;
	}
	
	@Override
	public Class<String> getColumnClass(int indCol) {
		return String.class;
	}
}