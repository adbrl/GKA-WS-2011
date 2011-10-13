package graphen1;


public class NachbarUngewichtet extends NachbarImpl implements Nachbar {
	
	
	
	private NachbarUngewichtet(String name){
		this.name = name;
		this.kanten = 0;
	}
	

	public static NachbarImpl valueOf(String name){
		return new NachbarUngewichtet(name);
	}
	

}
