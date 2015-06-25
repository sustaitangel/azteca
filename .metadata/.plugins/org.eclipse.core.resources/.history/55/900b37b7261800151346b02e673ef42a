package Usuarios;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class ModificarUsuario extends JPanel {
	private JTextField txtUser;
	private JTextField txtNombre;
	private JTextField txtAp_paterno;
	private JTextField txtAp_materno;
	private JPasswordField txtPass;

	/**
	 * Create the panel.
	 */
	public ModificarUsuario() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNomreDeUsuario = new JLabel("Nomre de Usuario:");
		lblNomreDeUsuario.setBounds(10, 27, 120, 14);
		add(lblNomreDeUsuario);
		
		txtUser = new JTextField();
		txtUser.setBounds(140, 24, 127, 20);
		add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(ModificarUsuario.class.getResource("/Imagenes/find.png")));
		btnBuscar.setBounds(325, 18, 120, 33);
		add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 82, 79, 14);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(140, 79, 127, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno:");
		lblApellidoPaterno.setBounds(10, 139, 120, 14);
		add(lblApellidoPaterno);
		
		txtAp_paterno = new JTextField();
		txtAp_paterno.setBounds(140, 136, 127, 20);
		add(txtAp_paterno);
		txtAp_paterno.setColumns(10);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno:");
		lblApellidoMaterno.setBounds(10, 203, 120, 14);
		add(lblApellidoMaterno);
		
		txtAp_materno = new JTextField();
		txtAp_materno.setBounds(140, 200, 127, 20);
		add(txtAp_materno);
		txtAp_materno.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setBounds(10, 262, 79, 14);
		add(lblPassword);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(140, 259, 127, 20);
		add(txtPass);
		
		JLabel lblPerfil = new JLabel("Perfil:");
		lblPerfil.setBounds(10, 305, 79, 14);
		add(lblPerfil);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Administrador");
		rdbtnAdmin.setBackground(Color.WHITE);
		rdbtnAdmin.setBounds(95, 301, 112, 23);
		add(rdbtnAdmin);
		
		JRadioButton rdbtnEmpleado = new JRadioButton("Empleado");
		rdbtnEmpleado.setBackground(Color.WHITE);
		rdbtnEmpleado.setBounds(212, 301, 94, 23);
		add(rdbtnEmpleado);
		
		ButtonGroup  grupo=new ButtonGroup();
		grupo.add(rdbtnAdmin);
		grupo.add(rdbtnEmpleado);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(ModificarUsuario.class.getResource("/Imagenes/done.png")));
		btnGuardar.setBounds(325, 292, 120, 41);
		add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(ModificarUsuario.class.getResource("/Imagenes/cancel_travel.png")));
		btnCancelar.setBounds(455, 292, 112, 41);
		add(btnCancelar);

	}
}
