package graphen1;

public class GewichtungUnendlich implements Gewichtung {
	private GewichtungUnendlich(){
	}
	public static Gewichtung valueOf(){
		return new GewichtungUnendlich();
	}
	@Override
	public boolean unendlich() {
		return true;
	}
	@Override
	public boolean keine() {
		return false;
	}
	@Override
	public double gewichtung() {
		return 0;
	}
	
	public int compareTo(Gewichtung g){
		if(g instanceof GewichtungKonkret) return 1;
		return 0;
	}
	
	public boolean equals(Object o){
		if(o == this) return true;
		if(!(o instanceof GewichtungUnendlich)) return false;
		return true;
	}
	
	public String toString(){
		return "GewichtungUnendlich";
	}
	
	public Gewichtung add(Gewichtung g){
		return this;
	}
	
	

}
