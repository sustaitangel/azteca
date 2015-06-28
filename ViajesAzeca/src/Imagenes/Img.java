package Imagenes;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Img {
	public Icon fondo(){
		Icon fondo= new ImageIcon(getClass().getResource("LogoAzteca.jpg"));
		return fondo;
	}
	public Icon login(){
		Icon azteca= new ImageIcon(getClass().getResource("aztec1.png"));
		return azteca;
	}
	public Icon user(){
		Icon usuario= new ImageIcon(getClass().getResource("user.png"));
		return usuario;
	}
	public Icon seat1(){
		Icon asiento= new ImageIcon(getClass().getResource("as01.png"));
		return asiento;
	}
	public Icon seat2(){
		Icon asiento= new ImageIcon(getClass().getResource("as02.png"));
		return asiento;
	}
}
