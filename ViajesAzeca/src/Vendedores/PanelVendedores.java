package Vendedores;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

import java.awt.Color;

import javax.swing.JTabbedPane;

import Usuarios.AltaUsuarios;
import Usuarios.ModificarUsuario;
import Usuarios.PanelUsuarios;

import java.awt.BorderLayout;

public class PanelVendedores extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelVendedores frame = new PanelVendedores();
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
	public PanelVendedores() {
		setIconifiable(true);
		setClosable(true);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setRootPaneCheckingEnabled(false);
		setFrameIcon(new ImageIcon(PanelUsuarios.class.getResource("/Imagenes/client.png")));
		setTitle("-- Vendedores Viajes Azteca --");
		setBounds(100, 100, 803, 500);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		
		tabbedPane.setBounds(10, 10,770 , 435);		
		
		
		AltaVendedores n=new AltaVendedores();
		tabbedPane.addTab("Alta Vendedores",null,n,null);
		ModificarVendedor c=new ModificarVendedor();
		tabbedPane.addTab("Modificar",null,c,null);
		getContentPane().add(tabbedPane);
	}
}
