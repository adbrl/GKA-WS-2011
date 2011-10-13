package graphen1;
import java.util.*;

public interface Nachbar {
	public abstract String name();
	public abstract int kanten();
	public abstract void add(Gewichtung gewicht);
	public abstract List<Gewichtung> kantengewichte();
	public abstract String toString();
	
	
}
