package Reservaciones;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class cliente extends JInternalFrame {
	private JTextField txtFolio;
	private JTextField txtNombre;
	private JTextField txtPaterno;
	private JTextField txtMaterno;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				int num=0;
				try {
					cliente frame = new cliente(num);
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
	public cliente(int num) {
		setFrameIcon(new ImageIcon(cliente.class.getResource("/Imagenes/as01.png")));
		setBackground(Color.WHITE);
		setClosable(true);
		setTitle("Reservar Asiento");
		setBounds(100, 100, 482, 325);
		getContentPane().setLayout(null);
		
		JLabel lblFolio = new JLabel("Folio:");
		lblFolio.setBounds(10, 22, 46, 14);
		getContentPane().add(lblFolio);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 59, 62, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApPaterno = new JLabel("Ap. Paterno:");
		lblApPaterno.setBounds(10, 93, 82, 14);
		getContentPane().add(lblApPaterno);
		
		JLabel lblApMaterno = new JLabel("Ap. Materno:");
		lblApMaterno.setBounds(10, 130, 82, 14);
		getContentPane().add(lblApMaterno);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(10, 169, 62, 14);
		getContentPane().add(lblTelfono);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(10, 207, 62, 14);
		getContentPane().add(lblCorreo);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 247, 62, 14);
		getContentPane().add(lblPrecio);
		
		JRadioButton rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setBackground(Color.WHITE);
		rdbtnSi.setBounds(311, 18, 53, 23);
		getContentPane().add(rdbtnSi);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBackground(Color.WHITE);
		rdbtnNo.setBounds(378, 18, 53, 23);
		getContentPane().add(rdbtnNo);
		
		JLabel lblBoleto = new JLabel("Boleto:");
		lblBoleto.setBounds(232, 22, 46, 14);
		getContentPane().add(lblBoleto);
		
		JLabel lblVendedor = new JLabel("Vendedor:");
		lblVendedor.setBounds(232, 74, 71, 14);
		getContentPane().add(lblVendedor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(311, 71, 107, 20);
		getContentPane().add(comboBox);
		
		JLabel lblAsiento = new JLabel("Asiento:");
		lblAsiento.setBounds(232, 119, 71, 14);
		getContentPane().add(lblAsiento);
		String nom=String.valueOf(num);
		JLabel lblNumero = new JLabel(nom);
		lblNumero.setBounds(311, 119, 46, 14);
		getContentPane().add(lblNumero);
		
		txtFolio = new JTextField();
		txtFolio.setBounds(103, 19, 86, 20);
		getContentPane().add(txtFolio);
		txtFolio.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(103, 56, 86, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPaterno = new JTextField();
		txtPaterno.setBounds(103, 90, 86, 20);
		getContentPane().add(txtPaterno);
		txtPaterno.setColumns(10);
		
		txtMaterno = new JTextField();
		txtMaterno.setBounds(102, 127, 86, 20);
		getContentPane().add(txtMaterno);
		txtMaterno.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(103, 166, 86, 20);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(103, 204, 86, 20);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(103, 241, 86, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(311, 240, 89, 23);
		getContentPane().add(btnGuardar);

	}
}
