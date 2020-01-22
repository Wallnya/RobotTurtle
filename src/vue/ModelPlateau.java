package vue;

import javax.swing.table.DefaultTableModel;

import modele.Data;

public class ModelPlateau extends DefaultTableModel implements Data{
	private static final long serialVersionUID = 1L;
	
	public ModelPlateau() {
		//on définit le modèle de la table
		this.setColumnIdentifiers(Data.INTITULES);
		this.setRowCount(8);
		for(int i = 0;i<8;i++) {
			for(int j=0;j<8;j++) {
				this.isCellEditable(i, j);
			}
		}
	}
	//On redéfinie le modèle de la table pour qu'aucune case ne soit modifiable. 
	public boolean isCellEditable(int indLigne, int indCol) {
		return false;
	}
	
	@Override
	public Class<String> getColumnClass(int indCol) {
		return String.class;
	}
}