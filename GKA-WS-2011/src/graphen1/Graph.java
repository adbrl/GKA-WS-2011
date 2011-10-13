package graphen1;
import java.util.*;
public interface Graph {
	public abstract String toString();
	public abstract Graph toAdjMatrix();
	public abstract Graph toAdjList();
	public abstract String einleseString();
	public abstract int read();
	public abstract int write();
	public abstract Set<String> alleEcken();
	public abstract int anzahlEcken();
	public abstract List<String> bfs();
	public abstract List<Nachbar> nachbarn(String s);
}
