package Vendedores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Conexiones.Conexion;
import Qwertys.Comunes;


public class BusquedaVendedor {
	Conexion cx=new Conexion();
	Connection cn=cx.conexion();
	public void busqueda(JTextField txtBuscar,DefaultTableModel modelo,JTable tabla){		
		String sql1="";
		Comunes q=new Comunes();
		sql1=q.SelectLike("*", "vendedor", "nombre_vendedor", txtBuscar.getText());
		limpiarTabla(tabla, modelo);
		/*
			
		String delimitadores= " ";
		String[] palabrasSeparadas = cadena.split(delimitadores);		
		
		
		if(palabrasSeparadas.length>1){
			if(palabrasSeparadas.length==2){
			 sql1=q.SelectWhere("*", "vendedor", "nombre", txtBuscar.getText());
			}
		}else{
			sql1=q.SelectWhere("*", "vendedor", "nombre", txtBuscar.getText());
			}
		*/
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
				JOptionPane.showMessageDialog(txtBuscar, "Error "+e);
				e.printStackTrace();
			}
	}
	public void limpiarTabla(JTable table_1, DefaultTableModel modelo){
		int n=table_1.getRowCount();
		for(int i=1;i<=n;i++){
               modelo.removeRow(0);
		}
	}
}
