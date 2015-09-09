package Reservaciones;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import Principal.RelojFecha;
import javax.swing.JRadioButton;

public class agregar extends JPanel {

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("null")
	public agregar() {
		setLayout(null);
		setBounds(10, 154, 400, 468);		
		setBackground(Color.WHITE);
		setBorder(new TitledBorder(null, "Datos Generales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblDia_1 = new JLabel("Fecha:");
		lblDia_1.setBounds(10, 41, 71, 14);
		add(lblDia_1);		
		
		JLabel lblCamin = new JLabel("Cami\u00F3n:");
		lblCamin.setBounds(10, 87, 71, 14);
		add(lblCamin);
	
		JLabel lblChofer = new JLabel("Ch\u00F3fer:");
		lblChofer.setBounds(10, 131, 71, 14);
		//setVisible(false);
		add(lblChofer);



		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setBounds(10, 174, 71, 14);
		add(lblTelefono);
	
		JLabel Asientos = new JLabel("Reservados:");
		Asientos.setBounds(10, 245, 106, 14);
		add(Asientos);
	
	
			JLabel lblFecha = new JLabel("");
			String dia=PanelReservaciones.cmbdia.getSelectedItem().toString();
			String mes1=PanelReservaciones.cmbMes.getSelectedItem().toString();
			String ano=PanelReservaciones.txtAno.getText();
			String fecha=dia+" / "+mes1+" / "+ano;
			
			lblFecha.setText(fecha);
			lblFecha.setBounds(107, 41, 164, 14);
			add(lblFecha);
			
			JTextField txtCamion = new JTextField();
			RestrictedTextField n=new RestrictedTextField(txtCamion);
			txtCamion.setBounds(107, 84, 30, 20);
			add(txtCamion);
			txtCamion.setColumns(10);
			
			JTextField txtChofer = new JTextField();
			txtChofer.setBounds(107, 128, 111, 20);
			add(txtChofer);
			txtChofer.setColumns(10);
			
			JTextField txtTelefono = new JTextField();
			RestrictedTextField y=new RestrictedTextField(txtTelefono);
			//txtTelefono.setVisible(false);
			txtTelefono.setBounds(107, 171, 86, 20);
			add(txtTelefono);
			txtTelefono.setColumns(10);
			
			JTextField txtReservados = new JTextField();
			txtReservados.setEditable(false);
			txtReservados.setText("0");
			txtReservados.setBounds(107, 242, 30, 20);
			add(txtReservados);
			txtReservados.setColumns(10);
			
			
			JButton btnGuardar = new JButton("Guardar");
			btnGuardar.setBounds(301, 295, 89, 23);
			add(btnGuardar);
			
			JLabel lblDestino = new JLabel("Destino:");
			lblDestino.setBounds(10, 212, 46, 14);
			add(lblDestino);
			JComboBox cmbDestino = new JComboBox();
			cmbDestino.setModel(new DefaultComboBoxModel(new String[] {"Seleccione Estado", "Bakersfield", "Bloomington", "Coachella Indio", "El Monte", "El Paso", "Las Vegas", "Los Angeles", "Pacoima", "Phoenix"}));
			cmbDestino.setBounds(107, 208, 132, 20);
			add(cmbDestino);
			n.setOnlyNums(true);
			y.setOnlyNums(true);
			
	}
}