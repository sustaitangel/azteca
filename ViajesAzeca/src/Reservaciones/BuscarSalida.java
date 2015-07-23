package Reservaciones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Conexiones.Conexion;
import Qwertys.Comunes;

public class BuscarSalida {
	public void buscar(String fechaDtb,DefaultTableModel modelo,JTable tabla){
		Conexion cx=new Conexion();
		Connection cn=cx.conexion();
		String sql1="";
		Comunes n=new Comunes();
		sql1=n.SelectWhere("id_salida,id_camion,responsable,telefono", "salida", "fecha_salida", fechaDtb);
		try {
			Statement comando;
			comando = cn.createStatement();		
			ResultSet rs01= comando.executeQuery(sql1);							
			ResultSetMetaData rsx1=rs01.getMetaData();
			int nColumn1=rsx1.getColumnCount();
			while(rs01.next()){
				Object[] fila= new Object[nColumn1];
					for(int y=0;y<nColumn1;y++){
						fila[y]=rs01.getObject(y+1);
					}
					
					modelo.addRow(fila);
				}				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error "+e);
				e.printStackTrace();
			}
	}

}
