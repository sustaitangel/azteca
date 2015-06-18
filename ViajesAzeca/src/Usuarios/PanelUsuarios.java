package Usuarios;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class PanelUsuarios extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelUsuarios frame = new PanelUsuarios();
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
	public PanelUsuarios() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setRootPaneCheckingEnabled(false);
		setFrameIcon(new ImageIcon(PanelUsuarios.class.getResource("/Imagenes/client.png")));
		setTitle("-- Usuarios Viajes Azteca --");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 662, 449);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBounds(10, 11, 626, 397);
		AltaUsuarios n=new AltaUsuarios();
		tabbedPane.addTab("Alta Usuarios",null,n,null);
		getContentPane().add(tabbedPane);

	}
}
