package Usuarios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;

import Conexiones.Conexion;
import Qwertys.Comunes;

public class ModifacarUsuarioDtb {
	public void modificar(JTable table, int perfil, JPasswordField pass){
		Conexion cx=new Conexion();
		Connection cn=cx.conexion();
		Statement comando;
		Statement comando1;
		int selected;
		selected=table.getSelectedRow(); 
		String nombre;
		nombre=table.getValueAt(selected, 0).toString();
		String ape_paterno;
		ape_paterno=table.getValueAt(selected, 1).toString();
		String ap_materno;
		ap_materno=table.getValueAt(selected, 2).toString();
		String id;
		id=table.getValueAt(selected, 4).toString();
		Comunes q=new Comunes();
		try {
			comando1 = cn.createStatement();
			Comunes n=new Comunes();
			String sql=n.SelectWhere("*", Comunes.tablas[0], "id_usuario", id);
			comando=(Statement) cn.createStatement();
			ResultSet rs= ((java.sql.Statement) comando).executeQuery(sql);
			if(rs.next()){
				int x=pass.getText().length();
				if(x==0){
					String sql1=q.update(Comunes.tablas[0], "ape_paterno", ape_paterno, "id_usuario", id);
					String sql2=q.update(Comunes.tablas[0], "nombre", nombre, "id_usuario", id);
					String sql3=q.update(Comunes.tablas[0], "ap_materno", ap_materno, "id_usuario", id);
					String sql4=q.update(Comunes.tablas[0], "perfil", String.valueOf(perfil), "id_usuario", id);
					comando1.execute(sql1);
					comando1.execute(sql2);
					comando1.execute(sql3);
					comando1.execute(sql4);
					JOptionPane.showMessageDialog(null, "Se modific� con �xito");
					pass.setText("");
					
				}else{
					EncriptacionPrincipal pasen=new EncriptacionPrincipal();
					String pass1=pasen.encriptar(pass.getText());
					String sql1=q.update(Comunes.tablas[0], "ape_paterno", ape_paterno, "id_usuario", id);
					String sql2=q.update(Comunes.tablas[0], "nombre", nombre, "id_usuario", id);
					String sql3=q.update(Comunes.tablas[0], "ap_materno", ap_materno, "id_usuario", id);
					String sql4=q.update(Comunes.tablas[0], "perfil", String.valueOf(perfil), "id_usuario", id);
					String sql5=q.update(Comunes.tablas[0], "password", pass1, "id_usuario", id);
					comando1.execute(sql1);
					comando1.execute(sql2);
					comando1.execute(sql3);
					comando1.execute(sql4);
					comando1.execute(sql5);
					JOptionPane.showMessageDialog(null, "Se modific� con �xito");
					pass.setText("");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void eliminar(JTable table){
		Conexion cx=new Conexion();
		Connection cn=cx.conexion();
		Statement comando;
		
		int selected;
		selected=table.getSelectedRow(); 
		String id;
		id=table.getValueAt(selected, 4).toString();
		Comunes n=new Comunes();
		String sql=n.SelectWhere("*", Comunes.tablas[0], "id_usuario", id);
		System.out.println(selected);
		
		try {
			comando=(Statement) cn.createStatement();
			ResultSet rs= ((java.sql.Statement) comando).executeQuery(sql);
			Statement comando1=cn.createStatement();
			
			if(rs.next()){
				int r=JOptionPane.showConfirmDialog(null,"�Desea eliminar a "+rs.getString("usuario")+"?",
						"Confirmar",JOptionPane.YES_NO_OPTION);
				if(r==JOptionPane.YES_OPTION){
					String sql1=n.eliminar(Comunes.tablas[0], "id_usuario", id);
					comando1.execute(sql1);
					JOptionPane.showMessageDialog(null, "Se elimin� con �xito");
				}else{
					JOptionPane.showMessageDialog(null, "No se elimin� el usuario");
				}
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
