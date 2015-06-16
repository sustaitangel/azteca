package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import Imagenes.Img;
import Principal.Principal;
import Qwertys.IniSesion;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/autobus.png")));
		setTitle("--Viajes Azteca-- Iniciar Sesión");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 428, 198);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		Img n=new Img();
		JLabel label = new JLabel(n.login());
		label.setBounds(277, 11, 125, 129);
		contentPane.add(label);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(new Color(139, 0, 0));
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBackground(new Color(255, 255, 255));
		lblUsuario.setBounds(10, 50, 77, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(new Color(139, 0, 0));
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(10, 90, 95, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblBienvendido = new JLabel("Bienvenido");
		lblBienvendido.setForeground(new Color(128, 0, 0));
		lblBienvendido.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblBienvendido.setBounds(152, 11, 125, 23);
		contentPane.add(lblBienvendido);
		
		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car=e.getKeyChar();
				String vacio=txtPassword.getText();
				if(car==KeyEvent.VK_ENTER && vacio.length()==0 ){
					JOptionPane.showMessageDialog(txtUsuario, "Escriba Contraseña");
										
				}
				if(car==KeyEvent.VK_ENTER && vacio.length()!=0) {
						IniSesion ini=new IniSesion();
						ini.iniSecion(txtUsuario, txtPassword);
						System.out.println("hola"+IniSesion.conta);
						if(IniSesion.conta>=5){
						
						JOptionPane.showMessageDialog(txtUsuario,"Ha Excedido el número de intentos");
						Principal x=new Principal();
						x.bloqueo();
					}
				}
			}
		});
		txtUsuario.setBounds(97, 49, 113, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car=e.getKeyChar();
				if(car==KeyEvent.VK_ENTER){
					IniSesion n=new IniSesion();
					n.iniSecion(txtUsuario, txtPassword);
					System.out.println("hola"+IniSesion.conta);
					if(IniSesion.conta>=5){
						
						JOptionPane.showMessageDialog(txtUsuario,"Ha Excedido el número de intentos");
						Principal x=new Principal();
						x.bloqueo();
					}
				}
			}
		});
		txtPassword.setBounds(97, 89, 113, 20);
		contentPane.add(txtPassword);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.this.dispose();
			}
		});
		btnCancelar.setBounds(10, 125, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pass=new String(txtPassword.getPassword());
				if(pass.length()==0){
					JOptionPane.showMessageDialog(txtUsuario, "Escriba Contraseña");
				}else{
				IniSesion ini=new IniSesion();
				ini.iniSecion(txtUsuario, txtPassword);
				
				System.out.println("hola"+IniSesion.conta);
					if(IniSesion.conta>=5){
						
						JOptionPane.showMessageDialog(txtUsuario,"Ha Excedido el número de intentos");
						Principal x=new Principal();
						x.bloqueo();
					}
				}
			}
		});
		btnEntrar.setBounds(121, 125, 89, 23);
		contentPane.add(btnEntrar);
	}

}
