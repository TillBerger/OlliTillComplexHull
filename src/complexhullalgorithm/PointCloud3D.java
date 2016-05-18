package complexhullalgorithm;


public class PointCloud3D extends PointCloud {
	private double[][] points;
	private int size;
	
	public PointCloud3D(double[][] array){
		this.points = array;
		size = array.length;
	}
	
	
	@Override
	public double[] at(int index) {
		return points[index];
	}

	@Override
	public int numPoints() {
		return size;
	}

	@Override
	public int dimension() {
		return 3;
	}

}
