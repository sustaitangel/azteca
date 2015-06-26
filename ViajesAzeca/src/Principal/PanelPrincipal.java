package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;

import Imagenes.Img;
import Qwertys.IniSesion;
import Usuarios.PanelUsuarios;
import Vendedores.PanelVendedores;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPrincipal extends JFrame {

	private JDesktopPane contentPane;
	JLabel lblHora;
	RelojFecha relojFecha = new RelojFecha();

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
		setBounds(100, 100, 1042, 760);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Reservaciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNuevaReservacion = new JMenuItem("Nueva Reservaci\u00F3n");
		mntmNuevaReservacion.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/travel.png")));
		mnNewMenu.add(mntmNuevaReservacion);
		
		JMenuItem mntmCancelarReservacion = new JMenuItem("Cancelar Reservaci\u00F3n");
		mntmCancelarReservacion.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/cancel_travel.png")));
		mnNewMenu.add(mntmCancelarReservacion);
		
		JMenu mnAgenda = new JMenu("Agenda");
		menuBar.add(mnAgenda);
		
		JMenuItem mntmAgendarSalidaNacional = new JMenuItem("Agendar Salida Nacional");
		mntmAgendarSalidaNacional.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/calendar.png")));
		mnAgenda.add(mntmAgendarSalidaNacional);
		
		JMenuItem mntmVeragenda = new JMenuItem("Ver Agenda");
		mntmVeragenda.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/find.png")));
		mnAgenda.add(mntmVeragenda);
		
		JMenu mnCamiones = new JMenu("Camiones");
		menuBar.add(mnCamiones);
		
		JMenuItem mntmAltasbajas = new JMenuItem("Altas / Bajas");
		mntmAltasbajas.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/bus.png")));
		mnCamiones.add(mntmAltasbajas);
		
		JMenuItem mntmMantenimiento = new JMenuItem("Mantenimiento");
		mntmMantenimiento.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/tool.png")));
		mnCamiones.add(mntmMantenimiento);
		
		JMenuItem mntmEstadisticas = new JMenuItem("Estad\u00EDsticas");
		mntmEstadisticas.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/statistics.png")));
		mnCamiones.add(mntmEstadisticas);
		
		JMenu mnAltas = new JMenu("Clientes");
		menuBar.add(mnAltas);
		
		JMenuItem mntmAltaDeVendedores = new JMenuItem("Vista del Cliente");
		mntmAltaDeVendedores.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/find.png")));
		mnAltas.add(mntmAltaDeVendedores);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmUsuarioDelSistema = new JMenuItem("Usuarios del Sistema");
		mntmUsuarioDelSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelUsuarios n = new PanelUsuarios();
				contentPane.add(n);
				n.setLocation(200, 100);
				n.setVisible(true);
				n.toFront();
			}
		});
		mntmUsuarioDelSistema.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/1434408957_user-id.png")));
		mnUsuarios.add(mntmUsuarioDelSistema);
		
		JMenu mnVendedores = new JMenu("Vendedores");
		menuBar.add(mnVendedores);
		
		JMenuItem mntmEstadsticas = new JMenuItem("Estad\u00EDsticas");
		mntmEstadsticas.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/statistics.png")));
		mnVendedores.add(mntmEstadsticas);
		
		JMenuItem mntmAltasModificaciones = new JMenuItem("Altas / Modificaciones");
		mntmAltasModificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelVendedores n = new PanelVendedores();
				contentPane.add(n);
				n.setLocation(200, 100);
				n.setVisible(true);
				n.toFront();
			}
		});
		mntmAltasModificaciones.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/client.png")));
		mnVendedores.add(mntmAltasModificaciones);
		
		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		JMenu menu12 = new JMenu("-- "+IniSesion.loger1+" --");
		menuBar.add(menu12);
		
		JMenuItem  mntmCerrarSesion= new JMenuItem("Cerrar Sesi\u00F3n");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelPrincipal.this.dispose();
				Principal ob=new Principal();
				ob.llamar();
			}
		});
		mntmCerrarSesion.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/logout.png")));
		menu12.add(mntmCerrarSesion);
		
		JMenuItem mntmCambiarContrasea = new JMenuItem("Cambiar Contrase\u00F1a");
		mntmCambiarContrasea.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/Imagenes/pass.png")));
		menu12.add(mntmCambiarContrasea);
		contentPane = new JDesktopPane();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Img fondo=new Img();
		JLabel lblNewLabel = new JLabel(fondo.fondo());
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setBounds(196, 197, 975, 311);
		contentPane.add(lblNewLabel);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFecha = new JLabel("");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 43));
		lblFecha.setForeground(new Color(128, 0, 0));
		lblFecha.setBounds(511, 158, 494, 43);
		contentPane.add(lblFecha);
		
		relojFecha.fecha(lblFecha);
		lblHora = new JLabel("");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 43));
		lblHora.setForeground(new Color(128, 0, 0));
		lblHora.setBounds(567, 518, 249, 43);
		contentPane.add(lblHora);
		relojFecha.reloj(lblHora);
		
		JLabel lblUstedEstEn = new JLabel("Usted Est\u00E1 en el Sistema C\u00F3mo:");
		lblUstedEstEn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUstedEstEn.setForeground(new Color(0, 0, 139));
		lblUstedEstEn.setBounds(10, 653, 256, 36);
		contentPane.add(lblUstedEstEn);
		String nombre=IniSesion.loger;
		
		JLabel lblLols = new JLabel(nombre);
		lblLols.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLols.setForeground(new Color(0, 0, 128));
		lblLols.setBounds(272, 653, 256, 36);
		contentPane.add(lblLols);
	}
}
