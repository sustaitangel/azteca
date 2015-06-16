package Conexiones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Conexion {
	   Connection conect = null;
	   public Connection conexion(){
	   String Cadena = null;
	   String servidor="";
	   String User="";
	   String pass="";
	   int bandera=0;
	   try{
		   BufferedReader bf=new BufferedReader(new FileReader("C:\\azteca\\ConfigDtb.config"));
		   String lector;
		   File file= new File("C:\\azteca\\ConfigDtb.config");
			if(file.exists()){
		   while((lector=bf.readLine())!=null){
			   if(bandera==0){
				   servidor=lector;
			   }
			   if(bandera==1){
				   User=lector;
			   }
			   if(bandera==2){
				   pass=lector;
			   }
			   bandera=bandera+1;
		   }
		   String BasedeDatos="todoparallevar";
		   Cadena="jdbc:mysql://"+servidor+"/"+BasedeDatos;
			}
		   
	   }catch(Exception e){
		   
	   }

	    {
	      try {  
	           //Cargamos el Driver MySQL
	           Class.forName("org.gjt.mm.mysql.Driver");
	           conect = DriverManager.getConnection(Cadena,User,pass);
	           System.out.println("conectado");
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null,"Error al conectarse en la base de datos\n            Revise la configuracion");
	        }
	        return conect;
	    }
	   }

}