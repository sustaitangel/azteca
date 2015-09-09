package Reservaciones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField; 

import Conexiones.Conexion;
import Qwertys.Comunes;

public class NuevaSalida {
	 
	public void nueva(JButton prob, JLabel lblSalida, int tipo){
			prob.setVisible(true);
			prob.setText("Agendar");
			lblSalida.setText("�Agendar Salida?");
			lblSalida.setForeground(new Color(139, 0, 0));
			prob.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					agregar n=new agregar();
					n.setBounds(10, 154, 400, 468);
					n.setVisible(true);
					n.setFocusable(true);
					PanelReservaciones.panelPrin.add(n);
					PanelReservaciones.panelPrin.updateUI();
				}
			});
	}
	public static int  id_salida=0;
	public int salida(JTextField txtCamion,
			JTextField txtChofer,JTextField txtTelefono, String fechaDtb, JComboBox cmbDestino){
		int idDestino= cmbDestino.getSelectedIndex();
		Conexion cx=new Conexion();
		Connection cn=cx.conexion();
		String sql1="";
		Comunes q=new Comunes();
		sql1=q.selectand2("id_camion, perfil_camion", Comunes.tablas[3], "id_camion", txtCamion.getText(), "perfil_camion", "2");
		cliente r=new cliente(0);
		r.setVisible(true);
		r.toFront();
		r.setLocation(420, 74);
		r.dispose();
		PanelReservaciones.panelPrin.add(r);
		if(idDestino==0){
			JOptionPane.showMessageDialog(null, "Seleccione Destino");
		}else{
		try {
			Statement comando;
			comando = cn.createStatement();		
			Statement comando1;
			comando1 = cn.createStatement();
			ResultSet rs01= comando.executeQuery(sql1);							
			if(rs01.next()){
				
				String Valores="'"+fechaDtb+"'"+","+"'"+txtCamion.getText()+"'"+","+"'"+txtChofer.getText()+"'"+","+"'"+txtTelefono.getText()+"'";
				String guardar=q.insertInto(Comunes.tablas[2], "fecha_salida, id_camion, Telefono, Responsable", Valores);
				JOptionPane.showMessageDialog(null, "Salida Guardada");
				PanelCamion n=new PanelCamion();
				n.setBounds(420, 74, 823, 350);
				n.setVisible(true);
				n.setLocation(420,74);
				n.setFocusable(true);
				PanelReservaciones.panelPrin.add(n);
				PanelReservaciones.panelPrin.updateUI();
				
				//System.out.println(guardar);
				comando1.execute(guardar);
				String salida=q.selectand2("id_salida","salida", "fecha_salida", fechaDtb, "id_camion", txtCamion.getText());
				ResultSet rs02= comando.executeQuery(salida);
				if(rs02.next()){
					id_salida=rs02.getInt("id_salida");
				}
			}else{
				JOptionPane.showMessageDialog(null, "El cami�n no existe o es de salida nacional ");
			}
					
			}catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error "+e);
				e.printStackTrace();
			}
	}
		txtCamion.setText("");txtChofer.setText("");txtTelefono.setText("");
		return id_salida;
	}
	
	public void guardarSalida(JButton btnGuardar,JTextField txtCamion,
			JTextField txtChofer,JTextField txtTelefono, String fechaDtb, JComboBox cmbDestino){
			
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salida(txtCamion, txtChofer, txtTelefono, fechaDtb, cmbDestino);
			}
		});
		
	}
}
	

