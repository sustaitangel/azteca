package Reservaciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ObtenerDia {
	public int getDiaSemana(String fecha) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaActual = null;
		int diaSemana = 0;
		String[] dias = fecha.split("/");
		String month=dias[1];
		int diax=Integer.parseInt(dias[0]);
		try {
			fechaActual = df.parse(fecha);
		} catch (ParseException e) {
			System.err.println("No se ha podido parsear la fecha.");
			diaSemana=0;
			e.printStackTrace();
		}
			GregorianCalendar fechaCalendario = new GregorianCalendar();
			fechaCalendario.setTime(fechaActual);
			if(fechaActual.getYear()%4==0 && fechaActual.getYear()%100!=100 ||fechaActual.getYear()%400==0){
				
				if(month.equals("02") && diax>29){
					diaSemana=0;
				}else{
					if(month.equals("04") && diax>=31 || month.equals("06") && diax>=31 || month.equals("09") && diax>=31 || month.equals("11") && diax>=31 ){
						diaSemana=0;
					}else
						if(month.equals("04") && diax>=31 || month.equals("06") && diax>=31 || month.equals("09") && diax>=31 || month.equals("11") && diax>=31 ){
							diaSemana=0;
						}else{
					 diaSemana = fechaCalendario.get(Calendar.DAY_OF_WEEK);
						}
				}
				
			}else{
				if(month.equals("02") && diax>28){
					diaSemana=0;
				}else{
					
					if((month.equals("04") && diax>=31) ||(month.equals("06") && diax>=31) ||(month.equals("09") && diax>=31) || (month.equals("11") && diax>=31) ){
						diaSemana=0;
					}else{
					 diaSemana = fechaCalendario.get(Calendar.DAY_OF_WEEK);
					}
				}
			}
			
			return diaSemana;
		}
	public String mes(String month){
		String mes=null;
		if(month.equals("Enero"))mes="01";
		if(month.equals("Febrero"))mes="02";
		if(month.equals("Marzo"))mes="03";
		if(month.equals("Abril"))mes="04";
		if(month.equals("Mayo"))mes="05";
		if(month.equals("Junio"))mes="06";
		if(month.equals("Julio"))mes="07";
		if(month.equals("Agosto"))mes="08";
		if(month.equals("Septiembre"))mes="09";
		if(month.equals("Octubre"))mes="10";
		if(month.equals("Noviembre"))mes="11";
		if(month.equals("Diciembre"))mes="12";
		return mes;
	}
	public String dia(int n){
		String dia=null;
		if(n==0){
			dia="No se Encontr� D�a Revise la fecha";
		}
		if(n==1){
			dia="Domingo";
		}
		if(n==2){
			dia="Lunes";
		}
		if(n==3){
			dia="Martes";
		}
		if(n==4){
			dia="Mi�rcoles";
		}
		if(n==5){
			dia="Jueves";
		}
		if(n==6){
			dia="Viernes";
		}
		if(n==7){
			dia="S�bado";
		}
		return dia;
	}
}
