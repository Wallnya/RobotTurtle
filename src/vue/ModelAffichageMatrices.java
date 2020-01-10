package vue;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class ModelAffichageMatrices extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	public boolean isCellEditable(int indLigne, int indCol) {
		return false;
	}


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}    
}
