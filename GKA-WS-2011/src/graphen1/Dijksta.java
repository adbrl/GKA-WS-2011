package graphen1;
import java.util.*;

//implementation des Dijklstra Algorithmus --> Min. entfernung von einem startpunkt zu allen anderen punkten


public class Dijksta {
	private Gewichtung gewichtung;
	private String vorgaenger;
	private boolean markiert;
	
	private Dijksta(){
		this.gewichtung = Values.unendlich;
		this.markiert = false;
		this.vorgaenger = "";
	}
	
	public static Dijksta valueOf(){
		return new Dijksta();
	}
	
	public boolean markiert(){
		return this.markiert;
	}
	
	public String vorgaenger(){
		return this.vorgaenger;
	}
	
	public Gewichtung gewichtung(){
		return this.gewichtung;
	}
	
	public void setGewichtung(Gewichtung g){
		this.gewichtung = g;
	}
	
	public void setMarkiert(boolean b){
		this.markiert = b;
	}
	
	public void setVorgaenger(String v){
		this.vorgaenger = v;
	}
	
	public String toString(){
		return "DStrct-"+this.vorgaenger+"-"+this.gewichtung+"-"+this.markiert;
	}
	
	public static Map<String,Dijksta> kuerzsteWege(Graph g,String start){
		//Liste aufbauen
		Map<String,Dijksta> result = baueListe(g,start);
		System.out.println("1: " + result);
		
		while(unmarkierte(result)){
			String aktuell = naechsteEcke(result);
			System.out.println("aktuell: " + aktuell);
			markiere(aktuell,result);
			System.out.println("markiere");
			List<Nachbar> nachbarn = unmarkierteNachbarn(aktuell,g,result);
			System.out.println("unmarkierte Nachbarn: " + nachbarn);
			for(Nachbar elem : nachbarn){
				System.out.println(result.get(aktuell).gewichtung());
				System.out.println("min"+min(elem.kantengewichte()));
				Gewichtung abstand = result.get(aktuell).gewichtung().add(min(elem.kantengewichte()));
				System.out.println("abst "+abstand);
				System.out.println(result.get(elem.name()).gewichtung());
				if(abstand.compareTo(result.get(elem.name()).gewichtung) == -1){
					System.out.println("!");
					result.get(elem.name()).setGewichtung(abstand);
					System.out.println("2");
					result.get(elem.name()).setVorgaenger(aktuell);
				}
			}
		}	
		
		return result;
	}
	
	public static Map<String,Dijksta> baueListe(Graph g, String start){
		Map<String,Dijksta> result = new HashMap<String,Dijksta>();
		Set<String> kanten = g.alleEcken();
		for(String elem : kanten){
			if(elem.equals(start)){
				Dijksta d = Dijksta.valueOf();
				d.setGewichtung(Values.gewichtung(0));
				d.setVorgaenger(elem);
				result.put(elem,d);
			}
			else{
				result.put(elem, Dijksta.valueOf());
			}
		}
		return result;
	}
	
	public static boolean unmarkierte(Map<String,Dijksta> m){
		for(Dijksta elem : m.values()){
			if(!(elem.markiert())) return true;
		}
		return false;
	}
	
	public static String naechsteEcke(Map<String,Dijksta> m){
		String result = "";
		Gewichtung abstand = Values.unendlich;
		for(Map.Entry<String, Dijksta> elem : m.entrySet()){
			if((!(elem.getValue().markiert()))&&(elem.getValue().gewichtung().compareTo(abstand) == -1)){
				result = elem.getKey();
				abstand = elem.getValue().gewichtung();
			}
		}
		return result;
	}
	
	public static void markiere(String aktuell, Map<String,Dijksta> m){
		m.get(aktuell).setMarkiert(true);
	}
	
	public static List<Nachbar> unmarkierteNachbarn(String aktuell, Graph g, Map<String,Dijksta> m){
		List<Nachbar> nachbarn = g.nachbarn(aktuell);
		List<Nachbar> result = new ArrayList<Nachbar>();
		for(Nachbar elem : nachbarn){
			if(!(m.get(elem.name()).markiert())){
				result.add(elem);
			}
		}
		return result;
	}
	
	public static Gewichtung min(List<Gewichtung> l){
		Gewichtung result = l.get(0);
		for(Gewichtung elem : l){
			if(elem.compareTo(result) == -1){
				result = elem;
			}
		}
		return result;
	}
	
	public static void main(String args[]){
		String s = "(A,B)3;(A,D)2;(B,A)3;(D,A)3;(B,D)4;(D,B)4;(B,C)1;(C,B)1;(D,C)9;(C,D)9";
		String x = "(A,B)3;(B,A)3;(A,C)2;(C,A)2;(A,D)10;(D,A)10;(B,F)1;(F,B)1;(B,C)2;(C,B)2;(B,E)1;(E,B)1;(C,D)2;(D,C)2;(C,E)3;(E,C)3;(D,E)4;(E,D)4;(E,F)2;(F,E)2";
		Graph g = Values.GraphAsListe(x);
		System.out.println(kuerzsteWege(g,"A"));
	}

}
