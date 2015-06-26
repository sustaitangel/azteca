package Vendedores;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Usuarios.BusquedaUsuario;
import Usuarios.ModifacarUsuarioDtb;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ModificarVendedor extends JPanel {
	private JTextField txtBuscar;
	private JTable table;
	//private JTable table;
	
	/**
	 * Create the panel.
	 */
	public ModificarVendedor() {	    
		setBackground(Color.WHITE);
		setLayout(null);
		table = new JTable(){
			public boolean isCellEditable(int rowIndex, int columnIndex) { 
				if (columnIndex==0) return false;
				else return true; 
			} 
		};
		table.setBackground(Color.WHITE);
		/*String matriz[][]={};
		String vector[]={"ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Tel\u00E9fono", "Ubicaci\u00F3n", "Comisi\u00F3n", "Folio del ", "al"};	
		DefaultTableModel modelo= new DefaultTableModel(matriz,vector){
			public boolean isCellEditable(int rowIndex, int columnIndex) { 
				if (columnIndex==0) return false; 
				else return true; 
				} 
		};*/
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Tel\u00E9fono", "Ubicaci\u00F3n", "Comisi\u00F3n", "Folio del ", "al"
			}
		));
		DefaultTableModel modelo=(DefaultTableModel) table.getModel();
		
		
		JButton button = new JButton("Buscar Usuario");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BusquedaVendedor b=new BusquedaVendedor();
				b.busqueda(txtBuscar, modelo, table);
			}
		});
		button.setIcon(new ImageIcon(ModificarVendedor.class.getResource("/Imagenes/find.png")));
		button.setBounds(37, 34, 156, 23);
		add(button);
		
		JScrollPane scrollPane = new JScrollPane();		
		scrollPane.setBounds(20, 129, 735, 192);
		add(scrollPane);			
		scrollPane.setViewportView(table);
						
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char ec=e.getKeyChar();
				if(ec==KeyEvent.VK_ENTER){
					BusquedaVendedor b=new BusquedaVendedor();
					b.busqueda(txtBuscar, modelo, table);					;
				}
			}
		});
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(218, 34, 141, 23);
		add(txtBuscar);
		
		JButton button_1 = new JButton("Guardar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarVendedorDtb n= new ModificarVendedorDtb();
				n.modificar(table);
			}
		});
		button_1.setIcon(new ImageIcon(ModificarVendedor.class.getResource("/Imagenes/done.png")));
		button_1.setBounds(449, 349, 133, 41);
		add(button_1);
		
		JButton button_2 = new JButton("Eliminar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected;
				selected=table.getSelectedRow(); 
				if(selected>=0){
				ModificarVendedorDtb x=new ModificarVendedorDtb();
				x.eliminar(table);
				BusquedaUsuario b=new BusquedaUsuario();
				b.busqueda(txtBuscar, modelo, table);
				}else{
					JOptionPane.showMessageDialog(null, "Seleccione Un Vendedor");
				}
			}
		});
		button_2.setIcon(new ImageIcon(ModificarVendedor.class.getResource("/Imagenes/cancel_travel.png")));
		button_2.setBounds(632, 349, 119, 41);
		add(button_2);

	}
}
