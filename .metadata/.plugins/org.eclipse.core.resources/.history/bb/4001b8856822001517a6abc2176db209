package Qwertys;

public class Comunes {
	public static String[] tablas={"usuario","cliente"," salida"}; 
	public String Select(String campos, String tabla){
		String query="SELECT "+campos+" FROM "+tabla;
		return query;
	}
	public String SelectWhere(String campos, String tabla, String comparador, String comparable){
		String query="SELECT "+campos+" FROM "+tabla +" WHERE "+comparador+" = '"+comparable+"'";
		//System.out.println(query);
		return query;
	}
	
	public String SelectLike(String campos, String tabla, String comparador, String comparable){
		String query="SELECT "+campos+" FROM "+ tabla +" WHERE "+comparador+" LIKE '"+comparable+"%'";
		//System.out.println("resultado "+query);
		return query;
	} 
	
	public String insertInto(String tabla, String campos, String Valores){
		String query="INSERT INTO "+tabla+" ("+campos+") "+"VALUES"+" ("+Valores+")";
		//System.out.println(query);
		return query;
	}
	
	public String BusquedaUsuario1(String comparable, String p1, String p2){
		String[] campos={"Nombre", "ape_paterno", "ap_materno","usuario","id_usuario"};
		String query="SELECT "+campos[0]+","+campos[1]+","+campos[2]+","+campos[3]+","+campos[4]+" FROM "+tablas[0]+" WHERE "+
		campos[3]+" LIKE "+"'"+comparable+"' OR "+campos[0]+" LIKE "+"'"+comparable+"'"+
		" OR "+campos[1]+" LIKE "+"'"+comparable+"'"+" OR "+campos[2]+" LIKE "+"'"+comparable+"'"+
		" OR "+campos[0]+" LIKE "+"'"+p1+"'"+ " AND "+campos[1]+" LIKE "+"'"+p2+"'"+
		" OR "+campos[0]+" LIKE "+"'"+p2+"'"+ " AND "+campos[1]+" LIKE "+"'"+p1+"'";
		//System.out.println(query);
		return query;
	}
	public String BusquedaUsuario2(String comparable){
		String[] campos={"Nombre", "ape_paterno", "ap_materno","usuario","id_usuario"};
		String query="SELECT "+campos[0]+","+campos[1]+","+campos[2]+","+campos[3]+","+campos[4]+" FROM "+tablas[0]+" WHERE "+campos[3]+
		" LIKE "+"'"+comparable+"%'"+" OR "
		+campos[0]+" LIKE "+"'"+comparable+"'"+" OR "+campos[1]+" LIKE "+"'"+comparable+"'"+" OR "+campos[2]+
		" LIKE "+"'"+comparable+"%'";
		//System.out.println(query);
		return query;
	}
	public String update (String tabla, String campos, String datos, String comparador, String comparable){
		String query="UPDATE "+tabla+" SET "+campos+"="+"'"+datos+"'"+" WHERE "+comparador+" = "+"'"+comparable+"'";
		return query;
	}
	public String eliminar(String tabla, String comparador, String comparable){
		String query="DELETE FROM "+tabla+" WHERE "+comparador+" = "+"'"+comparable+"'";
		return query;
	}
}
