package graphen1;
import java.util.*;

public class AdjListe implements Graph {
	
	private Map<String,List<Nachbar>> liste = new HashMap<String,List<Nachbar>>();
	private String einleseString;
	private int read, write;
	
	private AdjListe(String s, int read, int write){
		
		this.read = read;
		this.write = write;
		
		String[] kanten = s.split(";");
		for(String elem:kanten){
			String e1,e2;
			Gewichtung gewichtung;
			
			e1 = Values.getFirst(elem);
			e2 = Values.getSecond(elem);
			gewichtung = Values.getGewichtung(elem);
			Nachbar nachbar;// hinzugefuegt, um Redundanz zu vermeiden
			
			//-------------------Start eigentliche Aenderung--------------------------**
			
			//erschaffe einen neuen Nahchbarn 
			if(gewichtung.unendlich()){
				nachbar = Values.nachbarUngewichtet(e2);
				nachbar.add(Values.unendlich);
			}
			else{
				nachbar = Values.nachbarGewichtet(e2);
				nachbar.add(gewichtung);
			}
			
			//Fuege Paarung in AdjListe ein
			if(liste.containsKey(e1)){
				if(liste.get(e1).contains(nachbar)){
					liste.get(e1).get(liste.get(e1).indexOf(nachbar)).add(gewichtung);
				}
				else{
					liste.get(e1).add(nachbar);
				}
			}else{
				List<Nachbar> l = new ArrayList<Nachbar>();
				l.add(nachbar);
				liste.put(e1, l);
			}
			
//---------------Ende Aenderung-----------------------------------------------			
			
			
			
			
//-------------------------------alter Code, den wir zum erschaffen hatten------------------------			
//			
//			if(liste.containsKey(e1)){
//				Nachbar nachbar = Values.nachbarGewichtet(e2);
//				nachbar.add(gewichtung);
//				liste.get(e1).add(nachbar);
//			}
//			else{
//				Nachbar nachbar = Values.nachbarGewichtet(e2);
//				nachbar.add(gewichtung);
//				List<Nachbar> l = new ArrayList<Nachbar>();
//				l.add(nachbar);
//				liste.put(e1,l);
//			}
			
		}
		
	}
	
	public static Graph valueOf(String s){
		return new AdjListe(s,0,0);
	}
	
	public static Graph valueOf(String s,int read, int write){
		return new AdjListe(s,read,write);
	}

	@Override
	public Graph toAdjMatrix() {
		write++;
		return Values.GraphAsMatrix(einleseString,read, write);
	}

	@Override
	public Graph toAdjList() {
		return this;
	}
	
	public String einleseString(){
		read++;
		return this.einleseString;
	}
	
	public int read(){
		return this.read;
	}
	
	public int write(){
		return this.write;
	}
	
	public List<Nachbar> nachbarn(String ecke){
		return liste.get(ecke);
	}
	
	@Override
	public String toString(){
		StringBuffer result = new StringBuffer();
		Set keys = new HashSet<String>();
		keys = liste.keySet();
		for(Object elem:keys){
			List<Nachbar> value;
			result.append(elem);
			result.append(" --> ");
			value = liste.get(elem);
			for(Nachbar e : value){
				result.append(e.toString());
			}
			result.append("\n");
			
		}
		
		return result.toString();
	}
	
	public int anzahlEcken(){
		read++;
		return liste.size();
	}
	
	public Set<String> alleEcken(){
		read++;
		return liste.keySet();
	}
	
		
	public static void main(String[] args){
		Graph g1 = Values.GraphAsListe(" (v1,v2);(v2,v1)");
		Graph g2 = Values.GraphAsListe("(v1,v2)5;(v1,v3)2;(v2,v3)1;(v2,v1)1;(v3,v1)1;(v3,v2)2;(v1,v3)3");
		System.out.println(g1);
		System.out.println("zweiter");
		System.out.println(g2);
		Graph g3 = Values.GraphAsListe("(v1,v2)3;(v1,v2)5");
		System.out.println(g3);
		
			}

	@Override
	public List<String> bfs() {
		List<String> result = new ArrayList<String>();
		Set<String> alleEcken;
		int i = 0;
		
		alleEcken = this.alleEcken();
		result.add((String)alleEcken.toArray()[0]);  //irgendeinen Knoten in result
		
		while(result.size() != alleEcken.size()){
			String aktuell = result.get(i);
			List<Nachbar> aktuelleNachbarn = liste.get(aktuell);
			for(Nachbar elem : aktuelleNachbarn){
				if(!(result.contains(elem))){
					result.add(elem.name());
				}
			}
			i++;
		}
		System.out.println("read: "+ read+ " write: " + write);
		return result;
		
	}
	
	
		
		
	
}
