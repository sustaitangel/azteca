package Vendedores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;

import Conexiones.Conexion;
import Qwertys.Comunes;

public class ModificarVendedorDtb {
	public void modificar(JTable table){
		Conexion cx=new Conexion();
		Connection cn=cx.conexion();
		Statement comando;		
		int selected=table.getSelectedRow(); 		
		String nombre_vendedor=table.getValueAt(selected, 1).toString();
		String apep_vendedor=table.getValueAt(selected, 2).toString();
		String apem_vendedor=table.getValueAt(selected, 3).toString();
		String telefono_vendedor=table.getValueAt(selected, 4).toString();
		String ubicacion_vendedor=table.getValueAt(selected, 5).toString();
		String comision=table.getValueAt(selected, 6).toString();
		String folio_del=table.getValueAt(selected,7).toString();
		String folio_al=table.getValueAt(selected,8).toString();
		String id=table.getValueAt(selected, 0).toString();				
		try {
			
			comando = cn.createStatement();
			Comunes q=new Comunes();
			String sql=q.SelectWhere("*", "vendedor", "id_vendedor", id);
			comando=(Statement) cn.createStatement();
			ResultSet rs= comando.executeQuery(sql);
			if(rs.next()){
				    String sql0=q.update("vendedor", "nombre_vendedor", nombre_vendedor, "id_vendedor", id);
					String sql1=q.update("vendedor", "apep_vendedor", apep_vendedor, "id_vendedor", id);
					String sql2=q.update("vendedor", "apem_vendedor", apem_vendedor, "id_vendedor", id);
					String sql3=q.update("vendedor", "telefono_vendedor", telefono_vendedor, "id_vendedor", id);
					String sql4=q.update("vendedor", "ubicacion_vendedor", ubicacion_vendedor, "id_vendedor", id);
					String sql5=q.update("vendedor", "comision", comision, "id_vendedor", id);
					String sql6=q.update("vendedor", "folio_del", folio_del, "id_vendedor", id);
					String sql7=q.update("vendedor", "folio_al", folio_al,"id_vendedor", id);
					comando.execute(sql0);
					comando.execute(sql1);
					comando.execute(sql2);
					comando.execute(sql3);
					comando.execute(sql4);
					comando.execute(sql5);
					comando.execute(sql6);
					comando.execute(sql7);
					JOptionPane.showMessageDialog(null, "Se modificó con éxito");											
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
		id=table.getValueAt(selected, 0).toString();
		Comunes n=new Comunes();
		String sql=n.SelectWhere("*", "vendedor", "id_vendedor", id);
		
		try {
			comando=(Statement) cn.createStatement();
			ResultSet rs=  comando.executeQuery(sql);						
			if(rs.next()){
				int r=JOptionPane.showConfirmDialog(null,"¿Desea eliminar a "+rs.getString("nombre_vendedor")+"?",
						"Confirmar",JOptionPane.YES_NO_OPTION);
				if(r==JOptionPane.YES_OPTION){
					Statement comando1=cn.createStatement();
					String sql1=n.eliminar("vendedor", "id_vendedor", id);
					comando1.execute(sql1);
					JOptionPane.showMessageDialog(null, "Se eliminó con éxito");
				}else{
					JOptionPane.showMessageDialog(null, "No se eliminó el usuario");
				}
			}				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
