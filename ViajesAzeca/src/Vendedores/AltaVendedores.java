package Vendedores;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import Usuarios.AltaDtb;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaVendedores extends JPanel {
	private JTextField txtTel;
	private JTextField txtAp_mat;
	private JTextField txtAp_pat;
	private JTextField txtNombre;
	private JTextField txtUbi;
	private JTextField txtCom;
	private JTextField txtAl;
	private JTextField txtDel;
	

	/**
	 * Create the panel.
	 */
	public AltaVendedores() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel label = new JLabel(new ImageIcon("C:\\azteca\\ViajesAzeca\\src\\Imagenes\\user.png"));
		label.setBounds(438, 24, 164, 283);
		add(label);
		
		JLabel label_1 = new JLabel("Nombre:");
		label_1.setBounds(21, 11, 71, 22);
		add(label_1);
		
		JLabel label_2 = new JLabel("Apellido Paterno:");
		label_2.setBounds(21, 59, 102, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("Apellido Materno:");
		label_3.setBounds(21, 109, 102, 14);
		add(label_3);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setBounds(21, 157, 102, 14);
		add(lblTelefono);
		
		JLabel lblUbicacion = new JLabel("Ubicaci\u00F3n:");
		lblUbicacion.setBounds(21, 201, 102, 14);
		add(lblUbicacion);
		
		JLabel lblComisin = new JLabel("Comisi\u00F3n:");
		lblComisin.setBounds(21, 250, 102, 14);
		add(lblComisin);
		
		JLabel lblFolioDel = new JLabel("Folio del:");
		lblFolioDel.setBounds(25, 293, 52, 14);
		add(lblFolioDel);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(151, 154, 130, 20);
		add(txtTel);
		
		txtAp_mat = new JTextField();
		txtAp_mat.setColumns(10);
		txtAp_mat.setBounds(151, 106, 130, 20);
		add(txtAp_mat);
		
		txtAp_pat = new JTextField();
		txtAp_pat.setColumns(10);
		txtAp_pat.setBounds(151, 56, 130, 20);
		add(txtAp_pat);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(151, 11, 130, 20);
		add(txtNombre);
		
		JButton button = new JButton("Guardar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaDtbVendedor alta=new AltaDtbVendedor();
				alta.alta(txtNombre, txtAp_pat, txtAp_mat, txtTel, txtUbi, txtCom, txtDel,txtAl);
			}
		});
		button.setIcon(new ImageIcon("C:\\azteca\\ViajesAzeca\\src\\Imagenes\\done.png"));
		button.setBounds(303, 341, 130, 41);
		add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaDtbVendedor n=new AltaDtbVendedor();
				n.Limpiar(txtNombre, txtAp_pat, txtAp_mat, txtTel, txtUbi, txtCom, txtDel,txtAl);
			}
		});
		button_1.setIcon(new ImageIcon("C:\\azteca\\ViajesAzeca\\src\\Imagenes\\cancel_travel.png"));
		button_1.setBounds(457, 341, 131, 41);
		add(button_1);
		
		JLabel lblAl = new JLabel("al:");
		lblAl.setBounds(178, 293, 46, 14);
		add(lblAl);
		
		txtUbi = new JTextField();
		txtUbi.setBounds(151, 198, 130, 20);
		add(txtUbi);
		txtUbi.setColumns(10);
		
		txtCom = new JTextField();
		txtCom.setBounds(151, 247, 130, 20);
		add(txtCom);
		txtCom.setColumns(10);
		
		txtAl = new JTextField();
		txtAl.setBounds(221, 290, 60, 20);
		add(txtAl);
		txtAl.setColumns(10);
		
		txtDel = new JTextField();
		txtDel.setBounds(89, 290, 60, 20);
		add(txtDel);
		txtDel.setColumns(10);

	}
}
