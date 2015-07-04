package Principal;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;

public class RelojFecha {
	static Calendar calendar = new GregorianCalendar();
	public static int dia = calendar.get(Calendar.DAY_OF_MONTH);
	public static int mes = calendar.get(Calendar.MONTH)+1;
	public static int ano = calendar.get(Calendar.YEAR);
	
	Calendar calendario = new GregorianCalendar();
	int hora, minutos, segundos;
	public void reloj(final JLabel reloj) {  
		segundos = calendario.get(Calendar.SECOND); 
		javax.swing.Timer timer = new javax.swing.Timer(1000, new java.awt.event.ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent ae) { 
				java.util.Date actual = new java.util.Date(); 
				calendario.setTime(actual); 
				hora = calendario.get(Calendar.HOUR_OF_DAY); 
				minutos = calendario.get(Calendar.MINUTE); 
				segundos = calendario.get(Calendar.SECOND); 
				String hour = String.format("%02d : %02d : %02d", hora, minutos, segundos); 
				reloj.setText("<html><center>" + hour); 
			} 
		}); 
		timer.start(); 
	} 
	public String fecha(final JLabel fecha){
		
		String nombreMes;
		if (mes == 1) {
			nombreMes = "ENERO";
		} else if (mes == 2) {
			nombreMes = "FEBRERO";
		} else if (mes == 3) {
			nombreMes = "MARZO";
		} else if (mes == 4) {
			nombreMes = "ABRIL";
		} else if (mes == 5) {
			nombreMes = "MAYO";
		} else if (mes == 6) {
			nombreMes = "JUNIO";
		} else if (mes == 7) {
			nombreMes = "JULIO";
		} else if (mes == 8) {
			nombreMes = "AGOSTO";
		} else if (mes == 9) {
			nombreMes = "SEPTIEMBRE";
		} else if (mes == 10) {
			nombreMes = "OCTUBRE";
		} else if (mes == 11) {
			nombreMes = "NOVIEMBRE";
		} else {
			nombreMes = "DICIEMBRE";
		}
		String cadena = dia + " / " + nombreMes + " / " + ano;
		fecha.setText("<html><center>" + cadena); 
		return nombreMes;
	}
}
