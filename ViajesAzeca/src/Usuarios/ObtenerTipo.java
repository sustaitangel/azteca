package Usuarios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JRadioButton;
import javax.swing.JTable;

import Conexiones.Conexion;
import Qwertys.Comunes;

public class ObtenerTipo {
	public void tipo(JRadioButton rdbtnAdministrador, JTable table, JRadioButton rdbtnUsuario){
		Conexion cx=new Conexion();
		Connection cn=cx.conexion();
		Statement comando;
		int selected;
		selected=table.getSelectedRow(); 
		String cantidad;
		cantidad=table.getValueAt(selected, 4).toString();
		try {
			Comunes q=new Comunes();
			String sql=q.SelectWhere("perfil", Comunes.tablas[0], "id_usuario", cantidad);
			comando=(Statement) cn.createStatement();
			ResultSet rs= ((java.sql.Statement) comando).executeQuery(sql);
			if(rs.next()){
				int perfil=rs.getInt("perfil");
				if (perfil==1){
					rdbtnAdministrador.setSelected(true);
				}else{
					rdbtnUsuario.setSelected(true);
				}
			}else{
				System.out.println("el usuari no existe");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
