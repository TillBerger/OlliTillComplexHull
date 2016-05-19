package complexhullalgorithm;

public abstract class Polytop {
	
	
	public abstract int getDimensionVectorSpace();
	public abstract int getDimensionSubSpace();
	public abstract boolean isVertex();
	
	public abstract Polytop[] getFaces();
	public abstract double[] getVertices();
	
	public abstract double[] getNormal();
	public abstract double getDistanceFromNull();
	public abstract double[] getNormalForm();
	
	public abstract VicinityRelation getVicinityRelation();
	public abstract Polytop getParent();
	public abstract int getIndex(int index);
	public abstract Polytop getFaceAt(int index);
	
	
	
	
}
