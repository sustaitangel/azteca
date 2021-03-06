package Usuarios;

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

public class AltaDtb {
	public void alta(JTextField txtNombre,JTextField txtAp_pat, 
			JTextField txtAp_mat, JTextField txtUser, JPasswordField txtPass, JPasswordField txtPass1,int tipo){
		Conexion cx=new Conexion();
		Connection cn=cx.conexion();
		Statement comando;
		Comunes q=new Comunes();
		if(txtNombre.getText().length()==0){
			JOptionPane.showMessageDialog(txtPass, "Use Un Nombre de Usuario");
		}else{
			try{
				comando=(Statement) cn.createStatement();
				String existente= q.SelectWhere("*", "usuario", "usuario", txtUser.getText());
				ResultSet rs= ((java.sql.Statement) comando).executeQuery(existente);
				if(rs.next()){
					JOptionPane.showMessageDialog(txtNombre, "En nombre de usuario ya existe");
					txtUser.setText("");
				}else{
					String pass= txtPass.getText();
					if(txtPass.getText().equals(txtPass1.getText())){
						EncriptacionPrincipal pasen=new EncriptacionPrincipal();
						String PasEncriptado=pasen.encriptar(pass);
						String campos="nombre, ape_paterno, ap_materno, perfil,usuario, password";
						String Valores="'"+txtNombre.getText()+"','"+txtAp_pat.getText()+"','"+txtAp_mat.getText()+"',"
								+ "'"+tipo+"','"+txtUser.getText()+"','"+PasEncriptado+"'";
						String sqlGuardar=q.insertInto("usuario", campos, Valores);
						comando.execute(sqlGuardar);
						Icon echo;
						echo=new ImageIcon("src/Imagenes/done.png");
						JOptionPane.showMessageDialog(txtUser,"Usuario agregado exitosamente","Guardado",JOptionPane.DEFAULT_OPTION,echo);
						Limpiar(txtNombre, txtPass, txtPass1,txtAp_pat, txtAp_mat, txtUser);
					}else{
						JOptionPane.showMessageDialog(txtPass, "Las contraseņas no coinciden");
					}
					
				}
			}catch(SQLException e){
				JOptionPane.showMessageDialog(txtPass, "Error "+e);
			}
			
		}
	}

	public void Limpiar(JTextField txtNombre, JPasswordField txtPass,
			JPasswordField txtPass1, JTextField txtAp_pat,
			JTextField txtAp_mat, JTextField txtUser) {
		txtNombre.setText("");
		txtPass.setText("");
		txtPass1.setText("");
		txtAp_pat.setText("");
		txtAp_mat.setText("");
		txtUser.setText("");
	}
}
