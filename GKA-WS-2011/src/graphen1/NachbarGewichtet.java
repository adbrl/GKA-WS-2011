package graphen1;
import java.util.*;

public class NachbarGewichtet extends NachbarImpl implements Nachbar {
	private List<Gewichtung> kantengewichte;
	
	private NachbarGewichtet(String name){
		this.kantengewichte = new ArrayList<Gewichtung>();
		this.kanten = 0;
		this.name = name;
	}

	
	public static Nachbar valueOf(String name){
		return new NachbarGewichtet(name);
	}
	
	@Override
	public List<Gewichtung> kantengewichte() {
		return this.kantengewichte;
	}
	
	@Override
	public void add(Gewichtung gewicht){
		super.add(gewicht);
		this.kantengewichte.add(gewicht);
	}
	
	@Override
	public String toString(){
		return "Nachbar Name: "+name+" Kanten: "+String.valueOf(kanten)+ " Gewichte: "+kantengewichte.toString()+ "\n"; 
	}
	
	

}
