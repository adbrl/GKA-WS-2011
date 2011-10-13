package graphen1;

public interface Gewichtung {
	public abstract boolean unendlich();
	public abstract boolean keine();
	public abstract double gewichtung();
	public abstract int compareTo(Gewichtung g);
	public abstract String toString();
	public abstract Gewichtung add(Gewichtung g);
}
