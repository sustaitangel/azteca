package Reservaciones;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;

public class PanelSalidas extends JPanel {

	private  String matriz[][]={};
	private  String vector[]={"ID salida","Cami�n","Responsable","Tel�fono"};
	private JTable table= new JTable();
	private  DefaultTableModel modelo= new DefaultTableModel(matriz,vector);

	/**
	 * Create the panel.
	 */
	
	
	public PanelSalidas(String fechaDtb) {
		BuscarSalida n= new BuscarSalida();
		n.buscar(fechaDtb, modelo, table);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 575, 112);
		add(scrollPane);
		table = new JTable();
		table.setBounds(0, 0, 1, 1);
		table.setBackground(SystemColor.control);
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		

	}
}
