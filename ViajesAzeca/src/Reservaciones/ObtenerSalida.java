package Reservaciones;

import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Conexiones.Conexion;
import Qwertys.Comunes;

public class ObtenerSalida {
	public int existe(String fecha){
		int esta=0;
		Conexion cx=new Conexion();
		Connection cn=cx.conexion();
		Statement comando;
		Comunes n= new Comunes();
		String sql=n.SelectWhere("*", Comunes.tablas[2], "fecha_salida", fecha);
		try {
			comando=(Statement) cn.createStatement();
			ResultSet rs= ((java.sql.Statement) comando).executeQuery(sql);
			if(rs.next()){
				Date fechadt=rs.getDate("fecha_salida");
				esta=1;
			}else{
				esta=2;
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return esta;
	}
	public int salida(JLabel lblDia, String fecha){
		int esta=existe(fecha);
		int tipo=0;
		if(esta==1){
			tipo=1;
		}
		if(esta==2){
			if((lblDia.getText().equals("Miércoles")) || (lblDia.getText().equals("Jueves")) || (lblDia.getText().equals("Viernes"))){
				tipo=2;
			}else{
				tipo=3;
			}
			
		}
		return tipo;
	}
}