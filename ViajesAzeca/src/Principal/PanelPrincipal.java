package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;

import Imagenes.Img;

import java.awt.Color;

public class PanelPrincipal extends JFrame {

	private JDesktopPane contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelPrincipal frame = new PanelPrincipal();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PanelPrincipal() {
		setTitle("--Viajes Azteca--");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 610);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JDesktopPane();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Img fondo=new Img();
		JLabel lblNewLabel = new JLabel(fondo.fondo());
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setBounds(214, 198, 975, 311);
		contentPane.add(lblNewLabel);
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
