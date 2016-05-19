package complexhullalgorithm;

public abstract class VicinityRelation {
	public abstract int[] getNeighbourIndices(int index);
	public abstract int[] getNeighbourIndices(Polytop p);
	public abstract Polytop[] getNeighbours(int index);
	public abstract Polytop[] getNeighbours(Polytop p);
}
