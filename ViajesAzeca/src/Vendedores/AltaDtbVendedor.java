package Vendedores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Conexiones.Conexion;
import Qwertys.Comunes;

public class AltaDtbVendedor {
	public void alta(JTextField txtNombre,JTextField txtAp_pat, 
		JTextField txtAp_mat, JTextField txtTel, JTextField txtUbi, JTextField txtCom,JTextField txtDel, JTextField txtAl){
		Conexion cx=new Conexion();
		Connection cn=cx.conexion();
		Statement comando;
		Comunes q=new Comunes();
		if(ValidarCampos(txtNombre, txtAp_pat, txtAp_mat, txtTel, txtUbi, txtCom,txtDel,txtAl)==true){			
			try{
				comando=(Statement) cn.createStatement();													
				String campos="nombre_vendedor, apep_vendedor, apem_vendedor, telefono_vendedor,ubicacion_vendedor, comision, folio_del, folio_al";
				String Valores="'"+txtNombre.getText()+"','"+txtAp_pat.getText()+"','"+txtAp_mat.getText()+"',"
						+ "'"+txtTel.getText()+"','"+txtUbi.getText()+"','"+txtCom.getText()+"','"+txtDel.getText()+"','"+txtAl.getText()+"'";
				String sqlGuardar=q.insertInto("vendedor", campos, Valores);
				comando.execute(sqlGuardar);
				Icon echo;
				echo=new ImageIcon("src/Imagenes/done.png");
				JOptionPane.showMessageDialog(txtNombre,"Vendedor agregado exitosamente","Guardado",JOptionPane.DEFAULT_OPTION,echo);
				Limpiar(txtNombre,txtAp_pat, txtAp_mat, txtTel, txtUbi, txtCom, txtDel, txtAl);
		
			}catch(SQLException e){
				JOptionPane.showMessageDialog(txtNombre, "Error "+e);
			}		
		}
	}

	public void Limpiar(JTextField txtNombre,JTextField txtAp_pat, 
			JTextField txtAp_mat, JTextField txtTel, JTextField txtUbi, JTextField txtCom,JTextField txtDel, JTextField txtAl) {
		txtNombre.setText("");
		txtAp_pat.setText("");
		txtAp_mat.setText("");
		txtTel.setText("");
		txtUbi.setText("");
		txtCom.setText("");
		txtDel.setText("");
		txtAl.setText("");
	}
	
	public boolean ValidarCampos(JTextField txtNombre,JTextField txtAp_pat, 
			JTextField txtAp_mat, JTextField txtTel, JTextField txtUbi, JTextField txtCom,JTextField txtDel, JTextField txtAl){
		boolean r=true;
		if(txtNombre.getText().length()==0){
			JOptionPane.showMessageDialog(txtNombre, "Use Un Nombre de Vendedor");
			return false;
		}
		if(Letras(txtNombre.getText())==false){
			JOptionPane.showMessageDialog(txtNombre, "El Nombre del vendedor debe contener solo letras");
			return false;
		}
		if(Letras(txtAp_pat.getText())==false){
			JOptionPane.showMessageDialog(txtAp_pat, "El Apellido paterno del vendedor debe contener solo letras");
			return false;
		}
		if(Letras(txtAp_mat.getText())==false){
			JOptionPane.showMessageDialog(txtAp_mat, "El Apellido materno del vendedor debe contener solo letras");
			return false;
		}
		if(Letras(txtUbi.getText())==false){
			JOptionPane.showMessageDialog(txtUbi, "La ubicación del vendedor debe contener solo letras");
			return false;
		}
		if(Numeros(txtTel.getText())==false){
			JOptionPane.showMessageDialog(txtTel, "El Telefono debe contener solo números");
			return false;
		}
		if(Numeros(txtCom.getText())==false){
			JOptionPane.showMessageDialog(txtCom, "La comisión debe contener solo números");
			return false;
		}
		if(Numeros(txtDel.getText())==false || Numeros(txtAl.getText())==false){
			JOptionPane.showMessageDialog(txtDel, "El Folio del .. al  solo acepta números");
			return false;
		}				
		return r;		
	}
	public static boolean Letras(String str) { 
		boolean respuesta = false; 
		if ((str).matches("([a-z]|[A-Z]|\\s)+")) { 
			respuesta = true; 
		} 
		return respuesta; 
	}
	
	public static boolean Numeros(String str){ 
		boolean respuesta = false; 
		if ((str).matches("([0-9]|\\-)+")) { 
		respuesta = true; 
		} 
		return respuesta; 
		} 
}
