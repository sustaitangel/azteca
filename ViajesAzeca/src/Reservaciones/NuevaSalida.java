package Reservaciones;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField; 

public class NuevaSalida {
	public void nueva(JButton prob, JPanel panel_alta, JLabel lblSalida, int tipo, PanelCamion n){
			prob.setVisible(true);
			prob.setText("Agendar");
			lblSalida.setText("�Agendar Salida?");
			lblSalida.setForeground(new Color(139, 0, 0));
			prob.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					panel_alta.setVisible(true);
					n.setVisible(true);
				}
			});
	}

}
