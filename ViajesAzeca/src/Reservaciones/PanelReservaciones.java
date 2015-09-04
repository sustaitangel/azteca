package Reservaciones;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;
import Principal.RelojFecha;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public final class PanelReservaciones extends JInternalFrame {
	public static JTextField txtAno;
	public JLabel lblDia = new JLabel();
	public JLabel lblSalida = new JLabel("");
	JButton btnProb = new JButton("prob");
	JPanel Panel_alta = new JPanel();
	public static JComboBox cmbdia = new JComboBox();
	public static JComboBox cmbMes = new JComboBox();
	private JTextField txtCamion;
	private JTextField txtChofer;
	private JTextField txtTelefono;
	private JTextField txtReservados;
	JButton btnGuardar = new JButton("Guardar");
	JLabel lblFecha = new JLabel("");
	static JPanel panelPrin = new JPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelReservaciones frame = new PanelReservaciones();
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
	public PanelReservaciones() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		RelojFecha mes=new RelojFecha();
		
		panelPrin.setBackground(Color.WHITE);
		panelPrin.setBounds(0, 0, 1270, 633);
		getContentPane().add(panelPrin);
		panelPrin.setLayout(null);
				lblDia.setBounds(410, 12, 400, 41);
				panelPrin.add(lblDia);
		
				
		
				
				
				lblDia.setForeground(new Color(139, 0, 0));
				lblDia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
				
				JPanel panel = new JPanel();
				panel.setBounds(10, 74, 400, 69);
				panelPrin.add(panel);
				panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Salida", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel.setBackground(Color.WHITE);
				panel.setLayout(null);
				
				
				
				lblSalida.setForeground(new Color(139, 0, 0));
				lblSalida.setBounds(10, 21, 277, 23);
				panel.add(lblSalida);		
				
				btnProb.setBounds(285, 21, 89, 23);
				btnProb.setVisible(false);
				panel.add(btnProb);		
				Panel_alta.setBounds(10, 154, 400, 468);
				panelPrin.add(Panel_alta);
				
				Panel_alta.setBackground(Color.WHITE);
				Panel_alta.setBorder(new TitledBorder(null, "Datos Generales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				Panel_alta.setLayout(null);
				
				JLabel lblDia_1 = new JLabel("Fecha:");
				lblDia_1.setBounds(10, 41, 71, 14);
				Panel_alta.add(lblDia_1);
				
				JLabel lblCamin = new JLabel("Cami\u00F3n:");
				lblCamin.setBounds(10, 87, 71, 14);
				Panel_alta.add(lblCamin);
				
				JLabel lblChofer = new JLabel("Ch\u00F3fer:");
				lblChofer.setBounds(10, 131, 71, 14);
				Panel_alta.setVisible(false);
				Panel_alta.add(lblChofer);
				
				JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
				lblTelefono.setBounds(10, 174, 71, 14);
				Panel_alta.add(lblTelefono);
				
				JLabel Asientos = new JLabel("Reservados:");
				Asientos.setBounds(10, 245, 106, 14);
				Panel_alta.add(Asientos);
				
						String fecha=RelojFecha.dia+" / "+mes.fecha(lblFecha)+" / "+RelojFecha.ano;
						lblFecha.setText(fecha);
						lblFecha.setBounds(107, 41, 111, 14);
						lblFecha.setVisible(false);
						Panel_alta.add(lblFecha);
						
						txtCamion = new JTextField();
						RestrictedTextField n=new RestrictedTextField(txtCamion);
						txtCamion.setVisible(false);
						txtCamion.setBounds(107, 84, 30, 20);
						Panel_alta.add(txtCamion);
						txtCamion.setColumns(10);
						
						txtChofer = new JTextField();
						txtChofer.setBounds(107, 128, 111, 20);
						txtChofer.setVisible(false);
						Panel_alta.add(txtChofer);
						txtChofer.setColumns(10);
						
						txtTelefono = new JTextField();
						RestrictedTextField y=new RestrictedTextField(txtTelefono);
						txtTelefono.setVisible(false);
						txtTelefono.setBounds(107, 171, 86, 20);
						Panel_alta.add(txtTelefono);
						txtTelefono.setColumns(10);
						
						txtReservados = new JTextField();
						txtReservados.setEditable(false);
						txtReservados.setText("0");
						txtReservados.setVisible(false);
						txtReservados.setBounds(107, 242, 30, 20);
						Panel_alta.add(txtReservados);
						txtReservados.setColumns(10);
						
						
						btnGuardar.setBounds(301, 295, 89, 23);
						btnGuardar.setVisible(false);
						Panel_alta.add(btnGuardar);
						
						JLabel lblDestino = new JLabel("Destino:");
						lblDestino.setBounds(10, 212, 46, 14);
						Panel_alta.add(lblDestino);
						
						JComboBox comboBox = new JComboBox();
						comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione Estado", "Bakersfield", "Bloomington", "Coachella Indio", "El Monte", "El Paso", "Las Vegas", "Los Angeles", "Pacoima", "Phoenix"}));
						comboBox.setBounds(107, 208, 132, 20);
						Panel_alta.add(comboBox);
						
						JLabel lblDa = new JLabel("D\u00EDa: ");
						lblDa.setBounds(10, 29, 46, 14);
						panelPrin.add(lblDa);
						lblDa.setBackground(Color.WHITE);
						cmbdia.setBounds(39, 26, 54, 20);
						panelPrin.add(cmbdia);
						
						cmbdia.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								llenar();
								limpiar();
							}
						});
						cmbdia.setBackground(Color.WHITE);
						cmbdia.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
						
						JLabel lblMes = new JLabel("Mes:");
						lblMes.setBounds(108, 29, 46, 14);
						panelPrin.add(lblMes);
						cmbMes.setBounds(142, 26, 104, 20);
						panelPrin.add(cmbMes);
						cmbMes.setBackground(Color.WHITE);
						cmbMes.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								llenar();
								limpiar();
							}
						});
						
						
						cmbMes.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
						
						JLabel lblAo = new JLabel("A\u00F1o:");
						lblAo.setBounds(256, 29, 46, 14);
						panelPrin.add(lblAo);
						
						txtAno = new JTextField();	
						txtAno.setBounds(294, 26, 86, 20);
						panelPrin.add(txtAno);
						txtAno.addKeyListener(new KeyAdapter() {
							@Override
							public void keyTyped(KeyEvent arg0) {
								llenar();
								limpiar();
							}
						});
						txtAno.setColumns(10);
						RestrictedTextField restricted = new RestrictedTextField(txtAno);
		restricted.setLimit(4);
		restricted.setOnlyNums(true);
		
		n.setOnlyNums(true);
		y.setOnlyNums(true);
		
		setTitle("--Reservaciones Viajes Azteca--");
		setFrameIcon(new ImageIcon(PanelReservaciones.class.getResource("/Imagenes/bus.png")));
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1286, 663);

	}
	public void llenar(){
		ObtenerDia n=new ObtenerDia();
		String mes=(String) cmbMes.getSelectedItem();
		String month=n.mes(mes);				
		String day=(String) cmbdia.getSelectedItem();
		String ano=txtAno.getText();
		
		String fecha=day+"/"+month+"/"+ano;
		
		if(!ano.equals("")){
		int anio=Integer.parseInt(ano);
		if(anio>=1900){
			int dia=n.getDiaSemana(fecha);
			String letraDia=n.dia(dia);
			lblDia.setText(letraDia);
			}
		String fechapob=ano+"-"+month+"-"+day;
		ObtenerSalida ob=new ObtenerSalida();
		int tipo=ob.salida(lblSalida, lblDia, fechapob);
		PanelSalidas x=new PanelSalidas(fechapob);
		if(tipo==1){
			x.setVisible(false);
			lblSalida.setText("�Cambiar Salida?");
			lblSalida.setForeground(new Color(139, 0, 0));
			x.setBounds(420, 451,600,150);
			panelPrin.add(x);
			panelPrin.updateUI();
			x.setVisible(true);
			
		}
		if(tipo==2){
			x.setVisible(false);
			panelPrin.updateUI();
			NuevaSalida ns=new NuevaSalida();
			lblFecha.setText("");
			ns.nueva(btnProb, Panel_alta, lblSalida, tipo);
			lblSalida.setVisible(true);
			lblFecha.setVisible(true);
			lblFecha.setText(fecha);
			txtCamion.setVisible(true);
			txtChofer.setVisible(true);
			txtTelefono.setVisible(true);
			txtReservados.setVisible(true);
			btnGuardar.setVisible(true);
			ns.guardarSalida(btnGuardar, txtCamion,txtTelefono,txtChofer,fechapob);
			}
		if(tipo==3){
			x.setVisible(false);
			panelPrin.updateUI();
			if(!lblDia.getText().equals("")){
				lblSalida.setText(lblDia.getText()+" No hay Salida �Agendar Especial?");
				lblSalida.setForeground(new Color(255, 0, 0));
			}else{
				lblSalida.setText("");
			}
			btnProb.setVisible(false);
		}
		}
	}
	public void limpiar(){
		Panel_alta.setVisible(false);
	}
}