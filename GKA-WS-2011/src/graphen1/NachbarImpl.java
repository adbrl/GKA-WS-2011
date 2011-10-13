package graphen1;

import java.util.List;

public class NachbarImpl implements Nachbar  {
	protected String name;
	protected int kanten;
	
	@Override
	public String name() {
		return this.name;
	}
	
	//------------------hinzugefuegt----------------------------
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Nachbar)) return false;
		if(!((Nachbar)o).name().equals(this.name())) return false;
		return true;
	}
	
	//-------------------------------------------------

	@Override
	public List<Gewichtung> kantengewichte() {
		return null;
	}

	@Override
	public int kanten() {
		return this.kanten;
	}

	@Override
	public void add(Gewichtung gewicht) {
		this.kanten++;
	}

	public String toString() {
		return "Nachbar Name: " + this.name + "Kanten: "+String.valueOf(kanten)+"\n";
	}

}
