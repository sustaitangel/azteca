package Qwertys;

public class Comunes {
	public String Select(String campos, String tabla){
		String query="SELECT "+campos+" FROM "+tabla;
		return query;
	}
	public String SelectWhere(String campos, String tabla, String comparador, String comparable){
		String query="SELECT "+campos+" FROM "+tabla +" WHERE "+comparador+" = '"+comparable+"'";
		System.out.println(query);
		return query;
	}
	public String insertInto(String tabla, String campos, String Valores){
		String query="INSERT INTO "+tabla+" ("+campos+") "+"VALUES"+" ("+Valores+")";
		System.out.println(query);
		return query;
	}
}
