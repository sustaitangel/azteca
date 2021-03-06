package Panel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Config extends JFrame {

	private JPanel contentPane;
	private JTextField txtServidor;
	private JTextField txtCliente;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JLabel lblCliente = new JLabel();
	private JLabel lblServidor = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Config frame = new Config();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Config() {
		setTitle("--Configuraci\u00F3n de Base de Datos--");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlightText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipoDeInstalacin = new JLabel("Tipo de Instalaci\u00F3n");
		lblTipoDeInstalacin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipoDeInstalacin.setForeground(new Color(128, 0, 0));
		lblTipoDeInstalacin.setBounds(10, 11, 179, 25);
		contentPane.add(lblTipoDeInstalacin);
		
		JRadioButton rdbtnServidor = new JRadioButton("Servidor");
		rdbtnServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnServidor.isSelected()){
					lblServidor.setForeground(new Color(76,197,3));
					lblCliente.setForeground(new Color(255,0,0));
					txtServidor.setEnabled(true);
					txtCliente.setEnabled(false);
					txtCliente.setText("");
				}
			}
		});
		rdbtnServidor.setBackground(new Color(255, 255, 255));
		rdbtnServidor.setBounds(10, 39, 109, 23);
		contentPane.add(rdbtnServidor);
		
		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCliente.setForeground(new Color(76,197,3));
				lblServidor.setForeground(new Color(255,0,0));
				txtCliente.setEnabled(true);
				txtServidor.setEnabled(false);
				txtServidor.setText("");
			}
		});
		rdbtnCliente.setBackground(new Color(255, 255, 255));
		rdbtnCliente.setBounds(121, 39, 109, 23);
		contentPane.add(rdbtnCliente);
		
		lblServidor.setText("Direcci\u00F3n del Servidor:");
		lblServidor.setForeground(new Color(255, 0, 0));
		lblServidor.setBounds(10, 83, 154, 14);
		contentPane.add(lblServidor);
		
		txtServidor = new JTextField();
		txtServidor.setEnabled(false);
		txtServidor.setToolTipText("Generalmente el servidor locacl tiene la siguiente direcci\u00F3n \"127.0.0.1\" sin comillas");
		txtServidor.setBounds(174, 80, 101, 20);
		contentPane.add(txtServidor);
		txtServidor.setColumns(10);
		
		lblCliente.setText("Direccion IP (fija) de la computadora servidor:");
		lblCliente.setForeground(new Color(255, 69, 0));
		lblCliente.setBounds(10, 119, 273, 14);
		contentPane.add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setEnabled(false);
		txtCliente.setToolTipText("Ejemplo \"192.168.1.70\" ");
		txtCliente.setBounds(293, 116, 101, 20);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);
		
		JLabel lblUsuarioDeLa = new JLabel("Usuario de la Base de Datos:");
		lblUsuarioDeLa.setBounds(10, 161, 166, 14);
		contentPane.add(lblUsuarioDeLa);
		
		txtUser = new JTextField();
		txtUser.setBounds(181, 158, 86, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 199, 80, 14);
		contentPane.add(lblContrasea);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(98, 196, 91, 20);
		contentPane.add(txtPass);
		
		ButtonGroup  grupo=new ButtonGroup();
		grupo.add(rdbtnCliente);
		grupo.add(rdbtnServidor);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Servidor;
				String User=txtUser.getText();
				String pass=txtPass.getText();
				if(rdbtnServidor.isSelected()){
					Servidor=txtServidor.getText();
				}else{
					Servidor=txtCliente.getText();
				}
				File file= new File("C:\\azteca\\ConfigDtb.config");
				if(!file.exists()){
				try {
					if (file.createNewFile()){
						System.out.print("Se ha creado");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				}
				try {
					PrintWriter escribir= new PrintWriter(file);
					escribir.println(Servidor);
					escribir.println(User);
					escribir.println(pass);
					escribir.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(Servidor+" "+User+" "+pass);
				limpiar();
				Config.this.dispose();
			}
		});
		btnGuardar.setBounds(335, 227, 89, 23);
		contentPane.add(btnGuardar);
	}
	public void limpiar(){
		txtServidor.setText("");
		txtCliente.setText("");
		txtUser.setText("");
		txtPass.setText("");
	}
}
