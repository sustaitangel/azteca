package Vendedores;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends DefaultTableModel {
	
	public boolean isCellEditable(int rowIndex, int columnIndex) { 
		if (columnIndex==0) return false; 
		else return true; 
		} 
}
