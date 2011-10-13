package graphen1;



public class GewichtungKonkret implements Gewichtung {
	private double gewichtung;
	private GewichtungKonkret(double gewichtung){
		this.gewichtung = gewichtung;
	}
	
	public static Gewichtung valueOf(double gewichtung){
		return new GewichtungKonkret(gewichtung);
	}
	
	public boolean keine(){
		return false;
	}
	
	public boolean unendlich(){
		return false;
	}
	
	public double gewichtung(){
		return gewichtung;
	}
	
	public int compareTo(Gewichtung g){
		if(g instanceof GewichtungUnendlich) return -1;
		return Double.compare(gewichtung, g.gewichtung());
	}
	
	public boolean equals(Object o){
		if(o == this) return true;
		if(!(o instanceof GewichtungKonkret)) return false;
		return (this.compareTo((GewichtungKonkret)o) == 0);
	}
	
	public String toString(){
		return "Gewichtung: " + String.valueOf(gewichtung);
	}
	
	public Gewichtung add(Gewichtung g){
		return Values.gewichtung(gewichtung + g.gewichtung()); 
	}
}
