package Usuarios;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

import Conexiones.Conexion;
import Imagenes.Img;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class AltaUsuarios extends JPanel {
	private JTextField txtNombre;
	private JTextField txtAp_pat;
	private JTextField txtAp_mat;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JPasswordField txtPass1;
	int tipo;
	String tipo1;

	/**
	 * Create the panel.
	 */
	public AltaUsuarios() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 11, 71, 22);
		add(lblNombre);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno:");
		lblApellidoPaterno.setBounds(10, 60, 102, 14);
		add(lblApellidoPaterno);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno:");
		lblApellidoMaterno.setBounds(10, 110, 102, 14);
		add(lblApellidoMaterno);
		
		JLabel lblTipoDeUsuario = new JLabel("Nombre de Usuario:");
		lblTipoDeUsuario.setBounds(10, 158, 102, 14);
		add(lblTipoDeUsuario);
		
		JLabel lblPerfilDeUsuario = new JLabel("Contrase\u00F1a:");
		lblPerfilDeUsuario.setBounds(10, 202, 102, 14);
		add(lblPerfilDeUsuario);
		
		JLabel lblRepitaContrasea = new JLabel("Repita Contrase\u00F1a:");
		lblRepitaContrasea.setBounds(10, 251, 102, 14);
		add(lblRepitaContrasea);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(140, 12, 130, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtAp_pat = new JTextField();
		txtAp_pat.setBounds(140, 57, 130, 20);
		add(txtAp_pat);
		txtAp_pat.setColumns(10);
		
		txtAp_mat = new JTextField();
		txtAp_mat.setBounds(140, 107, 130, 20);
		add(txtAp_mat);
		txtAp_mat.setColumns(10);
		
		txtUser = new JTextField();
		txtUser.setBounds(140, 155, 130, 20);
		add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(140, 199, 130, 20);
		add(txtPass);
		
		txtPass1 = new JPasswordField();
		txtPass1.setBounds(140, 248, 130, 20);
		add(txtPass1);
		
		JLabel lblPerfilDeUsuario_1 = new JLabel("Perfil de Usuario:");
		lblPerfilDeUsuario_1.setBounds(10, 294, 86, 14);
		add(lblPerfilDeUsuario_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipo1=(String)comboBox.getSelectedItem();
				 if(tipo1.equals("Administrador"))
				 {
					 tipo=1;
				 }
				 if(tipo1.equals("Empleado"))
				 {
					 tipo=2;
				 }
			}
		});
		Conexion con=new Conexion();
		ArrayList<TipoUsuario>lista1= con.obtenerTipos();
		for (int i=0;i<lista1.size();i++)
		{
			TipoUsuario otipo=lista1.get(i);
			comboBox.addItem(otipo.getNombreArticulo());
		
		}
		comboBox.setBounds(140, 291, 130, 20);
		add(comboBox);
		
		Img n=new Img();
		JLabel lblNewLabel = new JLabel(n.user());
		lblNewLabel.setBounds(393, 0, 164, 283);
		add(lblNewLabel);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaDtb alta=new AltaDtb();
				alta.alta(txtNombre, txtAp_pat, txtAp_mat, txtUser, txtPass, txtPass1, tipo);
			}
		});
		btnGuardar.setIcon(new ImageIcon(AltaUsuarios.class.getResource("/Imagenes/done.png")));
		btnGuardar.setBounds(305, 311, 130, 41);
		add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(AltaUsuarios.class.getResource("/Imagenes/cancel1.png")));
		btnCancelar.setBounds(457, 311, 131, 41);
		add(btnCancelar);

	}
}
