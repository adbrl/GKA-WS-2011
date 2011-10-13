package graphen1;
import java.util.*;

import graphen1.Values;


public class AdjMatrix implements Graph {
	
	private Map<String,Integer> ecken = new HashMap<String,Integer>() ;
	private int [][] matrix;
	private String einleseString;
	private int read;
	private int write;
	
	private AdjMatrix(String beschreibung, int read, int write){
		String[] kanten;
		kanten = beschreibung.split(";");
		this.einleseString = beschreibung;
		this.read = read;
		this.write = write;
		
		
		//Anlegen der Map <Name Ecke> -> <ArrayIndex> 
		for(String elem:kanten){
			String e1 = Values.getFirst(elem);
			String e2 = Values.getSecond(elem);
			
			// Map aufbauen, um Namen Indexe der Arrays zu geben
			
			if(!(ecken.containsKey(e1))){
				ecken.put(e1, ecken.size());				
			}
			if(!(ecken.containsKey(e2))){
				ecken.put(e2, ecken.size());
			}
		}
		
		//Anlegen der Matrix
		matrix = new int[ecken.size()][ecken.size()];
		
		//fuellen der Matrix mit Nullen
		
		for(int[] elem: matrix){
			for(int e = 0;e < elem.length;e++){
				elem[e] = 0;
			}
		}
		
		//fuellen der Matrix mit Kanten
		for(String elem:kanten){
			String e1 = Values.getFirst(elem);
			String e2 = Values.getSecond(elem);
			
			matrix[ecken.get(e1)][ecken.get(e2)] += 1;
		}
		
		
	}
	
	public static Graph valueOf(String s){
		return new AdjMatrix(s,0,0);
	}
	
	public int read(){
		return this.read;
	}
	
	public int write(){
		return this.write;
	}
	
	public static Graph valueOf(String s, int read, int write){
		return new AdjMatrix(s, read, write);
	}

	public String einleseString(){
		read++;
		return this.einleseString;
	}
	
	
	public Set<String> alleEcken(){
		read++;
		return ecken.keySet();
	}
	
	public int anzahlEcken(){
		read++;
		return ecken.size();
	}
	
	@Override
	public Graph toAdjMatrix() {
		return this;
	}
	
	@Override 
	public String toString(){
		StringBuffer s = new StringBuffer();
		for(int[] elem : matrix){
			for(int e: elem){
				s.append(String.valueOf(e));
			}
			s.append("\n");
		}
		return s.toString();
	}
	
	public static void main(String[] args){
//		Graph g1 = Values.GraphAsMatrix("(v1,v2);(v2,v1)");
//		System.out.println(g1.toString());
		Graph g2 = Values.GraphAsMatrix("(v1,v2);(v1,v3);(v2,v3);(v2,v1);(v3,v1);(v3,v2);(v1,v3)");
//		System.out.println(g2.toString());
//		System.out.println("EinleseString: " + g2.einleseString());
		System.out.println("bfs: "+ g2.bfs());
	}

	@Override
	public Graph toAdjList() {
		write++;
		return Values.GraphAsListe(einleseString, read, write);
	}

	@Override
	public List<String> bfs() {
		return Values.GraphAsListe(einleseString, read, write).bfs();
	}

	@Override
	public List<Nachbar> nachbarn(String s) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
