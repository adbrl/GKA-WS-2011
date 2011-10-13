package graphen1;

public class DijkstraStruct implements DijkstraStructs {
	private Gewichtung gewichtung;
	private String vorgaenger;
	private boolean fertig;
	private String name;
	
	private DijkstraStruct(Gewichtung g,String v,String n){
		this.gewichtung = g;
		this.vorgaenger = v;
		this.fertig = false;
		this.name = n;
	}
	
	public static DijkstraStruct valueOf(Gewichtung g, String v, String n){
		return new DijkstraStruct(g,v,n);
	}
	
	public Gewichtung gewichtung(){
		return this.gewichtung;
	}
	
	public String vorgaenger(){
		return this.vorgaenger;
	}
	
	public boolean fertig(){
		return this.fertig;
	}
	
	public String name(){
		return this.name;
	}
	
	public void mark(){
		this.fertig = true;
	}
	

}
