package graphen1;

public class Values {
	public static final Gewichtung unendlich = gewichtungUnendlich();
	
	
	
	public static Nachbar nachbarUngewichtet(String name){
		return NachbarUngewichtet.valueOf(name);
	}
	
	public static Nachbar nachbarGewichtet(String name){
		return NachbarGewichtet.valueOf(name);
	}
	
	//Funktionen, um die Eingabestrings zu bearbeiten:
	//1. Eingabestrings der Form: (v1,v2);(v2,v1);(v1,v3)... ==> ungewichtete Graphen
	//(<Ecke1>,<Ecke2>);...
	//2. Eingabestrings der Form: (v1,v2)4;(v2,v1)4;(v1,v3)1... ==> gewichtete Graphen
	//(<Ecke1>,<Ecke2>)<Gewichtung>;...
	//zum bearbeiten:
	//1.  eingabestring.split(";"); ==> trennen der einzelnen Anweisungen bei Zeichen ";"
	//    ==> rückgabe array mit den einzelnen Anweisungen ==> (v1,v2)4
	//werden dann mit den folgenden Funktionen bearbeitet:
	
	
	//liefert den Namen des ersten Knotens
	public static String getFirst(String s){
		//int komma = s.indexOf(",");
		return s.substring(1, s.indexOf(","));
	}
	
	//liefert den Namen des zweiten Knotens
	public static String getSecond(String s){
		return s.substring(s.indexOf(',') + 1,s.lastIndexOf(")"));
	}
	
	//liefert die Gewichtung. Falls keine Gewichtung angegeben: -1
	public static Gewichtung getGewichtung(String s){
		if(s.endsWith(")")) return Values.unendlich;
		return Values.gewichtung(Double.valueOf((s.substring(s.lastIndexOf(")") + 1,s.length()))));
	}
	
	public static Graph GraphAsMatrix(String s){
		return AdjMatrix.valueOf(s);
	}
	
	public static Graph GraphAsMatrix(String s, int read, int write){
		return AdjListe.valueOf(s, read, write);
	}
	
	public static Graph GraphAsListe(String s){
		return AdjListe.valueOf(s);
	}
	
	public static Graph GraphAsListe(String s, int read, int write){
		return AdjListe.valueOf(s, read, write);
	}
	
	public static Gewichtung gewichtung(double g){
		return GewichtungKonkret.valueOf(g);
	}
	
	public static Gewichtung gewichtungUnendlich(){
		return GewichtungUnendlich.valueOf();
	}
	
	public static DijkstraStructs dijkstraStruct(Gewichtung g, String v, String n){
		return DijkstraStruct.valueOf(g, v, n); 
	}
	
	
	
	
	
}
